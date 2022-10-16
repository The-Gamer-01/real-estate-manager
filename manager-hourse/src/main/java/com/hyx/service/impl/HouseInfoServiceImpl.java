package com.hyx.service.impl;

import com.hyx.domain.vo.CreateHouseVO;
import com.hyx.domain.vo.HouseInfoVO;
import com.hyx.domain.vo.SearchHouseVO;
import com.hyx.entity.HouseInfo;
import com.hyx.mapper.HouseInfoMapper;
import com.hyx.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyx
 **/

@Service
public class HouseInfoServiceImpl implements HouseInfoService {
    
    @Autowired
    private HouseInfoMapper houseInfoMapper;
    
    @Override
    public HouseInfo getHouse(long id) {
        return houseInfoMapper.getHouse(id);
    }
    
    @Override
    public boolean createHouse(CreateHouseVO createHouseVO) {
        Byte type = createHouseVO.getType();
        if (type == 1) {
            //二手房
            
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
}