package com.demo.myspringboot.asyn;

import com.demo.myspringboot.asyn.service.AsyncService;
import com.demo.myspringboot.entity.EmployeeEntity;
import com.demo.myspringboot.mybatis.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @version 1.0
 * @className AsynTest
 * @Author xiaolu
 * @date 2021/4/5 14:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsynTest {

    @Autowired
    AsyncService asyncService;

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void test_001() throws InterruptedException, ExecutionException {

        Future<String> dataResult = asyncService.getDataResult();

        EmployeeEntity employeeEntity = employeeMapper.selectById(7);
        System.out.println("employeeEntity===>"+employeeEntity);
        String s = null;
        try {
            s = dataResult.get(5, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("s====>"+s);


    }
}