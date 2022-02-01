package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: StageFloor
// 	Description:
//		This class is an object class.
//      StageFloor is a child class of EnvironmentObject
//      Contains 2 attributes
//      Contains constructor methods
//      Contains a void method to draw graphics in the frame window
//
import java.awt.*;
import java.awt.image.BufferedImage;

public class StageFloor extends EnvironmentObject {
    private BufferedImage stageImage;    //image & image path
    private int stageSpeed;    //rolling speed

    public StageFloor(){}

//////////////////////////////////////////////////////////
//	Constructor to initialize background source         //
//	Input	: BufferedImage, stageSpeed, x, y			//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public StageFloor(BufferedImage stageImage, int stageSpeed, int x, int y) {
        this.stageImage = stageImage;
        this.stageSpeed = stageSpeed;
        super.setX(x);
        super.setY(y);
    }

//////////////////////////////////////////////////////////
//	void method to draw StageFloor image             //
//	Input	: Graphics      				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void paint(Graphics g){
        super.setX(super.getX()-stageSpeed);
        g.drawImage(stageImage,super.getX(),super.getY(),null );
    }
}
