package com.demo.myspringboot.asyn.service.impl;

import com.demo.myspringboot.asyn.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;


/**
 * @version 1.0
 * @className AsyncServiceImpl
 * @Author xiaolu
 * @date 2021/4/5 14:20
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService{

    /**
     * @Async注解表示异步，后面的参数对应于线程池配置类ExecutorConfig中的方法名asyncServiceExecutor()，
     * 如果不写后面的参数，直接使用@Async注解，则是使用默认的线程池
     * Future<String>为异步返回的结果。可以通过get()方法获取结果。
     *
     */
    @Async("asyncServiceExecutor")
    public Future<String> getDataResult( ){
        log.info("开始异步处理");
        String result=Thread.currentThread().getName()+":asyncResultTest";
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<String>(result);
    }
}