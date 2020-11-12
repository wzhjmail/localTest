package com.common.checkparameter;


import com.meicai.dmall.ladder.commons.exception.InvalidParamException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ParameterRequired
 * @Description
 * @Author wzj
 * @Date 2020/7/27 18:54
 */
@Slf4j
public class ParameterRequired {

    // 目标对象
    private Object target;
    // class对象
    private Class targetClazz;

    // 初始化方法
    public ParameterRequired(Object target) {
        this.target = target;
        this.targetClazz = target.getClass();
    }

    public void validate() {

        // 获取目标对象中所有的字段，getFields()只返回公有字段
        Field[] fields = targetClazz.getDeclaredFields();
        for (Field field : fields) {

            // 如果没有注解，则跳过
            if (field.getAnnotations().length == 0) {
                continue;
            }

            // int Integer long Long校验
            if (intLongNotNullValidate(field)) {
                continue;
            }

            // String 校验
            if (stringValidate(field)) {
                continue;
            }

            // Float float Double double校验
            if (floatDoubleNotNullValidate(field)) {
                continue;
            }

            // 用户自定义类型的校验
            if (field.getType().getClassLoader() != null) {
                checkPersonalClass(field);
                continue;
            }

        } // for

    }

    // 用户自定义类型
    private void checkPersonalClass(Field field) {
        // 递归调用自定义类中属性的校验
        System.out.println("用户自定义类型");
        NotNull notNull = field.getAnnotation(NotNull.class);
        if (notNull == null) {
            return;
        }

        Object obj = getValue(field);

        if (obj != null) {
            new com.meicai.dmall.ladder.commons.checkparameter.ParameterRequired(obj).validate();
        } else {
            throw new InvalidParamException(notNull.value());
        }
    }

    // int Integer long Long校验
    private boolean intLongNotNullValidate(Field field) {
        IntLongNotNull intNotNull = field.getAnnotation(IntLongNotNull.class);
        if (intNotNull != null) {
            Class clazz = field.getType();
            Object obj = getValue(field);
            if (obj == null
                    || ((clazz == Integer.class || clazz == int.class) && (Integer) obj == 0)
                    || ((clazz == Long.class || clazz == long.class) && (Long) obj == 0)) {

                if (intNotNull.defaults() != 0) {
                    try {
                        Method setMethod = targetClazz.getMethod(
                                "set" + getMethodName(field.getName()),
                                clazz);

                        setMethod.invoke(target, intNotNull.defaults());
                    } catch (Exception e) {
                        log.error(e.toString());
                    }
                } else {
                    throw new InvalidParamException(intNotNull.value());
                }
            }

            return true;
        }

        return false;
    }

    // String 校验
    private boolean stringValidate(Field field) {
        StringNotNull strNotNull = field.getAnnotation(StringNotNull.class);
        if (strNotNull != null) {
            Object obj = getValue(field);

            if (field.getType() == String.class && StringUtils.isBlank((String) obj)) {
                throw new InvalidParamException(strNotNull.value());
            }

            return true;
        }

        return false;
    }

    // Float float Double double校验
    private boolean floatDoubleNotNullValidate(Field field) {
        FloatDoubleNotNull floatDoubleNotNull = field.getAnnotation(FloatDoubleNotNull.class);
        if (floatDoubleNotNull != null) {
            Class clazz = field.getType();
            Object obj = getValue(field);
            if (obj == null
                    || ((clazz == Float.class || clazz == float.class)
                    && Float.compare((Float) obj, 0.0f) == 0)
                    || ((clazz == Double.class || clazz == double.class)
                    && Double.compare((Double) obj, 0.0d) == 0)) {

                throw new InvalidParamException(floatDoubleNotNull.value());
            }

            return true;
        }

        return false;
    }

    /** 把一个字符串的第一个字母大写 */
    public static String getMethodName(String fileName) {
        byte[] items = fileName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    private Object getValue(Field field) {
        try {
            Method getMethod = targetClazz.getMethod("get" + getMethodName(field.getName()));
            Object obj = getMethod.invoke(target);
            return obj;
        } catch (Exception e) {
            log.error(e.toString());
        }
        return null;
    }

}
