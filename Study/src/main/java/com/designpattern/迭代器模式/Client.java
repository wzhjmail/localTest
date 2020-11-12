package com.designpattern.迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/8/9 13:05
 **/

public class Client {
  public static void main(String[] args) {
    //
    List<College> collegeList = new ArrayList<College>();

    ComputerCollege computerCollege = new ComputerCollege();
    InfoCollege infoCollege = new InfoCollege();

      collegeList.add(computerCollege);
      collegeList.add(infoCollege);

      OutPutImpl outPut = new OutPutImpl(collegeList);
      outPut.printCollege();
  }
}
