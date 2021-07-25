package com.wang.dao;

import com.wang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {

    //模拟部门数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "英语部"));
        departments.put(102, new Department(102, "数学部"));
        departments.put(103, new Department(103, "物理部"));
        departments.put(104, new Department(104, "生物部"));
        departments.put(105, new Department(105, "化学部"));
    }

    //获得所有部门
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    //通过id得到部门信息
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }

}
