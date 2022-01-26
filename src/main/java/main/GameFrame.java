package main;

import util.GameUtil;

import static util.Constant.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;


public class GameFrame extends Frame {

    private GameBackGround gameBackGround;
    private Player player;
    private GameFrontGround gameFrontGround;
    public GameFrame(){
        //window visibility
        setVisible(true);
        //window size
        setSize(FRAM_WIDTH,FRAM_HEIGHT);
        //window title
        setTitle(FRAM_TITLE);
        //window initial location
        setLocation(FRAM_X, FRAM_Y);
        //window size unchangeable
        setResizable(false);
        //Close window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);// shut down app
            }
        });

        initGame();

        new run().start();

        //input key listener
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                typeKey(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                pressKey(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                releaseKey(e);
            }
        });
    }

    public void initGame(){
        gameBackGround = new GameBackGround();
        player = new Player();
        gameFrontGround = new GameFrontGround();
    }

    class run extends Thread{
        @Override
        public void run() {
            player.fuelCosting();
            GameUtil.autoSave(player);
            while(true){
                repaint();
                try{
                    Thread.sleep(33);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Graphics g) {
        BufferedImage currImage = new BufferedImage(FRAM_WIDTH,FRAM_HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics graphics = currImage.getGraphics();
        gameBackGround.paint(graphics);
        player.paint(graphics);
        gameFrontGround.paint(graphics);
        g.drawImage(currImage,0,0,null);
    }

    //press key reactions
    public void pressKey(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP :
                player.flyControl(1);
                break;
            case KeyEvent.VK_DOWN:
                player.flyControl(2);
                break;
            case KeyEvent.VK_LEFT:
                player.flyControl(3);
                break;
            case KeyEvent.VK_RIGHT:
                player.flyControl(4);
                break;
        }
    }

    //release key reactions
    public void releaseKey(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP :
                player.flyControl(5);
                break;
            case KeyEvent.VK_DOWN:
                player.flyControl(6);
                break;
            case KeyEvent.VK_LEFT:
                player.flyControl(7);
                break;
            case KeyEvent.VK_RIGHT:
                player.flyControl(8);
                break;
        }
    }

}
