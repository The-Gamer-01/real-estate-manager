package com.hyx.domain.vo;

import lombok.Data;

/**
 * 房屋主相关信息.
 *
 * @author hyx
 **/

@Data
public class HouseOwnerData {
    
    private Long id;
    
    private String username;
    
    private String intro;
    
    private String tel;
    
    private String email;
}
