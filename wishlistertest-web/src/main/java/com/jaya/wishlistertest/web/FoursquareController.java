package com.jaya.wishlistertest.web;

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
public class FoursquareController {

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String callback(@RequestParam("code") String code, HttpSession httpSession) {
        httpSession.setAttribute("fcode", "ieieieieiie");
        return code;
    }
}
