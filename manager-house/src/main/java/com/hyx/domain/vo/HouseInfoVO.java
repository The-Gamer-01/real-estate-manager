package com.hyx.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 房屋信息VO.
 *
 * @author hyx
 **/

@Data
public class HouseInfoVO {
    
    /**
     * 编号.
     */
    private Long id;
    
    /**
     * 住房名
     */
    private String title;
    
    /**
     * 住房类型
     */
    private Integer type;
    
    /**
     * 房型
     */
    private String layout;
    
    /**
     * 朝向
     */
    private String towards;
    
    /**
     * 校区名称
     */
    private String estate;
    
    /**
     * 所在楼层
     */
    private String floor;
    
    /**
     * 房屋价格(万)
     */
    private BigDecimal price;
    
    /**
     * 房屋面积（平方）
     */
    private Double size;
    
    /**
     * 房屋简介
     */
    private String intro;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
