package com.wang.controller;

import com.wang.entity.Department;
import com.wang.entity.Employee;
import com.wang.mapper.DepartmentMapper;
import com.wang.mapper.EmployeeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private DepartmentMapper departmentMapper;

    @RequestMapping("/employees")
    public String listEmployee(Model model) {
        List<Employee> employees = employeeMapper.listEmployee();
        model.addAttribute("employees", employees);
        return "emp/list";
    }

    @GetMapping("/employee")
    public String toAddEmp(Model model) {
        List<Department> departments = departmentMapper.listDepartment();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/employee")
    public String saveEmp(Employee employee) {
        employeeMapper.insertEmployee(employee); //保存员工信息
        return "redirect:/employees";
    }

    @GetMapping("/employee/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model) {
        // 查出原来的数据
        Employee employee = employeeMapper.getEmployeeById(id);
        model.addAttribute("employee", employee);

        // 查出部门信息
        List<Department> departments = departmentMapper.listDepartment();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return "redirect:/employees";
    }

    // 删除员工
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id) {
        employeeMapper.deleteEmployeeBYId(id);
        return "redirect:/employees";
    }
}
