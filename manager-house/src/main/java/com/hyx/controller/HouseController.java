package com.hyx.controller;

import com.hyx.common.CommonCode;
import com.hyx.domain.vo.CreateHouseVO;
import com.hyx.domain.vo.HouseDetailVO;
import com.hyx.domain.vo.HouseInfoVO;
import com.hyx.domain.vo.SearchHouseVO;
import com.hyx.exception.SimpleException;
import com.hyx.page.IPage;
import com.hyx.page.Page;
import com.hyx.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * House Controller.
 *
 * @author hyx
 **/

@RestController
public class HouseController {
    
    @Autowired
    private HouseInfoService houseInfoService;
    
    @GetMapping("/detail")
    public HouseDetailVO getHouse(@RequestParam String id) {
        return houseInfoService.getHouse(Long.parseLong(id));
    }
    
    @PostMapping("/create")
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
    
    @GetMapping("/list")
    public IPage<HouseInfoVO> getHouseInfoList(@RequestParam Integer pageNo, Integer pageSize) {
        Page page = new Page(pageNo - 1, pageSize);
        if (page.getPageNo() == null || page.getPageSize() == null) {
            throw new SimpleException(CommonCode.FAILED.getCode(), "参数校验错误");
        }
        return houseInfoService.getHouseInfoList(page);
    }
    
}
