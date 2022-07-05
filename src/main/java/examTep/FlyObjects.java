package examTep;

import util.GameUtil;

import java.awt.*;

//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: FlyObjects
// 	Description:
//		This is a generic class to store different
//      types of objects which are flying in the game.
//      Contains method add, remove, clearAll
//      Contains getters & setters.
public abstract class FlyObjects {
    private String imgPath;
    private int x;
    private int y;


    //////////////////////////////////////////////////////////
    //	Constructor to initialize the FlyObjects array list //
    //	Input	: imgpath, x ,y    				        	//
    //	Output	: None										//
    //////////////////////////////////////////////////////////
    public FlyObjects(String img,int x, int y){
        this.imgPath = img;
        this.x = x;
        this.y =y;
    }

    //////////////////////////////////////////////////////////
    //	Check if object is out of screen                    //
    //	Input	: None          				        	//
    //	Output	: None										//
    //////////////////////////////////////////////////////////
    public boolean isOut(){
        if(x <= -300){
            return true;
        }
        return false;
    }

    //////////////////////////////////////////////////////////
    //	Check if object hit player                          //
    //	Input	: None          				        	//
    //	Output	: None										//
    //////////////////////////////////////////////////////////
    public abstract void hitPlayer();

}