package com.jaya.wishlistertest.service.vo.foursquare.recentcheckin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Caroline Lopes on 02/10/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class RecentVenueVO {

    private String id;
    private String name;
    private RecentLocationVO location;
    private String url;
}
