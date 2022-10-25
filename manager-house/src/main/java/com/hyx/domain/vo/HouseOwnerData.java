package com.hyx.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
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
