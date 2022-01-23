package main;

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
    private List<BackGroundStageFloor> stageFloorList;
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
        BackGroundStageFloor stageFloor = new BackGroundStageFloor(floorImages[0],STAGE_SPEED,Constant.FRAM_WIDTH,Constant.GROUND_HEIGHT);
        stageFloorList.add(stageFloor);
        stageFloorList.get(0).paint(g);
    }

//    public void paintMenu(Graphics g){
//        //get bot boundary height and width
//        int heightBotBoundary = floorImages[0].getHeight();
//        int widthBotBoundary = floorImages[0].getWidth();
//        int imageLoop = Constant.FRAM_WIDTH/widthBotBoundary+1;
//        for(int i=0; i<imageLoop;i++){
//            g.drawImage(floorImages[0], widthBotBoundary*i,Constant.GROUND_HEIGHT,null);
//        }
//    }
}
