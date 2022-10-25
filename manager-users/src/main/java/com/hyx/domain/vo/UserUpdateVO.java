package com.hyx.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新信息VO.
 *
 * @author hyx
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateVO {
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
     * 性别.
     */
    private Integer sex;
}
