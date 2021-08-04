package com.wang.mapper;

import com.wang.entity.Department;
import com.wang.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    int insertEmployee(Employee employee);
    List<Employee> listEmployee();
    int updateEmployee(Employee employee);
    Employee getEmployeeById(int id);
    int deleteEmployeeBYId(int id);
}
