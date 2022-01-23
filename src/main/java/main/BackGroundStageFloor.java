package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGroundStageFloor {
    //image & image path
    private BufferedImage stageImage;
    //rolling speed
    private int stageSpeed;
    //location
    private int x;
    private int y;

    public BackGroundStageFloor(){}

    public BackGroundStageFloor(BufferedImage stageImage, int stageSpeed, int x, int y) {
        this.stageImage = stageImage;
        this.stageSpeed = stageSpeed;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
        x-=stageSpeed;
        g.drawImage(stageImage,x,y,null );
    }
}
