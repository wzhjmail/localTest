package com.designpattern.状态模式;

/**
 * @ClassName DispenseOutState
 * @Description  奖品发放完毕状态
 * 当我们activity 改变成 DispenseOutState 抽奖活动结束
 * @Author wzj
 * @Date 2020/10/8 17:13
 **/

public class DispenseOutState extends State {

    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
    System.out.println("奖品发送完了，请下次再参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发送完了，请下次再参加");
        return false;
    }

    @Override
    public void dispensePrize() {

    }
}
