package com.demo.myspringboot.mybatis.rest;

import com.demo.myspringboot.entity.EmployeeEntity;
import com.demo.myspringboot.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @className EmployeeRest
 * @Author xiaolu
 * @date 2021/4/4 18:24
 */
@RestController
@RequestMapping("/employee")
public class EmployeeRest {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public void addEmployee(@RequestBody EmployeeEntity employeeEntity){

        employeeService.insertEmployee(employeeEntity);
    }

    @PostMapping("/update")
    public int updateEmployee(@RequestBody EmployeeEntity employeeEntity){

        return employeeService.updateEmployee(employeeEntity);
    }

    public static void main(String[] args) {
        System.out.println(EmployeeRest.class.getClassLoader());
        System.out.println(EmployeeService.class.getClassLoader());
    }
}