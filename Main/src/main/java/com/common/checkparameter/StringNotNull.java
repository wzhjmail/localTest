package com.common.checkparameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName StrNotNull
 * @Description
 * @Author wzj
 * @Date 2020/7/27 19:33
 **/

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface StringNotNull {

    // 错误信息提示
    String value() default "";

}