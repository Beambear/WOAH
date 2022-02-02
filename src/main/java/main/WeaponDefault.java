package main;

import util.Constant;
import util.GameUtil;

import java.awt.*;

//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: WeaponBullet
// 	Description:
//		This class is an object class.
//      WeaponBullet is the child class of Weapon
//      Contains 4 attributes
//      Contains getters and setters.
//
public class WeaponDefault extends Weapon{

//////////////////////////////////////////////////////////
//	Constructor to initialize WeaponBullet              //
//	Input	: fire location x,y     		        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public WeaponDefault(){
        movingSpeed = 8;
        damage = 10;
        range = 600;
        weaponImage = GameUtil.loadBufferedImage(Constant.WEAPON_BULLET);
        width = weaponImage.getWidth();
        height= weaponImage.getHeight();
        bulletFlyLogic();
    }

//////////////////////////////////////////////////////////
//	The working logic for bullet                        //
//  Straight fly hit target with the basic damage.      //
//	Input	: None              			        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void bulletFlyLogic(int x, int y){
        x+= movingSpeed;
        paint(Graphics g, x ,y);
    }

//////////////////////////////////////////////////////////
//	void method to draw bullet image                    //
//	Input	: Graphics      				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void paint(Graphics g){
        g.drawImage(weaponImage,x,y,null );
    }

}
