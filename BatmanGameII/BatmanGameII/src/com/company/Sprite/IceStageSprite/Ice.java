package com.company.Sprite.IceStageSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:
 */
public class Ice extends Sprite {
    public Ice(int x,int y){
        super.setPosition(x,y);
        super.img = new ImageIcon("src/image/ice.png");
    }
    @Override
    public String overlap(int x,int y){
        return null;
    }
}
