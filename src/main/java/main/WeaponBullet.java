package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: WeaponBullet
// 	Description:
//		This class is an object class.
//      describe the bullet shot by current weapon.
//      Contains the bullet fly logic methods & paint method
//      Contains 7 attributes
//
import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WeaponBullet {
    Weapon currWeapon;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getBulletImage() {
        return bulletImage;
    }

    int x;  //location x
    int y;  //location y
    int endX;//disappear location x
    int endY;//disappear location y
    int width;
    int height;
    int damage; //basic damage to aircraft
    int movingSpeed;    //bullet movingSpeed
    int range;  //bullet shooting distance
    BufferedImage bulletImage;    //bullet image


    //////////////////////////////////////////////////////////
//	Constructor to initialize player's WeaponBullet     //
//	Input	: shot location x,y     		        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public WeaponBullet(WeaponPlayer currWeapon, int x, int y){
        this.currWeapon = currWeapon;
        movingSpeed = currWeapon.getMovingSpeed();
        damage = currWeapon.getDamage();
        range = currWeapon.getRange();
        this.x = x;
        this.y = y;
        bulletImage = currWeapon.getWeaponImage();
        width = bulletImage.getWidth();
        height= bulletImage.getHeight();
    }

//////////////////////////////////////////////////////////
//	The bullet working logic for player weapon 01       //
//  Straight fly hit target with the basic damage.      //
//	Input	: None              			        』//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void logicP01(){
        x += movingSpeed;
    }

//////////////////////////////////////////////////////////
//	The bullet working logic for player weapon 02       //
//  Straight fly hit target with the basic damage.      //
//	Input	: None              			        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void logicP02(){
        x += movingSpeed;
    }


//////////////////////////////////////////////////////////
//	void method to draw bullet image                    //
//	Input	: Graphics      				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void paint(Graphics g){

        switch (currWeapon.getWeaponCode()){
            case "player01":
                logicP01();
                break;
            case "player02":
                logicP02();
                break;
        }
        g.drawImage(bulletImage,x,y,null );
    }
}