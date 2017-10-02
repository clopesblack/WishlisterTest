package com.jaya.wishlistertest.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Caroline Lopes on 01/10/17.
 */
@Component
@ConfigurationProperties(prefix = "foursquare")
@Data
public class FoursquareConfigs {

    private String host;
    private String api;
    private String clientId;
    private String clientSecret;
    private String v;
    private String login;
    private String accesstoken;
    private String recentechekin;
    private String wishlist;
    private String users;
    private String oauthpath;
}
