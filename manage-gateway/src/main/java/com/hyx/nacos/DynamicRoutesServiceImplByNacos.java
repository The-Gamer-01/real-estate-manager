package com.hyx.nacos;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * 动态路由.
 *
 * @author hyx
 **/

@Slf4j
@Component
public class DynamicRoutesServiceImplByNacos implements CommandLineRunner {
    
    private final NacosConfig nacosConfig;
    
    private DynamicRouteEventPublisherAware publisher;
    
    public DynamicRoutesServiceImplByNacos(DynamicRouteEventPublisherAware publisher, NacosConfig nacosConfig) {
        this.nacosConfig = nacosConfig;
        this.publisher = publisher;
    }
    
    private void dynamicRouteByNacosListener() {
        try {
            ConfigService configService = NacosFactory.createConfigService(nacosConfig.getAddress());
            String content = configService.getConfig(nacosConfig.getDataId(),
                    nacosConfig.getGroupId(), nacosConfig.getTimeOut());
            List<RouteDefinition> list = JSON.parseArray(content, RouteDefinition.class);
            if (!CollectionUtils.isEmpty(list)) {
                publisher.updateByBatch(list);
                configService.addListener(nacosConfig.getDataId(), nacosConfig.getGroupId(), new Listener() {
                    @Override
                    public Executor getExecutor() {
                        return null;
                    }
                
                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        List<RouteDefinition> list = JSON.parseArray(configInfo, RouteDefinition.class);
                        publisher.updateByBatch(list);
                    }
                });
            }
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(String... args) throws Exception {
        dynamicRouteByNacosListener();
    }
}
