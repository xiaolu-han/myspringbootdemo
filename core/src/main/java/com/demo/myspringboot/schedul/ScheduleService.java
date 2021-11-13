package com.demo.myspringboot.schedul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @className ScheduleService
 * @Author xiaolu
 * @date 2021/4/5 14:46
 */
@Slf4j
@Service
public class ScheduleService     {

//    @Scheduled(cron = "0/5 * * * * *")
    public void hello(){

        log.info("hello.......");
    }
}