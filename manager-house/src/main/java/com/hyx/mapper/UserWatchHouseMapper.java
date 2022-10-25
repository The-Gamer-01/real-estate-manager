package com.hyx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hyx
 **/

@Mapper
public interface UserWatchHouseMapper {
    
    boolean changeWatchStatus(@Param("userId") Long userId, @Param("houseId") Long id, @Param("status") Byte watchStatus);
    
    boolean createWatchStatus(@Param("userId") Long userId, @Param("houseId") Long id, @Param("status") Byte watchStatus);
    
    int selectCount(Long userId, Long id);
}
