package com.hyx.controller;

import com.hyx.domain.vo.CreateHouseVO;
import com.hyx.domain.vo.HouseInfoVO;
import com.hyx.domain.vo.SearchHouseVO;
import com.hyx.entity.HouseInfo;
import com.hyx.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * House Controller.
 *
 * @author hyx
 **/

@RestController
@RequestMapping("/house")
public class HouseController {
    
    @Autowired
    private HouseInfoService houseInfoService;
    
    @GetMapping("/{id}")
    public HouseInfo getHouse(@PathVariable String id) {
        return houseInfoService.getHouse(Long.parseLong(id));
    }
    
    @PostMapping("/")
    public boolean createHouse(CreateHouseVO createHouseVO) {
        return houseInfoService.createHouse(createHouseVO);
    }
    
    @DeleteMapping("/{id}")
    public boolean deleteHouse(@PathVariable String id) {
        return houseInfoService.deleteHouse(Long.parseLong(id));
    }
    
    @GetMapping("/search")
    public List<HouseInfoVO> searchHouse(SearchHouseVO searchHouseVO) {
        return houseInfoService.searchHouse(searchHouseVO);
    }
    
}
