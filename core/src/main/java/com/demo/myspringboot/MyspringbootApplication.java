package com.demo.myspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController
@MapperScan(value = "com.demo.myspringboot.mybatis")
@EnableAsync
@EnableScheduling
public class MyspringbootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
    }


    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("=====>name");
        return String.format("Hello %s!", name);
    }

    /*
     * @Author:xiaolu
     * @Description 验证线程
     * @Date :2021/6/6 8:56
     * @return void
     **/
    @GetMapping("/system")
    public void system() throws IOException {
        System.out.println("=====>system");
        System.in.read();
    }

    /*
     * @Author:xiaolu
     * @Description 验证内存
     * @Date :2021/6/6 8:56
     * @return void
     **/
    @GetMapping("/string")
    public void string() throws IOException {

        String  a = "";
        for (Integer i = 0; i<Integer.MAX_VALUE;i++){
            a = i.toString();
            System.out.println(a);
        }
    }
    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyspringbootApplication start success");
    }
}
