package com.hyx.service;

import com.hyx.domain.vo.HouseInfoVO;
import com.hyx.page.Page;

import java.util.List;

/**
 * 关注Service.
 *
 * @author hyx
 **/

public interface WatcherService {
    
    boolean changeWatchStatus(Long userId, Long id, Byte watchStatus);
    
    List<HouseInfoVO> getWatchList(Long userId, Page page);
}
