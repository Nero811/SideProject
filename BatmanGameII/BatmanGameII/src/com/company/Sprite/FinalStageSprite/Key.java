package com.company.Sprite.FinalStageSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:
 */
public class Key extends Sprite {
    public Key(int x,int y){
        super.setPosition(x,y);
        super.img = new ImageIcon("src/image/key.png");
    }
    @Override
    public String overlap(int x,int y){
        return null;
    }
}
