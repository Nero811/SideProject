import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Author:Jack Yang
 * Date:2023/05/27
 * Description:Fruit Class
 */
public class Fruit {
    private int x;
    private int y;
    private ImageIcon img;
    public Fruit(){
        //img = new ImageIcon("fruit.png");
        img = new ImageIcon(getClass().getResource("fruit.png"));
        this.x = (int) (Math.floor(Math.random() * Main.column) * Main.CELL_SIZE);
        this.y = (int) (Math.floor(Math.random() * Main.row) * Main.CELL_SIZE);
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void DrawFruit(Graphics g){
//        g.setColor(Color.YELLOW);
//        g.fillOval(this.x,this.y,Main.CELL_SIZE,Main.CELL_SIZE);
        img.paintIcon(null, g, this.x, this.y);
    }
    public void SetNewLocation(Snake s){
        int newX;
        int newY;
        boolean overlapping;
        do{
            newX = (int) (Math.floor(Math.random() * Main.column) * Main.CELL_SIZE);
            newY = (int) (Math.floor(Math.random() * Main.row) * Main.CELL_SIZE);
            overlapping = CheckOverlap(newX,newY,s);
        }while (overlapping);
        this.x = newX;
        this.y = newY;
    }
    private boolean CheckOverlap(int newX,int newY,Snake s){
        ArrayList<Node> snakebody = new ArrayList<>();
        snakebody=s.GetSnakeBody();
        for(int i=0 ; i < snakebody.size() ; i++){
            if(newX == snakebody.get(i).x && newY == snakebody.get(i).y){
                return true;
            }
        }
        return false;
    }
}
