package com.ligaofei.demoproject1.handler;


import com.ligaofei.demoproject1.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 标记这个是一个异常处理类
 * 增加此类后访问/api/v1/test/list会提示以下信息。不加则是springboot默认返回的一堆
 * {
 * 	"code": -2,
 * 	"data": "",
 * 	"msg": "服务端出问题了"
 * }
 */

/**
 * 和Controller-RestController一样
 * 返回json用RestControllerAdvice，返回页面用ControllerAdvice
 */
//@RestControllerAdvice
@ControllerAdvice
public class CustomExtHandler {

    /**
     * SpringBoot自定义返回json异常错误
     */
//    @ExceptionHandler(value = Exception.class)
//    JsonData handlerException(Exception e, HttpServletRequest request){
//        return JsonData.buildError("服务端出问题了", -2);
//    }

    /**
     * SpringBoot自定义异常错误页面跳转
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    Object handlerException2(Exception e, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        System.out.println(e.getMessage());
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;
    }
}
