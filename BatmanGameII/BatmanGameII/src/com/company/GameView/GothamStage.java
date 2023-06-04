package com.company.GameView;

import com.company.Sprite.Door;
import com.company.Sprite.GothamStageSprite.Badguy;
import com.company.Sprite.GothamStageSprite.Joker;
import com.company.Sprite.GothamStageSprite.Policecar;


import javax.swing.*;
import java.util.ArrayList;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:GothamStage
 */
public class GothamStage extends GameView{
    public ArrayList<Badguy> getBadguys() {
        return badguys;
    }

    public ArrayList<Policecar> getPolicecars() {
        return policecars;
    }

    public ArrayList<Joker> getJoker() {
        return joker;
    }

    private ArrayList<Badguy> badguys = new ArrayList<>();
    private ArrayList<Policecar> policecars = new ArrayList<>();
    private ArrayList<Joker> joker = new ArrayList<>();
    public GothamStage(){
        img = new ImageIcon("src/image/gotham.png");
        super.elements = new ArrayList<>();
        door = new Door(10,10);

        policecars.add(new Policecar(6,3));
        policecars.add(new Policecar(6,4));
        policecars.add(new Policecar(6,5));
        policecars.add(new Policecar(8,3));
        policecars.add(new Policecar(1,3));
        policecars.add(new Policecar(6,9));
        policecars.add(new Policecar(2,7));
        policecars.add(new Policecar(2,5));

        badguys.add(new Badguy(5,4));
        badguys.add(new Badguy(6,1));
        badguys.add(new Badguy(5,1));
        badguys.add(new Badguy(4,1));
        badguys.add(new Badguy(3,1));
        badguys.add(new Badguy(1,4));

        badguys.add(new Badguy(2,6));
        badguys.add(new Badguy(7,6));
        badguys.add(new Badguy(7,7));
        badguys.add(new Badguy(7,8));
        badguys.add(new Badguy(10,1));

        joker.add(new Joker(10,9));
        joker.add(new Joker(9,10));
        super.elements.addAll(policecars);
        super.elements.addAll(badguys);
        super.elements.addAll(joker);
        super.elements.add(door);
    }
}
