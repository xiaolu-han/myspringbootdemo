package com.demo.myspringboot.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @TableName department
 */
@Data
@TableName("department")
public class DepartmentEntity  extends CommonEntity{
    /**
     * 
     *
     * @mbg.generated Thu Feb 04 18:16:18 CST 2021
     */
    @TableId
    private Integer id;

    /**
     * 部门名称
     *
     * @mbg.generated Thu Feb 04 18:16:18 CST 2021
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table department
     *
     * @mbg.generated Thu Feb 04 18:16:18 CST 2021
     */
    private static final long serialVersionUID = 1L;
}