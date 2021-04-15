package com.ligaofei.demoproject1.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 拦截器配置类
 * 不止做登录，可以拦截用户访问路径，可以做权限控制，日志控制等
 */
@Configuration
class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册拦截器并配置拦截器路径
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/api/v1/pri/**");
        //演示多个拦截器（按照注册顺序进行拦截，先注册，先被拦截）
        registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api/v1/pri/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }



//    这个注释代码是视频未讲的，补充知识点哈
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/api/v1/pri/**","/api/v1/pri/user/**")
//        .excludePathPatterns("/**/*.html","/**/*.js"); //配置不拦截某些路径;
//
//        registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api/v1/pri/**")
//
//
//        WebMvcConfigurer.super.addInterceptors(registry);
//
//
//    }


    @Bean
    public LoginIntercepter getLoginInterceptor(){
        return new LoginIntercepter();
    }
}
