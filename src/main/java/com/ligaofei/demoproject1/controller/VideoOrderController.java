package com.ligaofei.demoproject1.controller;

import com.ligaofei.demoproject1.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * pri被LoginFilter拦截，必须写到token才可访问
 */
@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {

    @RequestMapping("save")
    public JsonData saveOrder(){
        return JsonData.buildSuccess("下单成功");
    }

}
