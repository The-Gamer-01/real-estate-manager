package com.hyx.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 动态路由Service类.
 *
 * @author hyx
 **/

@Slf4j
@Service
public class DynamicRouteEventPublisherAware implements ApplicationEventPublisherAware {
    
    private final RouteDefinitionWriter routeDefinitionWriter;
    
    private ApplicationEventPublisher publisher;
    
    public DynamicRouteEventPublisherAware(RouteDefinitionWriter routeDefinitionWriter) {
        this.routeDefinitionWriter = routeDefinitionWriter;
    }
    
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
    
    /**
     * 批量更新路由.
     * @param routes 路由.
     * @return 是否更新成功.
     */
    public boolean updateByBatch(List<RouteDefinition> routes) {
        if (CollectionUtils.isEmpty(routes)) {
            return false;
        }
        try {
            routes.forEach(definition -> {
                this.routeDefinitionWriter.delete(Mono.just(definition.getId()));
            });
        } catch (Exception e) {
            log.error("update fail, delete error");
            e.printStackTrace();
        }
        try {
            routes.forEach(definition -> {
                routeDefinitionWriter.save(Mono.just(definition)).subscribe();
            });
            this.publisher.publishEvent(new RefreshRoutesEvent(this));
            log.info("");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
