package com.common.checkparameter.test;

import com.common.checkparameter.IntLongNotNull;
import com.common.checkparameter.NotNull;
import com.common.checkparameter.StringNotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName CreateContract
 * @Description
 * @Author wzj
 * @Date 2020/9/14 14:36
 **/

@Data
public class CreateContract implements Serializable {

    @StringNotNull("合同名称不能为空")
    private String name;

    @IntLongNotNull(defaults = 12)
    private Integer pageSize;

    @NotNull("苹果不能为空")
    private Apple apple;
}
