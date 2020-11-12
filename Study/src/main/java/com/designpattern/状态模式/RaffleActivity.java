package com.designpattern.状态模式;

import lombok.Data;

/** @ClassName RaffleActivity @Description @Author wzj @Date 2020/10/8 15:03 */
@Data
public class RaffleActivity {
  // state表示活动当前的转台，是变化的
  State state = null;
  // 奖品数量
  int count = 0;

  // 四个属性表示四种状态
  State noRaffleState = new NoRaffleState(this);
  State canRaffleState = new CanRaffleState(this);

  State dispenseState = new DispenseState(this);
  State dispenseOutState = new DispenseOutState(this);

  public RaffleActivity(int count) {
    this.state = getNoRaffleState();
    this.count = count;
  }

  public void debuctMoney() {
    state.deductMoney();
  }

  // 抽奖
  public void raffle() {
      //如果当前的状态是抽奖成功
      if(state.raffle()){
          state.dispensePrize();
      }
  }

  //这里注意，每领取一次奖品，count--
    public int getCount() {
      int curCount = count;
      count--;
      return curCount;
    }
}
