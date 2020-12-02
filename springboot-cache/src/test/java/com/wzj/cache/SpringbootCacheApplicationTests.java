package com.wzj.cache;

import com.wzj.cache.bean.Department;
import com.wzj.cache.bean.Employee;
import com.wzj.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
//@RunWith(SpringRunner.class)
class SpringbootCacheApplicationTests {

  @Autowired
  EmployeeMapper employeeMapper;

  //pom文件引入redis后，RedisAutoConfiguration就起作用了
  @Autowired
  StringRedisTemplate stringRedisTemplate;

  @Autowired
  RedisTemplate redisTemplate;

  @Autowired
  RedisCacheManager redisCacheManager;

  @Autowired
  RedisTemplate<Object, Employee> empRedisTemplate;

  @Test
  void contextLoads() {
    Employee employee = employeeMapper.getEmployeeById(1);
    System.out.println(employee);
  }


  @Test
  public void stringRedisTemplateTest() {
    stringRedisTemplate.opsForValue().append("msg", "hello");
    System.out.println(stringRedisTemplate.opsForValue().get("msg"));
  }

  @Test
  public void redisEmployeeTest() {
    Employee employee = employeeMapper.getEmployeeById(1);
    redisTemplate.opsForValue().set("emp", employee);

    System.out.println(redisTemplate.opsForValue().get("emp"));

    empRedisTemplate.opsForValue().set("serEmp", employee);
    System.out.println(empRedisTemplate.opsForValue().get("serEmp"));
  }

  @Test
  @Cacheable(cacheManager = "empCacheManager")
  public void cacheManagerTest() {
    Cache cache = redisCacheManager.getCache("ops");
    Department dept = new Department();
    dept.setDepartmentName("信息技术部门");
    cache.put("dept:1", dept);

    System.out.println(cache.get("dept:1"));
  }
}
