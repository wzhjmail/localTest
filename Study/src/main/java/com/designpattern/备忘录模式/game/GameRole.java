package com.designpattern.备忘录模式.game;

import lombok.Data;

/**
 * @ClassName GameRole
 * @Description
 * @Author wzj
 * @Date 2020/9/15 10:17
 **/
@Data
public class GameRole {

    private int vit;

    private int def;

    //创建memento, 即根据当前的状态得到Memento
    public Memento createMemento(){
        return new Memento(vit, def);
    }

    //从备忘录对西那个，恢复GameRole的状态
    public void recoverGameRoleFromMemento(Memento m){
        this.vit = m.getVit();
        this.def = m.getDef();
    }

    //显示当前游戏角色的状态
    public void display() {
    System.out.println("游戏角色当前的攻击力="+ this.vit+"  防御能力="+this.def);
    }


}
