package com.ligaofei.demoproject1.controller;

import com.ligaofei.demoproject1.config.WXConfig;
import com.ligaofei.demoproject1.task.AsyncTask;
import com.ligaofei.demoproject1.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * SpringBoot注解配置文件映射属性和实体类
 * 实体类配置文件加载
 */
@RestController
@RequestMapping("api/v1/test")
public class TestController {

    @Autowired
    private WXConfig wxConfig;
    @Autowired
    private AsyncTask asyncTask;

    /**
     * 测试异步方法
     * @return
     */
    @GetMapping("async")
    public JsonData testAsync(){
        long begin = System.currentTimeMillis();
        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();

        //异步任务Future获取结果,并行4秒串行8秒。
        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        //一定要拿到结果的话就死循环，也可以定义时间
        for(;;){
            if(task4.isDone() && task5.isDone()){
                try {

                    String task4Result = task4.get();
                    System.out.println(task4Result);

                    String task5Result = task5.get();
                    System.out.println(task5Result);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }finally {
                    break;
                }
            }
        }

        long end = System.currentTimeMillis();
        return JsonData.buildSuccess( end - begin);
    }

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
