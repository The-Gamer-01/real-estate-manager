package com.hyx.service;

import com.hyx.domain.vo.PersonalDataVO;
import com.hyx.domain.vo.UserUpdateVO;
import com.hyx.entity.UserInfo;

/**
 * UserInfo Service.
 *
 * @author hyx
 **/

public interface UserInfoService {
    
    /**
     * 根据account与password获取用户.
     * @param account 账号
     * @param password 密码
     * @return UserInfo
     */
    UserInfo getUser(String account, String password);
    
    PersonalDataVO getPersonalData(Long userId);
    
    String updateUser(Long userId, UserUpdateVO userUpdateVO);
}
