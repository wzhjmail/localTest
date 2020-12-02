package com.wzj.cache.mapper;

import com.wzj.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmployeeById(Integer id);

    @Update("update employee set last_name=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id = #{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    void deleteEmployeeById(Integer id);

    @Insert("insert into employee(last_name,email,gender,d_id) values(#{lastName},#{email},#{gender},#{d_id})")
    void insertEmployee(Employee employee);


    @Select("select * from employee where last_name = #{name}")
    Employee getEmpByName(String name);
}
