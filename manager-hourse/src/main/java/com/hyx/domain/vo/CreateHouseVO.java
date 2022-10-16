package com.hyx.domain.vo;

import lombok.Data;

/**
 * @author hyx
 **/

@Data
public class CreateHouseVO {
    
    private String name;
    
    private String description;
    
    private String address;
    
    private Byte type;
    
}
