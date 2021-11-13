package com.demo.myspringboot.redis;

import com.demo.myspringboot.entity.EmployeeEntity;
import com.demo.myspringboot.mybatis.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @className redisTest
 * @Author xiaolu
 * @date 2021/3/28 21:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的

   /* @Autowired
    RedisTemplate redisTemplate;  //k-v都是对象的*/

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate myRedisTemplate;


    /**
     * Redis常见的五大数据类型
     *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue()[String（字符串）]
     *  stringRedisTemplate.opsForList()[List（列表）]
     *  stringRedisTemplate.opsForSet()[Set（集合）]
     *  stringRedisTemplate.opsForHash()[Hash（散列）]
     *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */
    @Test
    public void test01(){
        //给redis中保存数据
        stringRedisTemplate.opsForValue().append("msg","hello");
		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(msg);

		stringRedisTemplate.opsForList().leftPush("mylist","1");
		stringRedisTemplate.opsForList().leftPush("mylist","2");
    }

    /**
     * @Author:xiaolu
     * @Description 测试保存对象 k和v都是乱码
     * @Date :2021/4/5 13:42
     * @return void
     **/
    @Test
    public void test02(){
        EmployeeEntity empById = employeeMapper.selectById(7);
        System.out.println("empById====>"+empById);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",empById);
        //1、将数据以json的方式保存
        //(1)自己将对象转为json
        //(2)redisTemplate默认的序列化规则；改变默认的序列化规则；
//        redisTemplate.opsForValue().set("emp-07",empById);
    }

    /**
     * @Author:xiaolu
     * @Description 自定义redisTemplate
     * @Date :2021/4/5 13:42
     * @return void
     **/
    @Test
    public void test03(){
        EmployeeEntity empById = employeeMapper.selectById(7);
        System.out.println("empById====>"+empById);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",empById);
        //1、将数据以json的方式保存
        //(1)自己将对象转为json
        //(2)redisTemplate默认的序列化规则；改变默认的序列化规则；
        myRedisTemplate.opsForValue().set("emp-07",empById);
    }
}