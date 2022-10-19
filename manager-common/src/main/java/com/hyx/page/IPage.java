package com.hyx.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果类.
 *
 * @author hyx
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPage<T> {
    
    private Integer total;
    
    private Integer pageNo;
    
    private Integer pageSize;
    
    private List<T> records;
}
