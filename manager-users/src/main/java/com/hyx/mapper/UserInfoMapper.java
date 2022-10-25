package com.hyx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyx.domain.vo.PersonalDataVO;
import com.hyx.domain.vo.UserUpdateVO;
import com.hyx.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口.
 * </p>
 *
 * @author hyx
 * @since 2022-10-20
 */

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    
    UserInfo getUser(@Param("account") String account, @Param("password") String password);
    
    PersonalDataVO getPersonalData(@Param("userId") Long userId);
    
    void updateUser(Long userId, UserUpdateVO userUpdateVO);
}
