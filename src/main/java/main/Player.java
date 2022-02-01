package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: Player
// 	Description:
//		This class is an object class.
//      Player is a child class of Aircraft
//      Contains 10 attributes
//      Contains methods for player control system and abilities.
//
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
//    Weapon mainWeapon;
//    Weapon autoSupportWeapon

    //player aircraft image
    private BufferedImage aircraftPlayerImage;

    //player status

//////////////////////////////////////////////////////////
//	Void method to keep player aircraft stay in frame   //
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
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

//////////////////////////////////////////////////////////
//	Void method to control player aircraft movement     //
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void flyLogic(){
        if(up&&!down&&!left&&!right){       //up
            playerLocationY-=super.getMoveSpeed();
            boundaryCheck();
        }else if(!up&&down&&!left&&!right){ //down
            playerLocationY+=super.getMoveSpeed();
            boundaryCheck();
        }else if(!up&&!down&&left&&!right){ //left
            playerLocationX-=super.getMoveSpeed();
            boundaryCheck();
        }else if(!up&&!down&&!left&&right){ //right
            playerLocationX+=super.getMoveSpeed();
            boundaryCheck();
        }else if(up&&!down&&!left&&right){  //up & right
            playerLocationX+=super.getMoveSpeed();
            playerLocationY-=super.getMoveSpeed();
            boundaryCheck();
        }else if(up&&!down&&left&&!right){ //up & left
            playerLocationX-=super.getMoveSpeed();
            playerLocationY-=super.getMoveSpeed();
            boundaryCheck();
        }else if(!up&&down&&!left&&right){ //down & right
            playerLocationX+=super.getMoveSpeed();
            playerLocationY+=super.getMoveSpeed();
            boundaryCheck();
        }else if(!up&&down&&left&&!right){ //down & left
            playerLocationX-=super.getMoveSpeed();
            playerLocationY+=super.getMoveSpeed();
            boundaryCheck();
        }
    }

//////////////////////////////////////////////////////////
//	Void method to set the movement directions          //
//	Input	: moveDirection								//
//	Output	: None										//
//////////////////////////////////////////////////////////
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


//////////////////////////////////////////////////////////
//	Constructor to initialize player aircraft           //
//	Input	: None							        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public Player(){
        up=false;
        down=false;
        left=false;
        right=false;
        aircraftPlayerImage = GameUtil.loadBufferedImage(Constant.aircraftPlayerDef);
        super.setFuel(100);     //initial fuel point = 100;
        super.setMoveSpeed(5);  //default move speed = 5;
    }


//////////////////////////////////////////////////////////
//	void method to draw player aircraft image           //
//	Input	: Graphics      				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void paint(Graphics g){
        flyLogic();
        g.drawImage(aircraftPlayerImage,playerLocationX,playerLocationY,null);
    }

//////////////////////////////////////////////////////////
//	void method to decrease fuel point continuously     //
//	Input	: None           				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public  void fuelCosting() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000); //every 3 seconds
                    super.setFuel(super.getFuel()-1);
                    System.out.println("Current fuel: "+super.getFuel());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
