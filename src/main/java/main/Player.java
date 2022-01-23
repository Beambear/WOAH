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
    private void boundaryCheck(){
        if(playerLocationY<50){
            playerLocationY=50;
        }
        if(playerLocationY>Constant.GROUND_HEIGHT){
            playerLocationY=Constant.GROUND_HEIGHT;
        }
        if(playerLocationX>Constant.FRAM_WIDTH){
            playerLocationX=Constant.FRAM_WIDTH;
        }
        if(playerLocationX<-20){
            playerLocationX=-20;
        }
    }
    public void flyLogic(){
        if(up&&!down&&!left&&!right){       //up
            playerLocationY-=speedPlayer;
            boundaryCheck();
        }else if(!up&&down&&!left&&!right){ //down
            playerLocationY+=speedPlayer;
            boundaryCheck();
        }else if(!up&&!down&&left&&!right){ //left
            playerLocationX-=speedPlayer;
            boundaryCheck();
        }else if(!up&&!down&&!left&&right){ //right
            playerLocationX+=speedPlayer;
            boundaryCheck();
        }else if(up&&!down&&!left&&right){  //up & right
            playerLocationX+=speedPlayer;
            playerLocationY-=speedPlayer;
            boundaryCheck();
        }else if(up&&!down&&left&&!right){ //up & left
            playerLocationX-=speedPlayer;
            playerLocationY-=speedPlayer;
            boundaryCheck();
        }else if(!up&&down&&!left&&right){ //down & right
            playerLocationX+=speedPlayer;
            playerLocationY+=speedPlayer;
            boundaryCheck();
        }else if(!up&&down&&left&&!right){ //down & left
            playerLocationX-=speedPlayer;
            playerLocationY+=speedPlayer;
            boundaryCheck();
        }
    }

    public void flyControl(int moveDirection){
        switch(moveDirection){
            case 1:
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
