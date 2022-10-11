package com.hyx.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 统一返回类.
 *
 * @author com.hyx
 **/

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    
    /**
     * 状态码.
     */
    private Integer code;
    
    /**
     * 信息相关描述.
     */
    private String message;
    
    /**
     * 统一返回类中的数据.
     */
    private T data;
    
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMessage(), data);
    }
    
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(CommonCode.SUCCESS.getCode(), message, data);
    }
    
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(CommonCode.FAILED.getCode(), message, null);
    }
    
    public static <T> CommonResult<T> failed(String message, T data) {
        return new CommonResult<T>(CommonCode.FAILED.getCode(), message, data);
    }
}
