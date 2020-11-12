package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** @ClassName AOP @Description @Author wzj @Date 2020/8/3 15:56 */
@Component
@Aspect
public class AddLogAOP {

  //方式一：注解式拦截
  // 和@Action注解配套使用，在特定方法上添加@Action注解即可
  @Pointcut("@annotation(com.aop.Action)")
  public void annotationPointCut(){

  }

  @Before("annotationPointCut()")
  public void before(){
    System.out.println("注解拦截器执行");
  }


  // 方式二：基于方法规则实现
  // 该方法的参数类型、个数都需要和对应的方法相同
  // 或者@Before("execution(* com.controller.LocalController.*(..)) && args(name,..)")
  @Before("execution(* com.controller.LocalController.*(..)) && args(..,request)")
  public void addLog(HttpServletRequest request) {
    System.out.println("执行切面方法---------");
    System.out.println(request.toString());
  }

    @Before("execution(* com.controller.LocalController.*(..)) && args(name,..)")
    public void addLog(String name) {
        System.out.println("测试传入参数---------");
        System.out.println(name);
    }

  // 通过joinPoint获取拦截方法的参数
  @After("execution(* com.controller.LocalController.*(..)))")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

    HttpServletRequest request = attributes.getRequest();
    // 获取参数值
    Object[] objs = joinPoint.getArgs();
    Signature signature = joinPoint.getSignature();
    MethodSignature methodSignature = (MethodSignature) signature;
    // 获取参数名称
    String[] name = methodSignature.getParameterNames();
    // 获取参数类型
    Class[] types = methodSignature.getParameterTypes();

    System.out.println("advice执行结束！！！");
  }

  // 方法规则可以通过 || , && 等
//  @Pointcut("execution(* com.controller.LocalController.test(..)) || "
//          + "execution(* com.aop.AOPController.*(..))")
//  public void controllerPointCut() {}


  /**
   * @Around
   * 1、既可以在目标方法之前织入增强动作，也可以在执行目标方法之后织入增强动作
   * 2、可以决定目标方法在什么时候执行，如何执行，甚至可以阻止目标方法的执行
   * 3、可以改变执行目标方法的参数值，也可以改变执行目标方法之后的返回值
   */
//  @Around("controllerPointCut()")
  public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    Object[] args = proceedingJoinPoint.getArgs();
    if(args != null && args.length > 0) {
      // 修改目标方法的第一个参数
      List<String> list = (List<String>)args[0];
      list.add("新增参数");
      args[0] = list;
    }

    List<String> result = (List<String>)proceedingJoinPoint.proceed();
    result.add("新增返回值");
    return result;
  }

}
