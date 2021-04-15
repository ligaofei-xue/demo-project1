package com.ligaofei.demoproject1.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步任务类
 */
@Component//使用@Component标记组件被容器扫描
@Async//异步方法加上@Async,这儿加上所有的方法都是异步
public class AsyncTask {

    public void task1(){

        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" task 1 ");

    }

    public void task2(){
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" task 2 ");
    }

    public void task3(){
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" task 3 ");
    }

    public Future<String> task4(){
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" task 4 ");

        return new AsyncResult<String>("task4");
    }

    public Future<String> task5(){
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" task 5 ");
        return new AsyncResult<String>("task5");
    }

}
