package com.hyx.service.impl;

import com.hyx.domain.vo.HouseInfoVO;
import com.hyx.mapper.UserWatchHouseMapper;
import com.hyx.page.Page;
import com.hyx.service.WatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyx
 **/

@Service
public class WatcherServiceImpl implements WatcherService {
    
    @Autowired
    private UserWatchHouseMapper userWatchHouseMapper;
    
    @Override
    public boolean changeWatchStatus(Long userId, Long id, Byte watchStatus) {
        if (userWatchHouseMapper.selectCount(userId, id) != 0) {
            return userWatchHouseMapper.changeWatchStatus(userId, id, watchStatus);
        } else {
            return userWatchHouseMapper.createWatchStatus(userId, id, watchStatus);
        }
    }
    
    @Override
    public List<HouseInfoVO> getWatchList(Long userId, Page page) {
        return null;
    }
}
