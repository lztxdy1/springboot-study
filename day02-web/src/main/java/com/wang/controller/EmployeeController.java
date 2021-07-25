package com.wang.controller;

import com.wang.dao.DepartmentDao;
import com.wang.dao.EmployeeDao;
import com.wang.pojo.Department;
import com.wang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/employees")
    public String listEmployee(Model model) {
        Collection<Employee> employees = employeeDao.getEmployeeList();
        model.addAttribute("employees", employees);
        return "emp/list";
    }

    @GetMapping("/employee")
    public String toAddEmp(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/employee")
    public String saveEmp(Employee employee) {
        employeeDao.save(employee); //保存员工信息
        return "redirect:/employees";
    }

    @GetMapping("/employee/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model) {
        // 查出原来的数据
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee", employee);

        // 查出部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    // 删除员工
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id) {
        employeeDao.deleteEmployeeById(id);
        return "redirect:/employees";
    }

}
