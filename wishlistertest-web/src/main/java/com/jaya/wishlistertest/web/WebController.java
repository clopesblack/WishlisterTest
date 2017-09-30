package com.jaya.wishlistertest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.webjars.RequireJS;

/**
 * Created by Caroline Lopes on 30/09/17.
 */
@Controller
public class WebController {

    @ResponseBody
    @RequestMapping(value = "/webjarsjs", produces = "application/javascript", method = RequestMethod.GET)
    public String webjarjs() {
        return RequireJS.getSetupJavaScript("/webjars/");
    }
}
