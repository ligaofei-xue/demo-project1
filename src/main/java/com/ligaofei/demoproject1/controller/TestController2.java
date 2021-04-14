package com.ligaofei.demoproject1.controller;

import com.ligaofei.demoproject1.config.WXConfig;
import com.ligaofei.demoproject1.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * SpringBoot注解配置文件映射属性和实体类
 * 配置文件加载
 */
@RestController
@RequestMapping("api/v1/test")
@PropertySource(value = "classpath:pay.properties")
public class TestController2 {

    @Value("${wxpay.appid}")
    private String payAppid;
    @Value("${wxpay.secret}")
    private String paySecret;
    @Value("${wxpay.mechid}")
    private String payMechId;;

    @GetMapping("get_config2")
    public JsonData testConfig(){
        Map<String,String> map = new HashMap<>();
        map.put("appid",payAppid);
        map.put("secret",paySecret);
        map.put("mechid",payMechId);
        return JsonData.buildSuccess(map);
    }
}
