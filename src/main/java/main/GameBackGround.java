package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: GameBackGround
// 	Description:
//		Draw the background pictures out,
//      Set attributes and rules of background.
//      Contains 5 attributes
//      Contains methods to set pictures image, start location, rolling speed.
//      Contains methods to set the refresh and remove rules.
//
import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GameBackGround {
    //Stage number
    private static final int STAGE_COUNT = 1;
    private static final int STAGE_FLOOR_COUNT = 1;
    //container for floor
    private List<StageFloor> stageFloorList;
    //stage rolling speed
    private static final int STAGE_SPEED = 4;
    //Stage Floor images
    private BufferedImage[] floorImages;

//////////////////////////////////////////////////////////
//	Constructor to initialize background source         //
//	Input	: None                   		        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public GameBackGround(){
        stageFloorList = new ArrayList<>();
        floorImages = new BufferedImage[STAGE_FLOOR_COUNT];
        //add floor images into container.
        for(int i=0; i<STAGE_FLOOR_COUNT;i++){
            floorImages[i] = GameUtil.loadBufferedImage(Constant.BG_STAGE_FLOOR_01);
        }
    }

//////////////////////////////////////////////////////////
//	void method to draw background image                //
//	Input	: Graphics      				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void paint(Graphics g){
        //fill in background color
        g.setColor(Constant.BG_COLOR);
        g.fillRect(0,0,Constant.FRAM_WIDTH,Constant.FRAM_HEIGHT);
        g.setColor(Color.black);

        //draw stage floor
        logic();
        for(int i=0; i<stageFloorList.size();i++){
            stageFloorList.get(i).paint(g);
        }
    }

//////////////////////////////////////////////////////////
//	void method to set the logic to create new floor    //
//	Input	: None            				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    private void logic(){
        if(stageFloorList.size() != 0){ //initial setting
            for(int i=0; i< stageFloorList.size();i++){
                if(stageFloorList.get(i).getX() == 400){
                    StageFloor floorNew = new StageFloor(floorImages[STAGE_COUNT-1],STAGE_SPEED,Constant.FRAM_WIDTH, Constant.GROUND_HEIGHT);
                    stageFloorList.add(floorNew);
                }
            }
        }else{  //keep refresh new images
            for(int i=0; i<3;i++){
                StageFloor stageFloor = new StageFloor(floorImages[STAGE_COUNT-1],STAGE_SPEED,500*i,Constant.GROUND_HEIGHT);
                stageFloorList.add(stageFloor);
            }
        }
        if(stageFloorList.get(0).isOutWindow()==true){//remove out of screen images
            stageFloorList.remove(0);
        }
    }

}
