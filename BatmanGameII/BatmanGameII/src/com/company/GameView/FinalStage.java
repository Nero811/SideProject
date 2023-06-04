package com.company.GameView;

import com.company.Sprite.FinalStageSprite.Catwoman;
import com.company.Sprite.FinalStageSprite.Gate;
import com.company.Sprite.FinalStageSprite.Key;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:FinalStage
 */
public class FinalStage extends GameView{
    public FinalStage(){
        img = new ImageIcon("src/image/finalstage.jpg");
        super.elements = new ArrayList<>();
        catwoman = new Catwoman(5,5);
        gates.add(new Gate(4,4));
        gates.add(new Gate(5,4));
        gates.add(new Gate(6,4));
        gates.add(new Gate(4,5));
        gates.add(new Gate(4,6));
        gates.add(new Gate(6,5));
        gates.add(new Gate(6,6));
        gates.add(new Gate(5,6));
        key = new Key(10,1);
        super.elements.add(catwoman);
        super.elements.addAll(gates);
        super.elements.add(key);
    }
    private Catwoman catwoman;

    public Key getKey() {
        return key;
    }

    public ArrayList<Gate> getGates() {
        return gates;
    }

    private Key key;
    private ArrayList<Gate> gates = new ArrayList<>();

    public Catwoman getCatwoman() {
        return catwoman;
    }
}
