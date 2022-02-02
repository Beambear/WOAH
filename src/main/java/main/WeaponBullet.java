package main;
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
public class WeaponBullet extends Weapon{

//////////////////////////////////////////////////////////
//	Constructor to initialize WeaponBullet              //
//	Input	: fire location x,y     		        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public WeaponBullet(int x, int y){
        movingSpeed = 8;
        damage = 10;
        this.x = x;
        this.y = y;
        logic();
    }

//////////////////////////////////////////////////////////
//	The working logic for bullet                        //
//  Straight fly hit target with the basic damage.      //
//	Input	: None              			        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void logic(){

    }
}
