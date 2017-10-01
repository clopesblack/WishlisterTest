package com.jaya.wishlistertest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Caroline Lopes on 30/09/17.
 */
@RestController
@RequestMapping("foursquare")
public class FoursquareResource {

    private FoursquareConfigs foursquareConfigs;

    @Autowired
    public FoursquareResource(FoursquareConfigs foursquareConfigs) {
        this.foursquareConfigs = foursquareConfigs;
    }

    @RequestMapping(value = "/loginurl", method = RequestMethod.GET)
    public String loginUrl() {
        return foursquareConfigs.getHost() + "?client_id=" + foursquareConfigs.getClientId() + "&response_type=code&redirect_uri=http://localhost:3000/foursquare/callback";
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String callback(@RequestParam("code") String code, HttpSession httpSession) {
        httpSession.setAttribute("fcode", "ieieieieiie");
        return code;
    }

}
