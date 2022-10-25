package com.hyx.controller;

import com.hyx.domain.vo.HouseInfoVO;
import com.hyx.domain.vo.OwnerHouseVO;
import com.hyx.entity.UserInfo;
import com.hyx.page.Page;
import com.hyx.thread.UserThreadLocal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hyx
 **/

@RestController
@RequestMapping("/owner")
public class HouseOwnerController {
    
    @GetMapping("/house/list")
    public List<HouseInfoVO> getHouseListByOwner(Page page) {
        return null;
    }
    
    @GetMapping("/user/list")
    public List<UserInfo> getUserListByHouseId(OwnerHouseVO ownerHouseVO) {
        Long userId = UserThreadLocal.get();
        return null;
    }
}
