package main;

import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends AirCraft {
    int ultSpellCount;
    int score;
    int fuel;
//    Weapon mainWeapon;
//    Weapon autoSupportWeapon

    //player aircraft image
    private BufferedImage aircraftPlayerImage;

    //player status

    //initialize player aircraft
    public Player(){
        aircraftPlayerImage = GameUtil.loadBufferedImage(Constant.aircraftPlayerDef);
    }
//    //player aircraft initial location in window
//    public static final int FRAM_X=400;
//    public static final int FRAM_Y=400;

    //Control aircraft
    public void paint(Graphics g){
        g.drawImage(aircraftPlayerImage,400,400,null);
    }

}
