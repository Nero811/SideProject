package com.company;
import com.company.GameView.FinalStage;
import com.company.GameView.GothamStage;
import com.company.GameView.IceStage;
import com.company.GameView.GameView;
import com.company.Sprite.Batman;
import com.company.Sprite.GothamStageSprite.Badguy;
import com.company.Sprite.GothamStageSprite.Joker;
import com.company.Sprite.GothamStageSprite.Policecar;
import com.company.Sprite.IceStageSprite.Gangster;
import com.company.Sprite.IceStageSprite.Freeze;
import com.company.Sprite.IceStageSprite.Ice;
import com.company.Sprite.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Author:Jack Yang
 * Date:2023/06/03
 * Description:Main Class
 */
public class Main extends JPanel implements KeyListener {
    public static final int CELL = 50;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int ROW = HEIGHT/CELL;
    public static final int COLUMN = WIDTH/CELL;
    Batman batman;
    public static GameView gameView;
    private int level;
    public Main(){
        level = 1;
        this.restGame(new IceStage());
        this.addKeyListener(this);
    }
    public void restGame(GameView game){
        batman = new Batman(1,1);
        gameView = game;
        repaint();
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(WIDTH,HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g){
        gameView.drawView(g);
        batman.draw(g);
        this.requestFocusInWindow();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }
    private boolean changeLevel(String result){
        if(result.equals("Next level")){
            level++;
            if (level == 2){
                this.restGame(new GothamStage());
            }
            else if(level == 3){
                this.restGame(new FinalStage());
            }
            return true;
        }
        return false;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point batmanPoint = batman.getRelativePosition();
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                String result = batman.overlap(batmanPoint.x,batmanPoint.y-1);
                if(result.equals("Die")){
                    JOptionPane.showMessageDialog(this,"The Enemy find out Batman.Please try again.");
                    level = 1;
                    this.restGame(new IceStage());
                    return;
                }
                if(!result.equals("Can't Move") && !result.equals("Can't Move ,must have the key") && !result.equals("Find the key")){
                    if(batmanPoint.y > 1){
                        batmanPoint.y -= 1;
                    }
                }
                if(result.equals("Find the key")){
                    gameView.getKey().setNUllPosition();
                    repaint();
                    return;
                }
                if(result.equals("Can't Move ,must have the key")){
                    JOptionPane.showMessageDialog(this,"Batman must get the key to open the gate");
                    return;
                }
                if(result.equals("Game Over")){
                    JOptionPane.showMessageDialog(this,"You Win !!");
                    return;
                }
                if(this.changeLevel(result))return;
                break;
            case KeyEvent.VK_DOWN:
                result = batman.overlap(batmanPoint.x,batmanPoint.y+1);
                if(result.equals("Die")){
                    JOptionPane.showMessageDialog(this,"The Enemy find out Batman.Please try again.");
                    level = 1;
                    this.restGame(new IceStage());
                    return;
                }
                if(!result.equals("Can't Move") && !result.equals("Can't Move ,must have the key") && !result.equals("Find the key")){
                    if(batmanPoint.y < ROW){
                        batmanPoint.y += 1;
                    }
                }
                if(result.equals("Find the key")){
                    gameView.getKey().setNUllPosition();
                    repaint();
                    return;
                }
                if(result.equals("Can't Move ,must have the key")){
                    JOptionPane.showMessageDialog(this,"Batman must get the key to open the gate");
                    return;
                }
                if(result.equals("Game Over")){
                    JOptionPane.showMessageDialog(this,"You Win !!");
                    return;
                }
                if(this.changeLevel(result))return;
                break;
            case KeyEvent.VK_LEFT:
                result = batman.overlap(batmanPoint.x-1,batmanPoint.y);
                if(result.equals("Die")){
                    JOptionPane.showMessageDialog(this,"The Enemy find out Batman.Please try again.");
                    level = 1;
                    this.restGame(new IceStage());
                    return;
                }
                if(!result.equals("Can't Move") && !result.equals("Can't Move ,must have the key") && !result.equals("Find the key")){
                    if(batmanPoint.x > 1){
                        batmanPoint.x -= 1;
                    }
                }
                if(result.equals("Find the key")){
                    gameView.getKey().setNUllPosition();
                    repaint();
                    return;
                }
                if(result.equals("Can't Move ,must have the key")){
                    JOptionPane.showMessageDialog(this,"Batman must get the key to open the gate");
                    return;
                }

                if(result.equals("Game Over")){
                    JOptionPane.showMessageDialog(this,"You Win !!");
                    return;
                }
                if(this.changeLevel(result))return;
                break;
            case  KeyEvent.VK_RIGHT:
                result = batman.overlap(batmanPoint.x+1,batmanPoint.y);
                if(result.equals("Die")){
                    JOptionPane.showMessageDialog(this,"The Enemy find out Batman.Please try again.");
                    level = 1;
                    this.restGame(new IceStage());
                    return;
                }
                if(!result.equals("Can't Move") && !result.equals("Can't Move ,must have the key") && !result.equals("Find the key")){
                    if(batmanPoint.x < COLUMN){
                        batmanPoint.x += 1;
                    }
                }
                if(result.equals("Find the key")){
                    gameView.getKey().setNUllPosition();
                    repaint();
                    return;
                }
                if(result.equals("Can't Move ,must have the key")){
                    JOptionPane.showMessageDialog(this,"Batman must get the key to open the gate");
                    return;
                }
                if(result.equals("Game Over")){
                    JOptionPane.showMessageDialog(this,"You Win !!");
                    return;
                }
                if(this.changeLevel(result))return;
                break;

            case KeyEvent.VK_W:
                for(int i = batmanPoint.y; i > 0 ; i--){
                    for(Sprite s : gameView.getElements()){
                        if (s.getRelativePosition() != null && s.getRelativePosition().x == batmanPoint.x && s.getRelativePosition().y == i){
                            if(s instanceof Policecar || s instanceof Ice){
                                return;
                            }
                            if(s instanceof Gangster || s instanceof Freeze || s instanceof Badguy || s instanceof Joker){
                                s.setNUllPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;
            case KeyEvent.VK_S:
                for(int i = batmanPoint.y; i <= ROW ; i++){
                    for(Sprite s : gameView.getElements()){
                        if (s.getRelativePosition() != null && s.getRelativePosition().x == batmanPoint.x && s.getRelativePosition().y == i){
                            if(s instanceof Policecar || s instanceof Ice){
                                return;
                            }
                            if(s instanceof Gangster || s instanceof Freeze || s instanceof Badguy || s instanceof Joker){
                                s.setNUllPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;
            case KeyEvent.VK_A:
                for(int i = batmanPoint.x; i > 0 ; i--){
                    for(Sprite s : gameView.getElements()){
                        if (s.getRelativePosition() != null && s.getRelativePosition().y == batmanPoint.y && s.getRelativePosition().x == i){
                            if(s instanceof Policecar || s instanceof Ice){
                                return;
                            }
                            if(s instanceof Gangster || s instanceof Freeze || s instanceof Badguy || s instanceof Joker){
                                s.setNUllPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;
            case KeyEvent.VK_D:
                for(int i = batmanPoint.x; i <= COLUMN ; i++){
                    for(Sprite s : gameView.getElements()){
                        if (s.getRelativePosition() != null && s.getRelativePosition().y == batmanPoint.y && s.getRelativePosition().x == i){
                            if(s instanceof Policecar || s instanceof Ice){
                                return;
                            }
                            if(s instanceof Gangster || s instanceof Freeze || s instanceof Badguy || s instanceof Joker){
                                s.setNUllPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;
        }
        batman.setPosition(batmanPoint);
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
