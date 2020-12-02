package com.wzj.cache.controller;

import com.wzj.cache.bean.Employee;
import com.wzj.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EmployeeController
 * @Description
 * @Author wzj
 * @Date 2020/11/13 19:10
 **/
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeService.getEmp(id);
    }

    @GetMapping("/emp/update")
    public Employee updateEmp(Employee employee) {
        return employeeService.updateEmp(employee);
    }

    @GetMapping("emp/delete")
    public String deleteEmp(Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByName(@PathVariable("lastName") String lastName) {
        return employeeService.getEmpByName(lastName);
    }
}
