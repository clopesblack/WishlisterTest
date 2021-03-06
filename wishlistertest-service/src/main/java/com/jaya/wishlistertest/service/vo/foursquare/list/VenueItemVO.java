package com.jaya.wishlistertest.service.vo.foursquare.list;

import com.jaya.wishlistertest.service.vo.foursquare.PhotoVo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Caroline Lopes on 02/10/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class VenueItemVO {

    private VenueVO venue;
    private PhotoVo photo;
}
