package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FrontGroundStageCeiling {
    //image & image path
    private BufferedImage ceilingImage;
    //rolling speed
    private int ceilingSpeed;

    public int getX() {
        return x;
    }

    //location
    private int x;
    private int y;

    public FrontGroundStageCeiling(){}

    //constructor to initialize frontground source
    public FrontGroundStageCeiling(BufferedImage stageImage, int stageSpeed, int x, int y) {
        this.ceilingImage = stageImage;
        this.ceilingSpeed = stageSpeed;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
        x-=ceilingSpeed;
        g.drawImage(ceilingImage,x,y,null );
    }

    //check if ceiling is out of window
    public boolean isOutWindow(){
        if(x<-700){
            return true;
        }
        return false;
    }
}
