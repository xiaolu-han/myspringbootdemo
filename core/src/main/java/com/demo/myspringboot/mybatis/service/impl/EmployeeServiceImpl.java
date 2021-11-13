package com.demo.myspringboot.mybatis.service.impl;

import com.demo.myspringboot.entity.EmployeeEntity;
import com.demo.myspringboot.mybatis.EmployeeMapper;
import com.demo.myspringboot.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version 1.0
 * @className EmployeeServiceImpl
 * @Author xiaolu
 * @date 2021/4/4 20:03
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Transactional
    @Override
    public int insertEmployee(EmployeeEntity employeeEntity) {
        int insert = employeeMapper.insert(employeeEntity);
        return insert;
    }

    @Override
    public int updateEmployee(EmployeeEntity employeeEntity) {
        int i = employeeMapper.updateById(employeeEntity);
        return i;
    }


}