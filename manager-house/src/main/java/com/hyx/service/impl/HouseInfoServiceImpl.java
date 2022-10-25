package com.hyx.service.impl;

import com.hyx.domain.vo.CreateHouseVO;
import com.hyx.domain.vo.HouseDetailVO;
import com.hyx.domain.vo.HouseInfoVO;
import com.hyx.domain.vo.HouseOwnerData;
import com.hyx.domain.vo.SearchHouseVO;
import com.hyx.mapper.HouseInfoMapper;
import com.hyx.page.IPage;
import com.hyx.page.Page;
import com.hyx.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * House Service Impl.
 *
 * @author hyx
 **/

@Service
public class HouseInfoServiceImpl implements HouseInfoService {
    
    @Autowired
    private HouseInfoMapper houseInfoMapper;
    
    @Override
    public HouseDetailVO getHouse(long id) {
        HouseInfoVO houseInfo = houseInfoMapper.getHouseDetail(id);
        
        HouseOwnerData houseOwnerData = new HouseOwnerData();
        houseOwnerData.setEmail("TEST@163.com");
        houseOwnerData.setIntro("简介");
        houseOwnerData.setTel("123");
        houseOwnerData.setUsername("hyx");
        houseOwnerData.setId(1L);
        
        HouseDetailVO houseDetailVO = new HouseDetailVO();
        houseDetailVO.setHouse(houseInfo);
        houseDetailVO.setUser(houseOwnerData);
        return houseDetailVO;
    }
    
    @Override
    public boolean createHouse(CreateHouseVO createHouseVO) {
        Integer type = createHouseVO.getType();
        if (type == 1) {
            //二手房
            houseInfoMapper.createHouse(createHouseVO);
        } else if (type == 2) {
            //租房
            
        }
        return false;
    }
    
    @Override
    public boolean deleteHouse(long id) {
        int num = houseInfoMapper.deleteById(id);
        return num != 0;
    }
    
    @Override
    public List<HouseInfoVO> searchHouse(SearchHouseVO searchHouseVO) {
        return null;
    }
    
    @Override
    public IPage<HouseInfoVO> getHouseInfoList(Page page) {
        IPage<HouseInfoVO> result = new IPage<>();
        
        List<HouseInfoVO> houses = houseInfoMapper.getHouseInfoList(page);
        Integer total = houseInfoMapper.selectTotal();
        
        result.setPageNo(page.getPageNo());
        result.setPageSize(page.getPageSize());
        result.setRecords(houses);
        result.setTotal(total);
        return result;
    }
}
