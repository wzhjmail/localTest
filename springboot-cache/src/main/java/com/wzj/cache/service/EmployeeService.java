package com.wzj.cache.service;

import com.wzj.cache.bean.Employee;
import com.wzj.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @ClassName EmployeeService
 * @Description
 * @Author wzj
 * @Date 2020/11/13 19:11
 **/

@CacheConfig(cacheNames = "emp")//抽取缓存的公共配置
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，不用调用方法；

     CacheManager管理多个Cache组件，对缓存对真正CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字

     几个属性：
     1、cacheNames/value: 指定缓存组件对名字；将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存

     2、key: 缓存数据使用的key，可以用它来指定，默认是使用方法参数的至
     编写SpEL: #id:参数id的值 #root.args[0]

     3、keyGenerator: key的生成器，可以自己指定key的生成器的组件ID
     key/keyGenerator：二选一使用

     4、cacheManager:指定缓存管理器，或者cacheResolver指定获取解析器

     5、condition: 指定符合条件的情况下才缓存 condition="#id>0"
     condition = "#a0>1":第一个参数的值大于1的时候才进行缓存

     6、unless:否定缓存当unless指定的条件为我true，方法的返回值就不会被缓存，可以获取到结果进行判断
     unless="#result == null"  unless = "#a0==2"：如果第一个参数的值是2，结果不缓存

     7、sync:是否使用异步模式
     @param id
     @return cache原理：
     1、自动配置类：CacheAutoConfiguration
     2、缓存的配置类：
     "org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration"
     "org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration"
     "org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration"
     "org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration"
     "org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration"
     "org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration"
     "org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration"
     "org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration"
     "org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration"【默认】
     "org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration"
     引入redis的starter，容器中保存的是RedisCacheManager
     RedisCacheManager帮我们创建RedisCache来作为缓存组件，RedisCache通过操作redis缓存数据

     3、那个配置类默认生效？SimpleCacheConfiguration
     4、给容器中注册一个CacheManager,ConcurrentMapCacheManager
     5、可以获取和创建ConcurrentMapCache类型的缓存组件，他的作用将数据保存在ConcurrentMap中

     运行流程：
     1、方法运行之前，先去查询cache,按照cachenames指定的名字获取
     CacheManager先获取相应的缓存，第一次获取缓存如果没有cache组件，会自动创建
     2、去cache中查找缓存的内容(ConcurrentMapCache.lookup)，使用一个key,默认就是方法的参数
     key是按照某种策略生成的，默认是使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key
     SimpleKeyGenerator生成key的默认策略：
     如果没有参数：key = new SimpleKey();
     如果有一个参数：key=参数的值
     如果有多个参数，key = new SimpleKey(params)
     3、没有查到缓存就调用目标方法
     4、将目标方法返回的结果，放入到缓存ConcurrentMapCache.put()

     @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存

     */
    //@Cacheable(value = {"emp"}, key = "#root.methodName+'[' +#id+']'")//key是getEmp[1]
    //@Cacheable(value = {"emp"}, keyGenerator = "myKeyGenerator")//使用自定义的key生成器
    //@Cacheable(value = {"emp"}, keyGenerator = "myKeyGenerator", condition = "#a0>1")//第一个参数大于一才缓存
    //@Cacheable(value = {"emp"}, keyGenerator = "myKeyGenerator", unless = "#a0==2")//如果第一个参数的值是2，结果不缓存
    @Cacheable(value = {"emp"})
    public Employee getEmp(Integer id) {
        System.out.println("查询编号为：" + id + "的员工");
        return employeeMapper.getEmployeeById(id);
    }

    /**
     @CachePut：即调用方法，又更新缓存:同步更新缓存
     @param employee
     @return 如果没有指定key，会将传入的参数employee这个对象作为key, 返回结果作为value,
     这样的话和上面查询时,以员工id作为key不对应，因此key一般都要指定
     key = "employee.id":使用传入参数的ID
     key = "result.id"：使用返回后的id
     */
    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     @CacheEvict:缓存清除 key指定要清除的数据
     allEntries = true : 指定清除这个缓存中所有的数据
     beforeInvocation = false : 缓存的清除是否在方法执行之前执行。
     默认代表缓存清除操作是在方法执行之后执行；如果出现异常缓存就不会清除
     beforeInvocation = true: 代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
     */
    @CacheEvict(value = "emp", key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("delete Emp:" + id);
    }


    //@Caching定义复杂的缓存规则
    @Caching(
            cacheable = {@Cacheable(value = "emp", key = "#lastName")},
            put = {
                    @CachePut(value = "emp", key = "result.id"),
                    @CachePut(value = "emp", key = "result.email")
            }
    )
    public Employee getEmpByName(String lastName) {
        return employeeMapper.getEmpByName(lastName);
    }
}
