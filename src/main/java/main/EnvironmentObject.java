package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: EnvironmentObject
// 	Description:
//      A abstract class
//		This class is the parent class of StageCeilling and StageFloor
//      Contains 2 attributes
//      Contains getters and setters
//      Contains methods to check whether object is out of frame window.
//
public abstract class EnvironmentObject {
    //location
    private int x;
    private int y;

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

//////////////////////////////////////////////////////////
//	Boolean method check whether object is              //
//      	out of frame window                         //
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public boolean isOutWindow(){
        if(x<-700){
            return true;
        }
        return false;
    }
}
