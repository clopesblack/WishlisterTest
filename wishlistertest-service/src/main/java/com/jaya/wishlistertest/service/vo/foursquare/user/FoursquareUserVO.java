package com.jaya.wishlistertest.service.vo.foursquare.user;

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
public class FoursquareUserVO {

    private String id;
    private String firstName;
    private String lastName;
    private PhotoVo photo;
    private ListsVO lists;

    public String getExibitionName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        }
        return "";
    }
}
