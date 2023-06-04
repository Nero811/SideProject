package com.company.Sprite.IceStageSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:
 */
public class Freeze extends Sprite {
    public Freeze(int x,int y){
        super.setPosition(x,y);
        super.img = new ImageIcon("src/image/freeze.png");
    }
    @Override
    public String overlap(int x,int y){
        return null;
    }
}
