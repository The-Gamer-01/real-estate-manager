package com.hyx.domain.vo;

import lombok.Data;

/**
 * 房屋详细信息VO.
 *
 * @author hyx
 **/

@Data
public class HouseDetailVO {
    private HouseInfoVO house;

    private HouseOwnerData user;
}
