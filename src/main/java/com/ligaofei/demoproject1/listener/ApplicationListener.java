package com.ligaofei.demoproject1.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 小滴课堂
 *
 * 应用上下文监听器
 * 应用启动监听,这个用的最多
 */

@WebListener
class ApplicationListener implements ServletContextListener {

    //启动应用会打印初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized====");
    }

    //热部署时会打印销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed====");
    }
}
