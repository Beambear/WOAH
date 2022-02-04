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
import java.util.ArrayList;

public class Player extends AirCraft {
    int playerLocationX=200;
    int playerLocationY=400;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    int ultSpellCount;
    int score;
    Inventory<WeaponPlayer> mainWeaponInventory;    //store main weapon
    Inventory<Item> itemInventory;                  //store items
//    Weapon autoSupportWeapon
    private BufferedImage aircraftPlayerImage;    //player aircraft image
    ArrayList<WeaponBullet> bulletList; //store current displayed bullets
    Graphics g;
    //player status

//////////////////////////////////////////////////////////
//	Void method to allow player shoot bullet out        //
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void useItem(Player player){
        System.out.println("use item: "+mainWeaponInventory.getInventory(0).getWeaponCode());
        itemInventory.getInventory(0).useItem(player);
    }


//////////////////////////////////////////////////////////
//	Void method to allow player shoot bullet out        //
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void fire(){
        System.out.println("firing: "+mainWeaponInventory.getInventory(0).getWeaponCode());
        bulletList.add(new WeaponBullet(mainWeaponInventory.getInventory(0), playerLocationX,playerLocationY ));
    }

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
    private void actionLogic(){
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
//	Void method to set the movement boolean value       //
//	Input	: movement  								//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void actionControl(int movement){
        switch(movement){
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
            case 9:
                fire();
                break;
            case 10:
                System.out.println("main weapon: "+mainWeaponInventory.getInventory(0).getWeaponCode()+" -> "+mainWeaponInventory.getInventory(1).getWeaponCode());
                mainWeaponInventory.switchItem();
                break;
            case 11:
                System.out.println("item: "+itemInventory.getInventory(0).getItemCode()+" -> "+itemInventory.getInventory(1).getItemCode());
                itemInventory.switchItem();
                break;
        }
    }
    public void actionControl(int movement,Player player){
        switch(movement){
            case 12:
                System.out.println("use item: "+itemInventory.getInventory(0).getItemCode());
                itemInventory.getInventory(0).useItem(player);
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
        aircraftPlayerImage = GameUtil.loadBufferedImage(Constant.AIRCRAFT_PLAYER_DEFAULT);
        fuel=100;     //initial fuel point = 100;
        moveSpeed=10;  //default move speed = 5;
        mainWeaponInventory = new Inventory<WeaponPlayer>();    //initialize main weapon inventory
        mainWeaponInventory.add(new WeaponPlayer("player01"));  //add default weapon
        mainWeaponInventory.add(new WeaponPlayer("player02"));  //add second weapon //further day, 2nd weapon is picked up during game play
        itemInventory = new Inventory<Item>();  //initialize item inventory
        itemInventory.add(new Item("item01"));  //add item 01 //further day, all item is picked up during game play
        itemInventory.add(new Item("item02"));  //add item 02 //further day, all item is picked up during game play
        bulletList = new ArrayList<>(); //initialize shot bullet list
    }


//////////////////////////////////////////////////////////
//	void method to draw player aircraft image           //
//	Input	: Graphics      				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void paint(Graphics g){
        this.g = g;
        actionLogic();
        g.drawImage(aircraftPlayerImage,playerLocationX,playerLocationY,null); //draw player image
        for(int i=0;i<bulletList.size();i++){
            bulletList.get(i).paint(g); //draw bullet image out
        }
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
                    System.out.println("fuel: "+(super.getFuel()+1)+" -> "+super.getFuel());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
