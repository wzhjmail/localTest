package com.designpattern.状态模式;

/**
 * @ClassName State
 * @Description
 * @Author wzj
 * @Date 2020/10/8 14:46
 **/

public abstract class State {

    // 扣除积分 - 50
    public abstract void deductMoney();

    // 是否抽中奖品
    public abstract boolean raffle();

    // 发放奖品
    public abstract void dispensePrize();

}
