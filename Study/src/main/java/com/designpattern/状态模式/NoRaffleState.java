package com.designpattern.状态模式;

/**
 * @ClassName NoRaffleState
 * @Description 不能抽奖的状态
 * @Author wzj
 * @Date 2020/10/8 14:50
 **/

public class NoRaffleState extends State {

    // 初始化时传入活动引用，扣除积分后改变其状态
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
    System.out.println("扣除50积分成功，您可以抽奖了");
    activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
    System.out.println("扣了积分才能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
    System.out.println("当前状态不能发放奖品");
    }
}
