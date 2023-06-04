package com.company.GameView;

import com.company.Sprite.IceStageSprite.Gangster;
import com.company.Sprite.IceStageSprite.Freeze;
import com.company.Sprite.IceStageSprite.Ice;
import com.company.Sprite.Door;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:IceStage
 */
public class IceStage extends GameView{
    private ArrayList<Gangster> gangsters = new ArrayList<>();
    private ArrayList<Ice> ice = new ArrayList<>();
    private ArrayList<Freeze> freeze = new ArrayList<>();

    public ArrayList<Gangster> getGangsters() {
        return gangsters;
    }

    public ArrayList<Ice> getIce() {
        return ice;
    }

    public ArrayList<Freeze> getFreeze() {
        return freeze;
    }

    public IceStage(){
        super.img = new ImageIcon("src/image/iceview.png");
        super.elements = new ArrayList<>();
        super.door = new Door(10,10);

        gangsters.add(new Gangster(10,5));
        gangsters.add(new Gangster(9,5));
        gangsters.add(new Gangster(9,4));
        gangsters.add(new Gangster(6,2));
        gangsters.add(new Gangster(6,3));
        gangsters.add(new Gangster(6,4));
        gangsters.add(new Gangster(6,5));
        gangsters.add(new Gangster(1,2));
        gangsters.add(new Gangster(1,3));
        gangsters.add(new Gangster(1,4));
        gangsters.add(new Gangster(2,2));
        gangsters.add(new Gangster(2,3));

        ice.add(new Ice(7,5));
        ice.add(new Ice(3,5));
        ice.add(new Ice(5,5));
        ice.add(new Ice(4,5));
        ice.add(new Ice(8,5));
        ice.add(new Ice(6,6));
        ice.add(new Ice(7,8));
        ice.add(new Ice(8,8));
        ice.add(new Ice(9,8));
        ice.add(new Ice(3,8));

        freeze.add(new Freeze(9,10));
        freeze.add(new Freeze(10,9));
        super.elements.addAll(gangsters);
        super.elements.addAll(ice);
        super.elements.addAll(freeze);
        super.elements.add(door);
    }
}
