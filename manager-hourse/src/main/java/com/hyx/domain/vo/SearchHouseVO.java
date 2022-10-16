package com.hyx.domain.vo;

import lombok.Data;

/**
 * @author hyx
 **/

@Data
public class SearchHouseVO {
    private String text;
    
    private Long lowValue;
    
    private Long highValue;
    
    private Byte type;
    
}
