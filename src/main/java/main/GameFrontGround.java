package main;

import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameFrontGround {
    //Stage number
    private static final int STAGE_COUNT = 1;
    private static final int STAGE_CEILING_COUNT =2;
    //container for ceiling
    private List<FrontGroundStageCeiling> stageCeilingList;
    //stage rolling speed
    private static final int STAGE_SPEED = 4;
    //Stage ceiling images
    private BufferedImage[] ceilingImages;

    //constructor to initialize background source
    public GameFrontGround(){
        stageCeilingList = new ArrayList<>();
        ceilingImages = new BufferedImage[STAGE_CEILING_COUNT];
        //add ceiling images into container.
        for(int i=0; i<STAGE_CEILING_COUNT;i++){
            ceilingImages[i]= GameUtil.loadBufferedImage("artResources/environment/background_ceiling_stage_01_"+(i+1)+".png");
        }
    }

    //
    public void paint(Graphics g){
        //draw stage ceiling
        logic(g);
        for(int i=0; i<stageCeilingList.size();i++){
            stageCeilingList.get(i).paint(g);
        }
    }

    //the logic to create new ceiling
    private void logic(Graphics g){
        Random random = new Random();
        if(stageCeilingList.size() != 0){
            for(int i=0; i< stageCeilingList.size();i++){
                if(stageCeilingList.get(i).getX() == 800){
                    FrontGroundStageCeiling ceilingNew = new FrontGroundStageCeiling(ceilingImages[random.nextInt(STAGE_CEILING_COUNT)],STAGE_SPEED,Constant.FRAM_WIDTH, Constant.CEILING_HEIGHT);
                    stageCeilingList.add(ceilingNew);
                }
            }
        }else{
            FrontGroundStageCeiling stageCeiling = new FrontGroundStageCeiling(ceilingImages[random.nextInt(STAGE_CEILING_COUNT)],STAGE_SPEED,Constant.FRAM_WIDTH,Constant.CEILING_HEIGHT);
            stageCeilingList.add(stageCeiling);
            stageCeilingList.get(0).paint(g);
        }

        FrontGroundStageCeiling oldestCeiling = new FrontGroundStageCeiling();
        oldestCeiling = stageCeilingList.get(0);
        if(oldestCeiling.isOutWindow()==true){
            stageCeilingList.remove(0);
        }
    }
}
