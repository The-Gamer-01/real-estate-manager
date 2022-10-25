package com.hyx.service;

import com.hyx.domain.vo.CreateHouseVO;
import com.hyx.domain.vo.HouseDetailVO;
import com.hyx.domain.vo.HouseInfoVO;
import com.hyx.domain.vo.SearchHouseVO;
import com.hyx.entity.HouseInfo;
import com.hyx.page.IPage;
import com.hyx.page.Page;

import java.util.List;

/**
 * House Service.
 *
 * @author hyx
 **/

public interface HouseInfoService {
    
    /**
     * 根据id获取房屋信息.
     * @param id 房屋编号.
     * @return 房屋信息
     */
    HouseDetailVO getHouse(long id);
    
    /**
     * 创建房屋信息.
     * @param createHouseVO 创建房屋信息参数.
     * @return 是否创建成功
     */
    boolean createHouse(CreateHouseVO createHouseVO);
    
    /**
     * 删除房屋信息.
     * @param id 房屋编号.
     * @return 是否删除成功.
     */
    boolean deleteHouse(long id);
    
    /**
     * 根据筛选信息筛选房屋.
     * @param searchHouseVO 筛选信息.
     * @return 房屋信息列表.
     */
    List<HouseInfoVO> searchHouse(SearchHouseVO searchHouseVO);
    
    IPage<HouseInfoVO> getHouseInfoList(Page page);
}
