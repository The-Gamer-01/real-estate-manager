package com.hyx.domain.vo;

import com.hyx.entity.HouseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyx
 **/

@Data
public class HouseDetailVO {
    private HouseInfoVO house;

    private HouseOwnerData user;
}
