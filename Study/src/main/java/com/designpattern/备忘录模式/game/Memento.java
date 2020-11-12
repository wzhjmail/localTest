package com.designpattern.备忘录模式.game;

import lombok.Data;

/**
 * @ClassName Memento
 * @Description
 * @Author wzj
 * @Date 2020/9/15 10:16
 **/
@Data
public class Memento {

    private int vit;//攻击力

    private int def;//防御能力

    public Memento(int vit, int def) {
        this.vit = vit;
        this.def = def;
    }
}
