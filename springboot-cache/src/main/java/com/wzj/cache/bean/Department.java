package com.wzj.cache.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Employee
 * @Description
 * @Author wzj
 * @Date 2020/11/13 18:15
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

    private Integer id;

    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public static void main(String[] args) {

    }
}
