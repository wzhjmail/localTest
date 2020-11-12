package com.designpattern.中介者模式;

import java.util.HashMap;

/**
 * @ClassName ConcreteMediator
 * @Description
 * @Author wzj
 * @Date 2020/9/14 15:59
 **/
// 具体的中介者类
public class ConcreteMediator extends Mediator {
    //集合，放入所有的同事对象
    private HashMap<String, Colleague> colleagueMap;
    private HashMap<String, String> interMap;

    public ConcreteMediator(){
        colleagueMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    void register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName, colleague);

        if(colleague instanceof Alarm) {
            interMap.put("alarm", colleagueName);
        }else if (colleague instanceof TV){
            interMap.put("tv",colleagueName);
        }else if(colleague instanceof Curtains){
            interMap.put("curtains", colleagueName);
        }
    }

    //具体的中介者的核心方法
    //根据得到消息，完成对应任务
    //中介者在这个方法，协调各个具体的同事对象，完成任务
    @Override
    void getMessage(int stateChange, String colleagueName) {
        if(colleagueMap.get(colleagueName) instanceof Alarm) {
            if(stateChange == 0){
                ((TV)colleagueMap.get(interMap.get("tv"))).startTv();
                ((Curtains)colleagueMap.get(interMap.get("curtains"))).downCurtains();
            }else if (stateChange == 1){
                ((TV)colleagueMap.get(interMap.get("tv"))).stopTv();
            }
        }else if(colleagueMap.get(colleagueName) instanceof Curtains){
            ((TV)colleagueMap.get(interMap.get("tv"))).stopTv();
        }else if(colleagueMap.get(colleagueName) instanceof TV){

        }
    }

    @Override
    void sendMessage() {

    }
}
