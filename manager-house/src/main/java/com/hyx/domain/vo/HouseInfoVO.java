package com.hyx.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * 房屋信息VO.
 *
 * @author hyx
 **/

@Data
public class HouseInfoVO {
    private String img;
    
    private String title;
    
    private Date createTime;
    
    private Integer price;
}
