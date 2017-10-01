package com.jaya.wishlistertest.web;

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

    private FoursquareConfigs foursquareConfigs;

    @Autowired
    public LoginController(FoursquareConfigs foursquareConfigs) {
        this.foursquareConfigs = foursquareConfigs;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUrl(Model model) {
        model.addAttribute("floginurl", foursquareConfigs.getHost() + "?client_id=" + foursquareConfigs.getClientId() + "&response_type=code&redirect_uri=http://localhost:3000/foursquare/callback");
        return "login";
    }
}
