package com.demo.myspringboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @TableName employee
 */
@Data
@TableName("employee")
public class EmployeeEntity extends CommonEntity {
    /**
     * 主键
     *
     * @mbg.generated Thu Feb 04 18:44:07 CST 2021
     */
//    @TableId
    private Integer id;

    /**
     * 姓名
     *
     * @mbg.generated Thu Feb 04 18:44:07 CST 2021
     */
    @TableField()
    private String name;

    /**
     * 工资
     *
     * @mbg.generated Thu Feb 04 18:44:07 CST 2021
     */
    private BigDecimal salary;

    /**
     * 部门id
     *
     * @mbg.generated Thu Feb 04 18:44:07 CST 2021
     */
    private Integer departmentid;



}