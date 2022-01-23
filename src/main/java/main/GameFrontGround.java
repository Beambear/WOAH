package main;

import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GameFrontGround {
    //Stage number
    private static final int STAGE_COUNT = 1;
    private static final int STAGE_CEILING_COUNT =3;
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
        FrontGroundStageCeiling stageCeiling = new FrontGroundStageCeiling(ceilingImages[0],STAGE_SPEED,Constant.FRAM_WIDTH,0);
        stageCeilingList.add(stageCeiling);
        stageCeilingList.get(0).paint(g);
    }
}
