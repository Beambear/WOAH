package main;

import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends AirCraft {
    int playerLocationX=200;
    int playerLocationY=400;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    int ultSpellCount;
    int score;
    int fuel;
//    Weapon mainWeapon;
//    Weapon autoSupportWeapon

    //player aircraft image
    private BufferedImage aircraftPlayerImage;

    //player status

    //Player movement control
    public void flyLogic(){
        if(up==true){
            playerLocationY-=speedPlayer;
            if(playerLocationY<50){
                playerLocationY=50;
            }
        }else if(down == true){
            playerLocationY+=speedPlayer;
            if(playerLocationY>Constant.GROUND_HEIGHT){
                playerLocationY=Constant.GROUND_HEIGHT;
            }
        }else if(left == true){
            playerLocationX-=speedPlayer;
        }else if(right == true){
            playerLocationX+=speedPlayer;
            if(playerLocationX>Constant.FRAM_WIDTH){
                playerLocationX=Constant.FRAM_WIDTH;
            }
        }
    }

    public void flyControl(int moveDirection){
        switch(moveDirection){
            case 1:
//                System.out.println("moving up");
                up=true;
                break;
            case 2:
                down=true;
                break;
            case 3:
                left=true;
                break;
            case 4:
                right=true;
                break;
            case 5:
                up=false;
                break;
            case 6:
                down=false;
                break;
            case 7:
                left=false;
                break;
            case 8:
                right=false;
                break;
        }
    }

    //initial move speed
    private int speedPlayer = 4;

    //initialize player aircraft
    public Player(){
        up=false;
        down=false;
        left=false;
        right=false;
        aircraftPlayerImage = GameUtil.loadBufferedImage(Constant.aircraftPlayerDef);
    }
//

    //Control aircraft
    public void paint(Graphics g){
        flyLogic();
        g.drawImage(aircraftPlayerImage,playerLocationX,playerLocationY,null);
    }

}
