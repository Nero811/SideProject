package com.company.Sprite.GothamStageSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:
 */
public class Joker extends Sprite {
    public Joker(int x,int y){
        super.setPosition(x,y);
        super.img = new ImageIcon("src/image/Joker.png");
    }
    @Override
    public String overlap(int x,int y){
        return null;
    }
}
