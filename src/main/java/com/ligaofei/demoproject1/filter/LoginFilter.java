package com.ligaofei.demoproject1.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ligaofei.demoproject1.domain.User;
import com.ligaofei.demoproject1.service.impl.UserServiceImpl;
import com.ligaofei.demoproject1.utils.JsonData;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 过滤器
 *使用Servlet3.0的注解
 * 2.@WebFilter 标记一个类为filter，被spring进行扫描
 * urlPatterns：拦截规则，支持正则
 */
//@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 容器加载的时候
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter======");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("doFilter LoginFilter======");

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String token = req.getHeader("token");
        if(StringUtils.isEmpty(token)){
            token = req.getParameter("token");
        }

        if(!StringUtils.isEmpty(token)){
            //判断token是否合法
            User user = UserServiceImpl.sessionMap.get(token);
            if(user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                JsonData jsonData =  JsonData.buildError("登录失败，token无效",-2);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(resp,jsonStr);
            }
        }else {
            JsonData jsonData =  JsonData.buildError("未登录",-3);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(resp,jsonStr);
        }
    }

    /**
     * 返回未登录错误码
     * @param response
     * @param json
     */
    private void renderJson(HttpServletResponse response,String json){

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        try(PrintWriter writer = response.getWriter()){
            writer.print(json);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 容器销毁的时候
     */
    @Override
    public void destroy() {
        System.out.println("destroy LoginFilter======");

    }
}
