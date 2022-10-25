package com.hyx.filter;

import com.hyx.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 权限校验Filter.
 *
 * @author hyx
 **/

@Slf4j
@Component
public class PermissionFilter implements GlobalFilter, Ordered {
    
    private static final String TOKEN_NAME = "real_user_token";
    
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("filter: 拦截方法, 拦截请求后自动执行");
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String token = headers.get(TOKEN_NAME).get(0);
        Long userId = JwtUtil.getUserId(token);
        return chain.filter(exchange);
    }
    
    @Override
    public int getOrder() {
        return 100;
    }
}
