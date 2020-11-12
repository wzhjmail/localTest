package com.common.checkparameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName FloatDoubleNotNull
 * @Description
 * @Author wzj
 * @Date 2020/8/12 18:28
 **/
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FloatDoubleNotNull {

    // 错误信息提示
    String value() default "";

}
