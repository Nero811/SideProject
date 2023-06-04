package com.company.Sprite;

import com.company.GameView.FinalStage;
import com.company.GameView.GothamStage;
import com.company.GameView.IceStage;
import com.company.Main;
import com.company.Sprite.FinalStageSprite.Catwoman;
import com.company.Sprite.FinalStageSprite.Gate;
import com.company.Sprite.FinalStageSprite.Key;
import com.company.Sprite.GothamStageSprite.Badguy;
import com.company.Sprite.GothamStageSprite.Joker;
import com.company.Sprite.GothamStageSprite.Policecar;
import com.company.Sprite.IceStageSprite.Ice;
import com.company.Sprite.IceStageSprite.Freeze;
import com.company.Sprite.IceStageSprite.Gangster;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:Batman Class
 */
public class Batman extends Sprite{
    public Batman(int x,int y){
        super.setPosition(x,y);
        super.img = new ImageIcon("src/image/batman.png");
    }

    @Override
    public String overlap(int x, int y) {
        if (Main.gameView instanceof IceStage){
            ArrayList<Gangster> gangsters = ((IceStage) Main.gameView).getGangsters();
            ArrayList<Ice> ices = ((IceStage) Main.gameView).getIce();
            ArrayList<Freeze> freeze = ((IceStage) Main.gameView).getFreeze();
            for (Gangster g : gangsters){
                if(g.getRelativePosition() !=null && g.getRelativePosition().x == x && g.getRelativePosition().y == y){
                    return "Die";
                }
            }
            for (Freeze f : freeze){
                if(f.getRelativePosition() !=null && f.getRelativePosition().x == x && f.getRelativePosition().y == y){
                    return "Die";
                }
            }
            for (Ice i : ices){
                if(i.getRelativePosition() !=null && i.getRelativePosition().x == x && i.getRelativePosition().y == y){
                    return "Can't Move";
                }
            }

            Door door = Main.gameView.getDoor();
            if(x == door.getRelativePosition().x && y == door.getRelativePosition().y){
                return "Next level";
            }
        }
        else if (Main.gameView instanceof GothamStage){
            ArrayList<Badguy> badguys = ((GothamStage) Main.gameView).getBadguys();
            ArrayList<Policecar> policecars = ((GothamStage) Main.gameView).getPolicecars();
            ArrayList<Joker> joker = ((GothamStage) Main.gameView).getJoker();
            for (Badguy b : badguys){
                if(b.getRelativePosition() !=null && b.getRelativePosition().x == x && b.getRelativePosition().y == y){
                    return "Die";
                }
            }
            for (Joker j : joker){
                if(j.getRelativePosition() !=null && j.getRelativePosition().x == x && j.getRelativePosition().y == y){
                    return "Die";
                }
            }
            for (Policecar p : policecars){
                if(p.getRelativePosition() !=null && p.getRelativePosition().x == x && p.getRelativePosition().y == y){
                    return "Can't Move";
                }
            }
            Door door = Main.gameView.getDoor();
            if(x == door.getRelativePosition().x && y == door.getRelativePosition().y){
                return "Next level";
            }
        }
        else if (Main.gameView instanceof FinalStage){
            ArrayList<Gate> gates = ((FinalStage) Main.gameView).getGates();
            Key k = ((FinalStage) Main.gameView).getKey();
            if(k.getRelativePosition() !=null && k.getRelativePosition().x == x && k.getRelativePosition().y == y){
                return "Find the key";
            }
            for (Gate g : gates){
                if(g.getRelativePosition() !=null && g.getRelativePosition().x == x && g.getRelativePosition().y == y){
                    if(k.getRelativePosition() != null){
                        return "Can't Move ,must have the key";
                    }
                    else {
                        return "Got the key";
                    }
                }
            }
            Catwoman c = ((FinalStage) Main.gameView).getCatwoman();
            if(c.getRelativePosition() !=null && c.getRelativePosition().x == x && c.getRelativePosition().y == y){
                return "Game Over";
            }
        }
        return "none";
    }
}
