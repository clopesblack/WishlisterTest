package com.jaya.wishlistertest.web;

import com.jaya.wishlistertest.service.FoursquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Caroline Lopes on 01/10/17.
 */
@Controller
public class LoginController {

    private FoursquareService foursquareService;

    @Autowired
    public LoginController(FoursquareService foursquareService) {
        this.foursquareService = foursquareService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUrl(Model model) {
        model.addAttribute("floginurl", foursquareService.getLoginUrl());
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginUrl() {
        return "home";
    }
}
