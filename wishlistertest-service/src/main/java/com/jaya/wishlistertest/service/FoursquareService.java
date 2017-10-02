package com.jaya.wishlistertest.service;

import com.jaya.wishlistertest.service.vo.FoursquareAcessTokenResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Caroline Lopes on 01/10/17.
 */
@Service
public class FoursquareService {

    private final String LOGIN_REDIRECT_END_POINT = "http://localhost:3000/foursquare/callback";
    private final String ACCESS_TOKEN_REDIRECT_END_POINT = "http://localhost:3000/foursquare/callback/accesstoken";
    private final String OAUTH_PATH = "/oauth2";

    private FoursquareConfigs foursquareConfigs;
    private RestTemplate restTemplate;

    @Autowired

    public FoursquareService(FoursquareConfigs foursquareConfigs, RestTemplate restTemplate) {
        this.foursquareConfigs = foursquareConfigs;
        this.restTemplate = restTemplate;
    }

    public String requestUserAccessToken(String code) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(this.foursquareConfigs.getHost() + this.OAUTH_PATH + "/access_token")
                .queryParam("client_id", this.foursquareConfigs.getClientId())
                .queryParam("client_secret", this.foursquareConfigs.getClientSecret())
                .queryParam("grant_type", "authorization_code")
                .queryParam("redirect_uri", this.ACCESS_TOKEN_REDIRECT_END_POINT)
                .queryParam("code", code);

        FoursquareAcessTokenResponseVO response = restTemplate.getForObject(uriBuilder.toUriString(), FoursquareAcessTokenResponseVO.class);
        return response.getAccess_token();
    }

    public String getLoginUrl() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(this.foursquareConfigs.getHost() + this.OAUTH_PATH + "/authenticate")
                .queryParam("client_id", this.foursquareConfigs.getClientId())
                .queryParam("response_type", "code")
                .queryParam("redirect_uri", this.LOGIN_REDIRECT_END_POINT);

        return uriBuilder.toUriString();
    }

}
