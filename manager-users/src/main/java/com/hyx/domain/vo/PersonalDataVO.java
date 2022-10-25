package com.hyx.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 个人信息VO.
 *
 * @author hyx
 **/

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDataVO {
    
    /**
     * 用户名.
     */
    private String username;
    
    /**
     * 用户简介.
     */
    private String intro;
    
    /**
     * 联系电话.
     */
    private String tel;
    
    /**
     * 邮箱.
     */
    private String email;
    
    /**
     * 性别.
     */
    private Integer sex;
}
