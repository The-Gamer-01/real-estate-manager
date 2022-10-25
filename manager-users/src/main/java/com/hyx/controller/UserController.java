package com.hyx.controller;

import com.hyx.common.CommonCode;
import com.hyx.domain.vo.LoginVO;
import com.hyx.domain.vo.PersonalDataVO;
import com.hyx.domain.vo.UserUpdateVO;
import com.hyx.entity.UserInfo;
import com.hyx.exception.SimpleException;
import com.hyx.service.UserInfoService;
import com.hyx.thread.UserThreadLocal;
import com.hyx.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserInfo controller.
 *
 * @author hyx
 **/

@RestController
public class UserController {
    
    @Autowired
    private UserInfoService userInfoService;
    
    /**
     * 登录接口.
     * @param loginVO Login VO
     * @return Token
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginVO loginVO) {
        UserInfo userInfo = userInfoService.getUser(loginVO.getAccount(), loginVO.getPassword());
        if (userInfo != null) {
            return JwtUtil.createToken(Long.parseLong(userInfo.getAccount()));
        } else {
            throw new SimpleException(CommonCode.FAILED.getCode(), "登录失败,账号或密码错误");
        }
    }
    
    @GetMapping("/personal")
    public PersonalDataVO getPersonalData() {
        Long userId = UserThreadLocal.get();
        return userInfoService.getPersonalData(userId);
    }
    
    @PostMapping("/update")
    public String updateUser(UserUpdateVO userUpdateVO) {
        Long userId = UserThreadLocal.get();
        return userInfoService.updateUser(userId, userUpdateVO);
    }
}
