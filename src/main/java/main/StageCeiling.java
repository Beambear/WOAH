package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: StageCeilling
// 	Description:
//		This class is an object class.
//      StageCeilling is a child class of EnvironmentObject
//      Contains 2 attributes
//      Contains constructor methods
//      Contains a void method to draw graphics in the frame window
//
import java.awt.*;
import java.awt.image.BufferedImage;

public class StageCeiling extends EnvironmentObject {
    private BufferedImage ceilingImage;  //image & image path
    private int stageSpeed;              //rolling speed

    public StageCeiling(){}

//////////////////////////////////////////////////////////
//	Constructor to initialize frontground source        //
//	Input	: BufferedImage, stageSpeed, x, y			//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public StageCeiling(BufferedImage stageImage, int stageSpeed, int x, int y) {
        this.ceilingImage = stageImage;
        this.stageSpeed = stageSpeed;
        super.setX(x);
        super.setY(y);
    }

//////////////////////////////////////////////////////////
//	void method to draw StageCeilling image             //
//	Input	: Graphics      				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void paint(Graphics g){
        super.setX(super.getX()-stageSpeed);
        g.drawImage(ceilingImage,super.getX(),super.getY(),null );
    }

}
