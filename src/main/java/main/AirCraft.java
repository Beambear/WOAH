package main;

//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: AirCraft
// 	Description:
//		This class is an object class.
//      Aircraft is the parent class of Player and enemies
//      Contains 2 attributes
//      Contains getter & setter
//      Contains a isZeroFuel to check whether aircraft is dead.
//


public class AirCraft {
//////////////////////////////////////////////////////////
//	Boolean method to check whether aircraft is dead    //
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public boolean isZeroFuel(){
        if(fuel == 0){
            return true;
        }
        return false;
    }

    private int fuel;   //fuel point, similar to health point.
    int moveSpeed;      //aircraft move speed on the screen.

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

}
