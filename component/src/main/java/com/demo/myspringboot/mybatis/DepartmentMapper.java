package com.demo.myspringboot.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.myspringboot.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity com.demo.myspringboot.entity.DepartmentEntity
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<DepartmentEntity> {
    /**
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated
     */
//    int insert(DepartmentEntity record);

    /**
     * @mbg.generated
     */
    int insertSelective(DepartmentEntity record);

    /**
     * @mbg.generated
     */
    DepartmentEntity selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DepartmentEntity record);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKey(DepartmentEntity record);
}