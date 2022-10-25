package com.hyx.controller;

import com.hyx.constant.WatcherStatusConstant;
import com.hyx.domain.vo.HouseInfoVO;
import com.hyx.page.Page;
import com.hyx.service.WatcherService;
import com.hyx.thread.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 关注Controller.
 *
 * @author hyx
 **/

@Slf4j
@RestController
public class WatcherController {
    
    @Autowired
    private WatcherService watcherService;
    
    /**
     * 关注接口.
     * @param houseId 房屋编号
     * @return 是否关注成功.
     */
    @PostMapping("/watch")
    public boolean watchHouse(Long houseId) {
        Long userId = UserThreadLocal.get();
        log.info("[WatcherController][userId: {}]", userId);
        return watcherService.changeWatchStatus(userId, houseId, WatcherStatusConstant.WATCH_STATUS);
    }
    
    /**
     * 取消关注接口.
     * @param id 房屋编号
     * @return 是否取消成功.
     */
    @PostMapping("/unwatch")
    public boolean unwatchHouse(@RequestParam Long id) {
        Long userId = UserThreadLocal.get();
        log.info("[WatcherController][userId: {}]", userId);
        return watcherService.changeWatchStatus(userId, id, WatcherStatusConstant.UN_WATCH_STATUS);
    }
    
    @GetMapping("/watch/list")
    public List<HouseInfoVO> getWatchList(Page page) {
        Long userId = UserThreadLocal.get();
        return watcherService.getWatchList(userId, page);
    }
    
}
