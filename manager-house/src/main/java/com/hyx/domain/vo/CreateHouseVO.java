package com.hyx.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 创建房屋VO.
 *
 * @author hyx
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateHouseVO {
    
    /**
     * 住房名.
     */
    private String title;
    
    /**
     * 住房类型.
     */
    private Integer type;
    
    /**
     * 详细地址.
     */
    private String address;
    
    /**
     * 房型.
     */
    private String layout;
    
    /**
     * 朝向.
     */
    private String towards;
    
    /**
     * 校区名称.
     */
    private String estate;
    
    /**
     * 所在楼层.
     */
    private String floor;
    
    /**
     * 房屋价格(万).
     */
    private BigDecimal price;
    
    /**
     * 房屋面积（平方）.
     */
    private Double size;
    
    /**
     * 房屋简介.
     */
    private String intro;
    
    /**
     * 详细信息.
     */
    private String detail;
    
    /**
     * 创建时间.
     */
    private LocalDateTime createTime;
}
