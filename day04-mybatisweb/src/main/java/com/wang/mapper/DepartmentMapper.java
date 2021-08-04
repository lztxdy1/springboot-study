package com.wang.mapper;

import com.wang.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> listDepartment();
    Department getDepartmentById(int id);
}
