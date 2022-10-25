package com.hyx.advise;

import com.hyx.thread.UserThreadLocal;
import com.hyx.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用以从token中取出UserId的切面.
 *
 * @author hyx
 **/

@Slf4j
@Aspect
@Component
public class UserIdAdvise {
    
    private static final String TOKEN_NAME = "real_user_token";
    
    @Pointcut("execution(public * com.hyx.controller.*.*(..)))")
    public void pointCut() {
    
    }
    
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String token = request.getHeader(TOKEN_NAME);
        if (token == null) {
            return;
        }
        Long userId = JwtUtil.getUserId(token);
        log.info("[UserIdAdvise][userId: {}]", userId);
        UserThreadLocal.put(userId);
    }
}
