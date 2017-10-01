package com.jaya.wishlistertest.resource;

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
    private String clientId;
}
