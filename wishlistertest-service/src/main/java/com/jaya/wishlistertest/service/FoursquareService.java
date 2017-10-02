package com.jaya.wishlistertest.service;

import com.jaya.wishlistertest.service.vo.foursquare.list.FoursquareListResponseVO;
import com.jaya.wishlistertest.service.vo.foursquare.list.VenueItemVO;
import com.jaya.wishlistertest.service.vo.foursquare.recentcheckin.FoursquareRecentResponseVO;
import com.jaya.wishlistertest.service.vo.foursquare.recentcheckin.RecentVO;
import com.jaya.wishlistertest.service.vo.foursquare.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Caroline Lopes on 01/10/17.
 */
@Service
public class FoursquareService {

    private FoursquareConfigs foursquareConfigs;
    private RestTemplate restTemplate;

    @Autowired

    public FoursquareService(FoursquareConfigs foursquareConfigs, RestTemplate restTemplate) {
        this.foursquareConfigs = foursquareConfigs;
        this.restTemplate = restTemplate;
    }

    public String requestUserAccessToken(String code) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(this.foursquareConfigs.getHost() + this.foursquareConfigs.getOauthpath() + "/access_token")
                .queryParam("client_id", this.foursquareConfigs.getClientId())
                .queryParam("client_secret", this.foursquareConfigs.getClientSecret())
                .queryParam("grant_type", "authorization_code")
                .queryParam("redirect_uri", this.foursquareConfigs.getAccesstoken())
                .queryParam("code", code);

        FoursquareAcessTokenResponseVO response = restTemplate.getForObject(uriBuilder.toUriString(), FoursquareAcessTokenResponseVO.class);
        return response.getAccess_token();
    }

    public String getLoginUrl() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(this.foursquareConfigs.getHost() + this.foursquareConfigs.getOauthpath() + "/authenticate")
                .queryParam("client_id", this.foursquareConfigs.getClientId())
                .queryParam("response_type", "code")
                .queryParam("redirect_uri", this.foursquareConfigs.getLogin());

        return uriBuilder.toUriString();
    }

    public FoursquareUserVO requestUser(String accessToken) {

        String endPoint = toAuthenticableURL(UriComponentsBuilder.fromHttpUrl(this.foursquareConfigs.getApi() + this.foursquareConfigs.getUsers() + "/self"), accessToken);
        FoursquareUserResponseVO response = restTemplate.getForObject(endPoint, FoursquareUserResponseVO.class);
        return response.getResponse().getUser();
    }

    public List<VenueItemVO> requestVenues(FoursquareUserVO userVO, String accessToken) {

        ItemVO wishlist = filterWishList(userVO.getLists());
        String endPoint = toAuthenticableURL(UriComponentsBuilder.fromHttpUrl(this.foursquareConfigs.getApi() + this.foursquareConfigs.getWishlist() + "/" + wishlist.getId()), accessToken);
        FoursquareListResponseVO response = restTemplate.getForObject(endPoint, FoursquareListResponseVO.class);
        return response.getResponse().getList().getListItems().getItems();
    }

    private String toAuthenticableURL(UriComponentsBuilder uriBuilder, String accessToken) {
        return uriBuilder.queryParam("oauth_token", accessToken)
                .queryParam("v", this.foursquareConfigs.getV()).toUriString();
    }

    public List<RecentVO> requestRecentChekinFriends(String accessToken) {
        String endPoint = toAuthenticableURL(UriComponentsBuilder.fromHttpUrl(this.foursquareConfigs.getApi() + this.foursquareConfigs.getRecentechekin()), accessToken);
        FoursquareRecentResponseVO response = restTemplate.getForObject(endPoint, FoursquareRecentResponseVO.class);
        return response.getResponse().getRecent();
    }

    // TODO Improve filter mechanism
    private ItemVO filterWishList(ListsVO listsVO) {

        List<GroupVO> groups = listsVO.getGroups().stream().filter(v -> v.getType().equals("created")).collect(Collectors.toList());
        if (!groups.isEmpty()) {
            List<ItemVO> wishlist = groups.get(0).getItems().stream().filter(i -> i.getName().equals("wishlist")).collect(Collectors.toList());
            if (!wishlist.isEmpty()) {
                return wishlist.get(0);
            }

        }
        return null;
    }
}
