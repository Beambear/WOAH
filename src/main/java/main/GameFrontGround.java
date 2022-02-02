package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: GameFrontGround
// 	Description:
//		Draw the frontGround pictures out,
//      Set attributes and rules of frontGround.
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


//////////////////////////////////////////////////////////
//	Constructor to initialize frontground source        //
//	Input	: None                 		        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public GameFrontGround(){
        stageCeilingList = new ArrayList<>();
        ceilingImages = new BufferedImage[STAGE_CEILING_COUNT];
        //add ceiling images into container.
        for(int i=0; i<STAGE_CEILING_COUNT;i++){
            ceilingImages[i]= GameUtil.loadBufferedImage("artResources/environment/background_ceiling_stage_01_"+(i+1)+".png");
        }
    }

//////////////////////////////////////////////////////////
//	void method to draw background image                //
//	Input	: Graphics      				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void paint(Graphics g){
        //draw stage ceiling
        logic();
        for(int i=0; i<stageCeilingList.size();i++){
            stageCeilingList.get(i).paint(g);
        }
    }


//////////////////////////////////////////////////////////
//	void method to set the logic to create new ceiling  //
//	Input	: None          				        	//
//	Output	: None										//
//////////////////////////////////////////////////////////
    private void logic(){
        Random random = new Random();
        if(stageCeilingList.size() != 0){//initial setting
            for(int i=0; i< stageCeilingList.size();i++){
                if(stageCeilingList.get(i).getX() == 400){
                    StageCeiling ceilingNew = new StageCeiling(ceilingImages[random.nextInt(STAGE_CEILING_COUNT)],STAGE_SPEED,Constant.FRAM_WIDTH, Constant.CEILING_HEIGHT);
                    stageCeilingList.add(ceilingNew);
                }
            }
        }else{  //keep refresh new ceiling
            for(int i=0; i<3;i++){
                StageCeiling stageCeiling = new StageCeiling(ceilingImages[random.nextInt(STAGE_CEILING_COUNT)],STAGE_SPEED,500*i,Constant.CEILING_HEIGHT);
                stageCeilingList.add(stageCeiling);
            }
        }
        if(stageCeilingList.get(0).isOutWindow()==true){//remove out of window image
            stageCeilingList.remove(0);
        }
    }
}
