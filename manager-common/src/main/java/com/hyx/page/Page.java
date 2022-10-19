package com.hyx.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页请求类.
 *
 * @author hyx
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    
    /**
     * page页.
     */
    private Integer pageNo;
    
    /**
     * page大小.
     */
    private Integer pageSize;
}
