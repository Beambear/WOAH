package main;

import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameBackGround {
    //
    private BufferedImage bgBotBoundary;
    private BufferedImage backgroundStage1;

    //constructor to initialize background source
    public GameBackGround(){
        bgBotBoundary = GameUtil.loadBufferedImage(Constant.BG_BOUNDARY_BOT);
//        backgroundStage1 = GameUtil.loadBufferedImage(Constant.BG_STAGE1);
    }

    //
    public void paint(Graphics g){
        //fill in background color
        g.setColor(Constant.BG_COLOR);
        g.fillRect(0,0,Constant.FRAM_WIDTH,Constant.FRAM_HEIGHT);
        g.setColor(Color.black);

//        //get background height and width
//        int heightBGStage1 = backgroundStage1.getHeight();
//        int widthBGStage1 = backgroundStage1.getWidth();
//        //draw stage 1 background
//        g.drawImage(backgroundStage1,0,0,null);


        //get bot boundary height and width
        int heightBotBoundary = bgBotBoundary.getHeight();
        int widthBotBoundary = bgBotBoundary.getWidth();
        //draw bot boundary
        int imageLoop = Constant.FRAM_WIDTH/widthBotBoundary+1;
        for(int i=0; i<imageLoop;i++){
            g.drawImage(bgBotBoundary, widthBotBoundary*i,Constant.GROUND_HEIGHT,null);
        }
    }
}
