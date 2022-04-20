package com.limyel.blog.common.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "blog.elasticsearch")
public class ElasticsearchProperties {

    /**
     * 请求协议
     */
    private String schema;

    /**
     * 集群名称
     */
    private String clusterName;

    /**
     * 集群节点
     */
    @NotNull(message = "集群节点不允许为空")
    private List<String> clusterNodes;

    /**
     * 连接超时时间(毫秒)
     */
    private Integer connectTimeout;

    /**
     * socket 超时时间
     */
    private Integer socketTimeout;

    /**
     * 连接请求超时时间
     */
    private Integer connectionRequestTimeout;

    /**
     * 每个路由的最大连接数量
     */
    private Integer maxConnectPerRoute;

    /**
     * 最大连接总数量
     */
    private Integer maxConnectTotal;

    /**
     * 索引配置信息
     */
    private Index index;

    /**
     * 认证账户
     */
    private Account account = new Account();

    /**
     * 索引配置信息
     */
    @Getter
    @Setter
    public static class Index {

        /**
         * 分片数量
         */
        private Integer numberOfShards;

        /**
         * 副本数量
         */
        private Integer numberOfReplicas;

    }

    /**
     * 认证账户
     */
    @Data
    public static class Account {

        /**
         * 认证用户
         */
        private String username;

        /**
         * 认证密码
         */
        private String password;

    }

}