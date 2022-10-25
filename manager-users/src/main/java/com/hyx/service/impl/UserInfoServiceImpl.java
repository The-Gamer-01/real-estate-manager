package com.hyx.service.impl;

import com.hyx.domain.vo.PersonalDataVO;
import com.hyx.domain.vo.UserUpdateVO;
import com.hyx.entity.UserInfo;
import com.hyx.mapper.UserInfoMapper;
import com.hyx.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserInfo Service Impl.
 *
 * @author hyx
 **/

@Service
public class UserInfoServiceImpl implements UserInfoService {
    
    @Autowired
    private UserInfoMapper userInfoMapper;
    
    @Override
    public UserInfo getUser(String account, String password) {
        return userInfoMapper.getUser(account, password);
    }
    
    @Override
    public PersonalDataVO getPersonalData(Long userId) {
        return userInfoMapper.getPersonalData(userId);
    }
    
    @Override
    public String updateUser(Long userId, UserUpdateVO userUpdateVO) {
        userInfoMapper.updateUser(userId, userUpdateVO);
        return null;
    }
}
