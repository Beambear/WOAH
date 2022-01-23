package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FrontGroundStageCeiling {
    //image & image path
    private BufferedImage ceilingImage;
    //rolling speed
    private int ceilingSpeed;
    //location
    private int x;
    private int y;

    public FrontGroundStageCeiling(){}

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
}
