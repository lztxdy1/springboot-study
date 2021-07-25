package com.wang.dao;

import com.wang.pojo.Department;
import com.wang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {

    //模拟员工数据库中的数据
    private static Map<Integer, Employee> employees = null;

    //员工所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "小王", "123456789@qq.com", 1, new Department(101, "英语部")));
        employees.put(1002, new Employee(1002, "小李", "123456789@qq.com", 1, new Department(102, "数学部")));
        employees.put(1003, new Employee(1003, "小张", "123456789@qq.com", 1, new Department(103, "物理部")));
        employees.put(1004, new Employee(1004, "小明", "123456789@qq.com", 1, new Department(104, "生物部")));
        employees.put(1005, new Employee(1005, "小红", "123456789@qq.com", 0, new Department(105, "化学部")));
    }

    //初始化员工id
    private static Integer INIT_ID = 1006;
    //添加员工信息
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(INIT_ID++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }
    //获取全部员工
    public Collection<Employee> getEmployeeList() {
        return employees.values();
    }
    //通过id获得员工信息
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }
    //删除员工信息
    public void deleteEmployeeById(Integer id) {
        employees.remove(id);
    }

}
