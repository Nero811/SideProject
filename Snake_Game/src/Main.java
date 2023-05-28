import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author:Jack Yang
 * Date:2023/05/26
 * Description:Main Class
 */
public class Main extends JPanel implements KeyListener {
    protected static final int CELL_SIZE = 20;
    protected static int width = 400;
    protected static int height = 400;
    protected static int row = height/CELL_SIZE;
    protected static int column = width/CELL_SIZE;
    private Snake snake;
    private Fruit fruit;
    private Timer t;
    private int speed;
    private static String direction;
    private boolean allowKeypress;
    private int score;
    private int highest_score;
    String desktop = System.getProperty("user.home") + "/Desktop/";
    String myFile = desktop + "filename.txt";
    public Main(){
        this.ReadHighestScore();
        this.reset();
        super.addKeyListener(this);
    }
    private int SetGameLevel(){ //define the speed
        String[] options = {"EASY","NORMAL","HARD"};
        int choice = JOptionPane.showOptionDialog(this,"Choose the difficulty level for the Game.",
                "Click a buttom",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,
                options,options[0]);
        switch (choice){
            case 0:
                return 150;
            case 1:
                return 100;
            case 2:
                return 50;
            case JOptionPane.CLOSED_OPTION:
                System.exit(0);
                break;
        }
        return 0;
    }
    private void SetTimer(){
        speed=this.SetGameLevel();
        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        },0,speed);
    }
    private void reset(){
        score = 0;
        if(snake != null){
            snake.GetSnakeBody().clear();
        }
        allowKeypress = true;
        direction = "Right";
        snake = new Snake();
        fruit = new Fruit();
        this.SetTimer();
    }
    @Override
    public  void  paintComponent(Graphics g){
        ArrayList<Node>snakeBody = snake.GetSnakeBody();
        Node head = snakeBody.get(0);
        for(int i=1 ; i < snakeBody.size() ;i++){
            if(head.x == snakeBody.get(i).x && head.y == snakeBody.get(i).y){
                allowKeypress = false;
                t.cancel();
                t.purge();
                int response = JOptionPane.showOptionDialog(this,
                        "Game Over!! "+ "Your score is "+score+". The Highest Score in history is "+highest_score+". \n"+"Would you like to start over?",
                        "GameOver",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,
                        null,null,JOptionPane.YES_OPTION);
                this.Write_A_File(score);
                switch (response){
                    case JOptionPane.CLOSED_OPTION:
                        System.exit(0);
                        break;
                    case JOptionPane.NO_OPTION:
                        System.exit(0);
                        break;
                    case JOptionPane.YES_OPTION:
                        this.reset();
                        break;
                }
            }
        }
        g.fillRect(0,0,width,height);
        snake.DrawSnake(g);
        fruit.DrawFruit(g);
        //get head x,y
        int snakeX = snake.GetSnakeBody().get(0).x;
        int snakeY = snake.GetSnakeBody().get(0).y;
        switch (direction){
            case "Left":
                snakeX -= CELL_SIZE;
                break;
            case "Up":
                snakeY -= CELL_SIZE;
                break;
            case "Right":
                snakeX += CELL_SIZE;
                break;
            case "Down":
                snakeY += CELL_SIZE;
                break;
        }
        Node newHead = new Node(snakeX,snakeY);
        //IF Snake eat the food
        if(snake.GetSnakeBody().get(0).x == fruit.getX() && snake.GetSnakeBody().get(0).y == fruit.getY()){
            fruit.SetNewLocation(snake);
            fruit.DrawFruit(g);
            score+=10;
        }
        else{
            snake.GetSnakeBody().remove(snake.GetSnakeBody().size()-1);
        }

        snake.GetSnakeBody().add(0,newHead);
        allowKeypress = true;
        super.requestFocusInWindow();
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(width,height);
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

    public void ReadHighestScore(){
        try{
            File myObj = new File(myFile);
            Scanner myReader = new Scanner(myObj);
            myReader.close();
        }
        catch (FileNotFoundException e){
            highest_score = 0;
            try {
                File myObj = new File(myFile);
                if(myObj.createNewFile()){
                    System.out.println("File created: " + myObj.getName());
                }
                FileWriter myWriter = new FileWriter(myObj.getName());
                myWriter.write(""+0);
            }
            catch (IOException err){
                System.out.println("An error occurred");
                err.printStackTrace();
            }
        }
    }
    public void Write_A_File(int score){
        try{
            FileWriter myWriter = new FileWriter(myFile);
            if(score > highest_score){
                myWriter.write(""+score);
                highest_score = score;
            }
            else{
                myWriter.write(""+highest_score);
            }
            myWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(allowKeypress){
            if((e.getKeyCode() == 37 || e.getKeyCode()==65)&& !direction.equals("Right")){
                direction = "Left";
            }
            else if((e.getKeyCode() == 38 || e.getKeyCode()==87)&& !direction.equals("Down")){
                direction = "Up";
            }
            else if((e.getKeyCode() == 39 || e.getKeyCode()==68)&& !direction.equals("Left")){
                direction = "Right";
            }
            else if((e.getKeyCode() == 40 || e.getKeyCode()==83)&& !direction.equals("Up")){
                direction = "Down";
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
