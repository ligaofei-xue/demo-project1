package com.ligaofei.demoproject1.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * 定时任务类
 * 定时统计订单,金额
 */
@Component//定时任务业务类 加注解 @Component被容器扫描
class VideoOrderTask {

    //@Scheduled(fixedDelay = 4000)//上一次开始执行时间点后xx秒再次执行
    @Scheduled(fixedRate = 4000)//上一次执行结束时间点后xx秒再次执行
    //@Scheduled(fixedRate = 2000) //每2秒执行一次
    public void sum(){
        //正常的是从数据库中查询
        System.out.println(LocalDateTime.now() + " 当前交易额="+ Math.random());

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
