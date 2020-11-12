package com.designpattern.适配器模式.对象适配器;

/** @ClassName VoltageAdapter @Description @Author wzj @Date 2020/10/15 15:40 */
// 适配器类
public class VoltageAdapter implements IVolate5V {

  private Voltage220V voltage220V;

  // 通过构造器，传入一个Voltage220V 实例
  public VoltageAdapter(Voltage220V voltage220V) {
    this.voltage220V = voltage220V;
  }

  @Override
  public int output5V() {
    int dstV = 0;
    if (null != voltage220V) {
      int src = voltage220V.output220V(); // 获取22oV电压
      System.out.println("使用对象适配器，进行适配～～～");
      dstV = src / 44;
      System.out.println("适配完成，输出的电压为=" + dstV);
    }

    return dstV;
  }
}
