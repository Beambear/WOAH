package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StageCeiling extends EnvironmentObject {
    //image & image path
    private BufferedImage ceilingImage;
    //rolling speed
    private int stageSpeed;

    public StageCeiling(){}

    //constructor to initialize frontground source
    public StageCeiling(BufferedImage stageImage, int stageSpeed, int x, int y) {
        this.ceilingImage = stageImage;
        this.stageSpeed = stageSpeed;
        super.setX(x);
        super.setY(y);
    }

    public void paint(Graphics g){
        super.setX(super.getX()-stageSpeed);
        g.drawImage(ceilingImage,super.getX(),super.getY(),null );
    }

}
