package com.company.GameView;
import com.company.Main;
import com.company.Sprite.*;
import com.company.Sprite.FinalStageSprite.Key;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:GameView Class
 */
public abstract class GameView {
    protected ArrayList<Sprite> elements;
    protected Door door;
    protected Key key;
    protected ImageIcon img;
    public ArrayList<Sprite> getElements(){
        return elements;
    }
    public Door getDoor(){
        return this.door;
    }
    public Key getKey(){return this.key;}
    public void drawView(Graphics g){
        img.paintIcon(null,g,0,0);
        g.setColor(new Color(0f,0f,0f,.3f));
        g.fillRect(0,0, Main.WIDTH,Main.HEIGHT);
        for(Sprite s : elements){
            s.draw(g);
        }
    }
}
