package com.hyx.exception;

import com.hyx.common.CommonCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 业务异常类.
 *
 * @author com.hyx
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class SimpleException extends RuntimeException {
    
    private Integer code;
    
    public SimpleException() {
        super();
    }
    
    public SimpleException(CommonCode commonCode) {
        super(commonCode.getMessage());
        this.code = commonCode.getCode();
    }
    
    public SimpleException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    
}
