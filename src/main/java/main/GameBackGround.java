package main;

import util.Constant;
import util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameBackGround {
    //
    private BufferedImage bgBotBoundary;

    //constructor to initialize source
    public GameBackGround(){
        bgBotBoundary = GameUtil.loadBufferedImage(Constant.BG_BOUNDARY_BOT);
    }

    //
    public void paint(Graphics g){
        //get image height and width
        int height = bgBotBoundary.getHeight();
        int width = bgBotBoundary.getWidth();
        //image loop times
        int imageLoop = Constant.FRAM_WIDTH/width+1;
        for(int i=0; i<imageLoop;i++){
            g.drawImage(bgBotBoundary, width*i,Constant.GROUND_HEIGHT,null);
        }
    }
}
