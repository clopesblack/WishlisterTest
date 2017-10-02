package com.jaya.wishlistertest.service.vo.foursquare.recentcheckin;

import com.jaya.wishlistertest.service.vo.foursquare.PhotoVo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Caroline Lopes on 01/10/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class RecentUserVO {

    private String id;
    private String firstName;
    private String lastName;
    private String relationship;
    private PhotoVo photo;

    public String getExibitionName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        }
        return "";
    }
}
