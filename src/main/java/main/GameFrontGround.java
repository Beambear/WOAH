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
    private List<StageCeiling> stageCeilingList;
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
        logic();
        for(int i=0; i<stageCeilingList.size();i++){
            stageCeilingList.get(i).paint(g);
        }
    }

    //the logic to create new ceiling
    private void logic(){
        Random random = new Random();
        if(stageCeilingList.size() != 0){
            for(int i=0; i< stageCeilingList.size();i++){
                if(stageCeilingList.get(i).getX() == 400){
                    StageCeiling ceilingNew = new StageCeiling(ceilingImages[random.nextInt(STAGE_CEILING_COUNT)],STAGE_SPEED,Constant.FRAM_WIDTH, Constant.CEILING_HEIGHT);
                    stageCeilingList.add(ceilingNew);
                }
            }
        }else{
            for(int i=0; i<3;i++){
                StageCeiling stageCeiling = new StageCeiling(ceilingImages[random.nextInt(STAGE_CEILING_COUNT)],STAGE_SPEED,500*i,Constant.CEILING_HEIGHT);
                stageCeilingList.add(stageCeiling);
            }
        }
        StageCeiling oldestCeiling = new StageCeiling();
        oldestCeiling = stageCeilingList.get(0);
        if(oldestCeiling.isOutWindow()==true){
            stageCeilingList.remove(0);
        }
    }
}
