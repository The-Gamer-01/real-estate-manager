package com.hyx.common;

/**
 * 统一返回类状态枚举类.
 *
 * @author com.hyx
 **/

public enum  CommonCode {
    /**
     * 操作成功的状态码.
     */
    SUCCESS(200, "操作成功"),
    /**
     * 操作失败的状态码.
     */
    FAILED(500, "操作失败");
    
    /**
     * 返回类状态码.
     */
    private final Integer code;
    
    /**
     * 返回状态描述.
     */
    private final String message;

    CommonCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public String getMessage() {
        return message;
    }
}
