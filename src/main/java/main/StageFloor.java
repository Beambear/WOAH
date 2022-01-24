package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StageFloor extends EnvironmentObject {
    //image & image path
    private BufferedImage stageImage;
    //rolling speed
    private int stageSpeed;

    public StageFloor(){}

    public StageFloor(BufferedImage stageImage, int stageSpeed, int x, int y) {
        this.stageImage = stageImage;
        this.stageSpeed = stageSpeed;
        super.setX(x);
        super.setY(y);
    }

    public void paint(Graphics g){
        super.setX(super.getX()-stageSpeed);
        g.drawImage(stageImage,super.getX(),super.getY(),null );
    }
}
