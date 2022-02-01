package main;

import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    //constructor to initialize background source
    public GameBackGround(){
        stageFloorList = new ArrayList<>();
        floorImages = new BufferedImage[STAGE_FLOOR_COUNT];
        //add floor images into container.
        for(int i=0; i<STAGE_FLOOR_COUNT;i++){
            floorImages[i] = GameUtil.loadBufferedImage(Constant.BG_STAGE_FLOOR_01);
        }
    }

    //
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
//        BackGroundStageFloor stageFloor = new BackGroundStageFloor(floorImages[0],STAGE_SPEED,Constant.FRAM_WIDTH,Constant.GROUND_HEIGHT);
//        stageFloorList.add(stageFloor);
//        stageFloorList.get(0).paint(g);
    }

    //the logic to create new floor
    private void logic(){
        Random random = new Random();
        if(stageFloorList.size() != 0){
            for(int i=0; i< stageFloorList.size();i++){
                if(stageFloorList.get(i).getX() == 400){
                    StageFloor floorNew = new StageFloor(floorImages[STAGE_COUNT-1],STAGE_SPEED,Constant.FRAM_WIDTH, Constant.GROUND_HEIGHT);
                    stageFloorList.add(floorNew);
                }
            }
        }else{
            for(int i=0; i<3;i++){
                StageFloor stageFloor = new StageFloor(floorImages[STAGE_COUNT-1],STAGE_SPEED,500*i,Constant.GROUND_HEIGHT);
                stageFloorList.add(stageFloor);
            }
        }
        StageFloor oldestFloor = new StageFloor();
        oldestFloor = stageFloorList.get(0);
        if(oldestFloor.isOutWindow()==true){
            stageFloorList.remove(0);
        }
    }

}
