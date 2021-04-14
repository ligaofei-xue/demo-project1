package com.ligaofei.demoproject1.controller;

import com.ligaofei.demoproject1.config.WXConfig;
import com.ligaofei.demoproject1.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * SpringBoot注解配置文件映射属性和实体类
 * 实体类配置文件加载
 */
@RestController
@RequestMapping("api/v1/test")
public class TestController {

    @Autowired
    private WXConfig wxConfig;

    @GetMapping("get_config")
    public JsonData testConfig(){
        Map<String,String> map = new HashMap<>();
        map.put("appid",wxConfig.getPayAppid());
        map.put("secret",wxConfig.getPaySecret());
        map.put("mechid",wxConfig.getPayMechId());
        return JsonData.buildSuccess(map);
    }

    /**
     * 测试全局异常处理方法
     * @return
     */
    @GetMapping("list")
    public JsonData testExt(){
        int i = 1/0;
        return JsonData.buildSuccess("");
    }
}
