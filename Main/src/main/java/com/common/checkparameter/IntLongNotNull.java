package com.common.checkparameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName NotNull
 * @Description
 * @Author wzj
 * @Date 2020/7/27 18:50
 **/

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface IntLongNotNull {

    // 错误信息提示
    String value() default "";

    // 默认值
    int defaults() default 0;

}
