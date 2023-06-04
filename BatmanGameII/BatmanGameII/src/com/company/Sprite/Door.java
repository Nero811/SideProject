package com.company.Sprite;

import javax.swing.*;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:Door Class
 */
public class Door extends Sprite{
    public Door(int x,int y){
        super.setPosition(x,y);
        super.img = new ImageIcon("src/image/door.png");
    }
    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
