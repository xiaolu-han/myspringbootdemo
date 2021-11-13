package com.demo.myspringboot.mybatis.service;

import com.demo.myspringboot.entity.EmployeeEntity;

public interface EmployeeService {


    public int insertEmployee(EmployeeEntity employeeEntity);


    public int updateEmployee(EmployeeEntity employeeEntity);
}
