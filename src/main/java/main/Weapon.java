package main;

import java.awt.image.BufferedImage;

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
    String weaponCode;
    int width;
    int height;
    int damage; //basic damage to aircraft
    int movingSpeed;    //bullet movingSpeed
    int range;  //bullet fly range
    BufferedImage weaponImage;

    public String getWeaponCode() {
        return weaponCode;
    }

    public void setWeaponCode(String weaponCode) {
        this.weaponCode = weaponCode;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public BufferedImage getWeaponImage() {
        return weaponImage;
    }

    public void setWeaponImage(BufferedImage weaponImage) {
        this.weaponImage = weaponImage;
    }
}
