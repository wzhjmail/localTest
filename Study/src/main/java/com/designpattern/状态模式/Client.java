package com.designpattern.状态模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/10/8 14:32
 **/

public class Client {
  public static void main(String[] args) {
    //创建活动对象 奖品只有一个
      RaffleActivity activity = new RaffleActivity(1);

      for(int i=0;i<30;i++) {
      System.out.println("第"+(i+1)+"次抽奖、、、、、、");
      //参加抽奖，第一步点击扣除积分
      activity.debuctMoney();
      // 第二步抽奖
      activity.raffle();
      }
  }
}
