package com.jaya.wishlistertest.web;

import com.jaya.wishlistertest.service.FoursquareService;
import com.jaya.wishlistertest.service.vo.foursquare.FoursquareUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Caroline Lopes on 30/09/17.
 */
@Controller
@RequestMapping("foursquare")
public class FoursquareController {

    private FoursquareService service;

    @Autowired
    public FoursquareController(FoursquareService service) {
        this.service = service;
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String callback(@RequestParam("code") String code, Model model, HttpSession session) {

        String accessToken = service.requestUserAccessToken(code);
        session.setAttribute("fuaccessToken", accessToken);

        FoursquareUserVO userVO = service.requestUser(accessToken);
        model.addAttribute("user", userVO);

        return "home";
    }
}
