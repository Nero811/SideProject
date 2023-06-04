package com.company.Sprite.FinalStageSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:
 */
public class Catwoman extends Sprite {
    public Catwoman(int x,int y){
        super.setPosition(x,y);
        super.img = new ImageIcon("src/image/catwoman.png");
    }
    @Override
    public String overlap(int x,int y){
        return null;
    }
}
