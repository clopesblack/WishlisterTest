package com.jaya.wishlistertest.service.vo.foursquare.recentcheckin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by Caroline Lopes on 02/10/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class ResponseRecentVo {
    private List<RecentVO> recent;
}
