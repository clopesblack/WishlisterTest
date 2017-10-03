package com.jaya.wishlistertest.web;

import com.jaya.wishlistertest.service.FoursquareService;
import com.jaya.wishlistertest.service.vo.foursquare.list.VenueItemVO;
import com.jaya.wishlistertest.service.vo.foursquare.recentcheckin.RecentVO;
import com.jaya.wishlistertest.service.vo.foursquare.user.FoursquareUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Caroline Lopes on 30/09/17.
 */
@Controller
public class FoursquareController {

    private FoursquareService service;

    @Autowired
    public FoursquareController(FoursquareService service) {
        this.service = service;
    }

    @RequestMapping(value = "/foursquare/callback", method = RequestMethod.GET)
    public String callback(@RequestParam("code") String code, Model model, HttpSession session) {

        String accessToken = service.requestUserAccessToken(code);
        session.setAttribute("fuaccessToken", accessToken);

        fillModelToHome(model, accessToken);

        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {

        String fuaccessToken = (String) session.getAttribute("fuaccessToken");

        fillModelToHome(model, fuaccessToken);
        return "home";
    }

    private void fillModelToHome(Model model, String accessToken) {
        FoursquareUserVO userVO = service.requestUser(accessToken);
        model.addAttribute("user", userVO);

        List<VenueItemVO> venues = service.requestVenues(userVO, accessToken);
        model.addAttribute("wishlist", venues);

        List<RecentVO> recents = service.requestRecentChekinFriends(accessToken);
        model.addAttribute("recents", recents);
    }

}
