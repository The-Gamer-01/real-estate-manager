package com.hyx.nacos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Nacos Config配置文件.
 *
 * @author hyx
 **/

@Data
@Configuration
@ConfigurationProperties(prefix = "time.nacos.gateway")
public class NacosConfig {
    
    /**
     * Nacos地址.
     */
    private String address;
    
    /**
     * 数据编号.
     */
    private String dataId;
    
    /**
     * 分组编号.
     */
    private String groupId;
    
    /**
     * 超时时间.
     */
    private Long timeOut;
}
