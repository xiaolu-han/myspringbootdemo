package com.demo.myspringboot.mybatis;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.myspringboot.entity.EmployeeEntity;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @className EmployeeMapperTest
 * @Author xiaolu
 * @date 2021/2/5 16:33
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {


    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() throws SQLException {
        //org.apache.tomcat.jdbc.pool.DataSource
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

    @Test
    public void addEmploy(){

        System.out.println(employeeMapper.getClass());
        EmployeeEntity employeeEntity = new EmployeeEntity();
//        employeeEntity.setId(1);
        employeeEntity.setName("han");
        employeeEntity.setSalary(new BigDecimal(30000.00));
        employeeMapper.updateById(employeeEntity);
        System.out.println(employeeEntity.getId());
    }

    /*
     * @Author:xiaolu
     * @Description 更新时 只对非null值更新且逻辑删除判断
     *  Preparing: UPDATE employee SET salary=?, version=? WHERE id=? AND version=? AND is_deleted='0'
     * @Date :2021/4/4 22:06

     * @return void
     **/
    @Test
    public void updateEmploy(){

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1);
        employeeEntity.setVersion(3);
        employeeEntity.setSalary(new BigDecimal(90000.00));
        employeeMapper.updateById(employeeEntity);
    }

    /**
     * @Author:xiaolu
     * @Description 逻辑删除 和版本无关
     * UPDATE employee SET is_deleted='1' WHERE id=? AND is_deleted='0'
     * @Date :2021/4/4 22:26
     * @return void
     **/
    @Test
    public void deleteEmploy(){

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1);
        employeeEntity.setVersion(2);
        employeeMapper.deleteById(employeeEntity);
    }

    /*
     * @Author:xiaolu
     * @Description 分布查询
     * @Date :2021/4/4 22:30

     * @return void
     **/
    @Test
    public void pageEmploy(){

        Page<EmployeeEntity> page = new Page<EmployeeEntity>(2,2);

        Page<EmployeeEntity> employeeEntityPage = employeeMapper.selectPage(page, null);
        List<EmployeeEntity> records = employeeEntityPage.getRecords();
        System.out.println(records);
    }

}