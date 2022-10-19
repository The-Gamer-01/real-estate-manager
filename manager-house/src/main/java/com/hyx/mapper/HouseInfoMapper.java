package com.hyx.mapper;

import com.hyx.domain.vo.HouseInfoVO;
import com.hyx.entity.HouseInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyx.page.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口.
 * </p>
 *
 * @author hyx
 * @since 2022-10-14
 */

@Mapper
public interface HouseInfoMapper extends BaseMapper<HouseInfo> {
    
    @Select("SELECT * FROM house_info WHERE id = #{id}")
    HouseInfo getHouse(@Param("id") long id);
    
    Integer selectTotal();
    
    List<HouseInfoVO> getHouseInfoList(@Param("page") Page page);
}
