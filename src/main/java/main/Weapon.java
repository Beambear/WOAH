package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: Weapon
// 	Description:
//		This class is an object class.
//      Weapon is the parent class for other weapons
//      Contains 5 attributes
//      Contains getters and setters.
//
public class Weapon {
    int x;  //location x
    int y;  //location y
    int damage; //basic damage to aircraft
    int movingSpeed;    //bullet movingSpeed
    int range;  //bullet fly range


    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMovingSpeed() {
        return movingSpeed;
    }

    public void setMovingSpeed(int movingSpeed) {
        this.movingSpeed = movingSpeed;
    }
}
