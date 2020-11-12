package com.dubbo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName RedisProperties
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/5 10:29
 * @Version 1.0
 **/
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private int expireSeconds;
    private String clusterNodes;
    private int commandTimeout;

    public int getExpireSeconds() {
        return expireSeconds;
    }

    @Value("${spring.redis.cluster.expireSeconds}")
    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getClusterNodes() {
        return clusterNodes;
    }

    @Value("${spring.redis.cluster.clusterNodes}")
    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public int getCommandTimeout() {
        return commandTimeout;
    }

    @Value("${spring.redis.cluster.commandTimeout}")
    public void setCommandTimeout(int commandTimeout) {
        this.commandTimeout = commandTimeout;
    }
}
