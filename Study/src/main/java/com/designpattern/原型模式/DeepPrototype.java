package com.designpattern.原型模式;

import java.io.*;

/** @ClassName DeepPrototype @Description @Author wzj @Date 2020/10/13 15:59 */
public class DeepPrototype implements Serializable, Cloneable {

  public String name;
  public DeepCloneableTarget deepCloneableTarget;

  public DeepPrototype() {
    super();
  }

  // 深拷贝方式一：使用clone方法
  protected Object clone() throws CloneNotSupportedException {
    Object deep = null;
    // 完成对基本类型和String的克隆
    deep = super.clone();
    // 对引用类型的属性。进行单独处理
    DeepPrototype deepPrototype = (DeepPrototype) deep;
    deepPrototype.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();

    return deepPrototype;
  }

  // 深拷贝方式二：序列化（推荐使用）
  public Object deelClone() {
    // 创建流对象
    ByteArrayOutputStream bos = null;
    ObjectOutputStream oos = null;
    ByteArrayInputStream bis = null;
    ObjectInputStream ois = null;

    try {
      // 序列化
      bos = new ByteArrayOutputStream();
      oos = new ObjectOutputStream(bos);
      oos.writeObject(this); // 将当前对象以对象流的方式输出

      // 反序列化
      bis = new ByteArrayInputStream(bos.toByteArray());
      ois = new ObjectInputStream(bis);
      DeepPrototype copyObj = (DeepPrototype) ois.readObject();

      return copyObj;
    } catch (Exception e) {
      return null;
    } finally {
      try {
        bos.close();
        oos.close();
        bis.close();
        ois.close();
      } catch (Exception e) {

      }
    }
  }
}
