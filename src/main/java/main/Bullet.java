package main;

import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {
    Weapon currWeapon;
    int x;  //location x
    int y;  //location y
    int width;
    int height;
    int damage; //basic damage to aircraft
    int movingSpeed;    //bullet movingSpeed

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getWeaponImage() {
        return weaponImage;
    }

    public void setWeaponImage(BufferedImage weaponImage) {
        this.weaponImage = weaponImage;
    }

    int range;  //bullet fly range
    BufferedImage weaponImage;
//////////////////////////////////////////////////////////
//	Constructor to initialize WeaponBullet              //
//	Input	: fire location x,y     		        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public Bullet(Weapon currWeapon,int x,int y){
        this.currWeapon = currWeapon;
        movingSpeed = currWeapon.getMovingSpeed();
        damage = currWeapon.getDamage();
        range = currWeapon.getRange();
        this.x = x;
        this.y = y;
        weaponImage = GameUtil.loadBufferedImage(Constant.WEAPON_BULLET);
        width = weaponImage.getWidth();
        height= weaponImage.getHeight();
        currWeapon.bulletFlyLogic(x,y);
    }

////////////////////////////////////////////////////////////
////	The working logic for bullet                        //
////  Straight fly hit target with the basic damage.      //
////	Input	: None              			        	//
////	Output	: None										//
////////////////////////////////////////////////////////////
//    public void flyLogic(){
//        x += movingSpeed;
//    }
//
////////////////////////////////////////////////////////////
////	void method to draw bullet image                    //
////	Input	: Graphics      				        	//
////	Output	: None										//
////////////////////////////////////////////////////////////
//    public void paint(Graphics g){
//        g.drawImage(weaponImage,x,y,null );
//    }
}