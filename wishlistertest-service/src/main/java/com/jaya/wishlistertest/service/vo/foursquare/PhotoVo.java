package com.jaya.wishlistertest.service.vo.foursquare;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Caroline Lopes on 01/10/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class PhotoVo {

    private String prefix;
    private String suffix;

    public String getPhotoIn(Integer resolution) {
        if (prefix != null && suffix != null) {
            return prefix + resolution + 'x' + resolution + suffix;
        }
        return "";
    }
}
