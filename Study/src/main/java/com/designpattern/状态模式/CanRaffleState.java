package com.designpattern.状态模式;

import java.util.Random;

/** @ClassName CanRaffleState @Description 可以抽奖的状态 @Author wzj @Date 2020/10/8 14:58 */
public class CanRaffleState extends State {

  RaffleActivity activity;

  public CanRaffleState(RaffleActivity activity) {
    this.activity = activity;
  }

  @Override
  public void deductMoney() {
    System.out.println("已经扣除过积分");
  }

  @Override
  public boolean raffle() {
    System.out.println("正在抽奖，请稍等！");
    Random random = new Random();
    int num = random.nextInt(10);
    if (num == 0) {
      activity.setState(activity.getDispenseState());
      return true;
    } else {
      System.out.println("很遗憾没有抽中奖品");
      activity.setState(activity.getNoRaffleState());
      return false;
    }

  }

  @Override
  public void dispensePrize() {
    System.out.println("没中奖，不能发放奖品");
  }
}
