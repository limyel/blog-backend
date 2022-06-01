package com.limyel.blog.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private List<HandlerMethodArgumentResolver> handlerMethodArgumentResolvers;

    /**
     * 跨域
     * @param registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600)
                .allowedOrigins("*");

        super.addCorsMappings(registry);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 身份验证
//        registry.addInterceptor(new AuthorizetionInterceptor())
//                .addPathPatterns("/**");

        super.addInterceptors(registry);
    }


    /**
     * controller 的参数解析
     * @param argumentResolvers
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

        argumentResolvers.addAll(handlerMethodArgumentResolvers);

        super.addArgumentResolvers(argumentResolvers);
    }
}
