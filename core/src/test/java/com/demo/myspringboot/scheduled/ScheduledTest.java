package com.demo.myspringboot.scheduled;

import com.demo.myspringboot.schedul.ScheduleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @version 1.0
 * @className ScheduledTest
 * @Author xiaolu
 * @date 2021/4/5 14:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduledTest {

    @Autowired
    ScheduleService scheduleService;
    @Test
    public void test_001() throws IOException {
        scheduleService.hello();

        System.in.read();
    }
}