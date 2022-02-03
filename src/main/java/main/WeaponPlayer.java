package main;

import util.Constant;
import util.GameUtil;

import java.awt.*;

//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: WeaponPlayer
// 	Description:
//		This class is an object class.
//      WeaponPlayer is the child class of Weapon
//      Describes the player equipped weapon information
//      Contains constructor method, and methods for different weapon.
//
public class WeaponPlayer extends Weapon{

//////////////////////////////////////////////////////////
//	Default constructor                                 //
//	Input	: NOne                   		        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public WeaponPlayer(){};

//////////////////////////////////////////////////////////
//	Constructor to initialize WeaponBullet depends on   //
//	the weaponCode                                      //
//	Input	: String weaponCode         		       	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public WeaponPlayer(String weaponCode){
        switch(weaponCode){
            case "player01":
                weaponBasic();
                break;
            case "player02":
                weaponCurve();
                break;
        }
    }

//////////////////////////////////////////////////////////
//	set the basic attributes data for basic weapon      //
//	Input	: fire location x,y     		        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void weaponBasic(){
        weaponCode = "player01";
        movingSpeed = 20;
        damage = 10;
        range = 600;
        weaponImage = GameUtil.loadBufferedImage(Constant.WEAPON_DEFAULT);
        width = weaponImage.getWidth();
        height= weaponImage.getHeight();
    }

//////////////////////////////////////////////////////////
//	set the basic attributes data for basic weapon      //
//	Input	: fire location x,y     		        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void weaponCurve(){
        weaponCode = "player02";
        movingSpeed = 25;
        damage = 15;
        range = 400;
        weaponImage = GameUtil.loadBufferedImage(Constant.WEAPON_CURVE);
        width = weaponImage.getWidth();
        height= weaponImage.getHeight();
    }


//////////////////////////////////////////////////////////
//	The working logic for bullet                        //
//  Straight fly hit target with the basic damage.      //
//	Input	: None              			        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void basicFlyLogic(int x, int y){
        x+= movingSpeed;
    }
//
////////////////////////////////////////////////////////////
////	void method to draw bullet image                    //
////	Input	: Graphics      				        	//
////	Output	: None										//
////////////////////////////////////////////////////////////
//    public void paint(Graphics g){
////        g.drawImage(weaponImage,x,y,null );
//    }

}
