package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: GameFrame
// 	Description:
//		This class is core class of this project.
//      GameFrame is a child class of Frame
//      1.Initialize the basic frame window of game.
//      2.Draw every object into the game frame window.
//      3.Initialize a new game or load a saved game.
//      4.Have a thread to keep update game
//      5.have a listener for keyboard inputs
//      Contains 3 attributes
//
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


//////////////////////////////////////////////////////////
//	Constructor to initialize the game frame            //
//	Input	: isLoad									//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public GameFrame(String isLoad){
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

        switch(isLoad){
            case "new": initGame();
            break;
            case "load": loadGame();
        }

        new run().start();

        //input key listener
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {typeKey(e);}
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

//////////////////////////////////////////////////////////
//	void method to start a new game                     //
//	Input	: None  									//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void initGame(){
        gameBackGround = new GameBackGround();
        player = new Player();
        gameFrontGround = new GameFrontGround();
    }

//////////////////////////////////////////////////////////
//	void method to load the saved game                  //
//	Input	: None  									//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void loadGame(){
        gameBackGround = new GameBackGround();
        player = GameUtil.loadGame();
        gameFrontGround = new GameFrontGround();
    }

//////////////////////////////////////////////////////////
//	create a thread to keep updating the game           //
//	Input	: None  									//
//	Output	: None										//
//////////////////////////////////////////////////////////
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

//////////////////////////////////////////////////////////
//	void method to update the game status               //
//	Input	: None  									//
//	Output	: None										//
//////////////////////////////////////////////////////////
    @Override
    public void update(Graphics g) {
        BufferedImage currImage = new BufferedImage(FRAM_WIDTH,FRAM_HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics graphics = currImage.getGraphics();
        gameBackGround.paint(graphics);
        player.paint(graphics);
        gameFrontGround.paint(graphics);
        g.drawImage(currImage,0,0,null);
    }

//////////////////////////////////////////////////////////
//	void method to set reactions for the typed Key      //
//	Input	: KeyEvent 									//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void typeKey(KeyEvent e){    //doesn't work.
        switch (e.getKeyCode()){
            case KeyEvent.VK_S:
                player.actionControl(10);  //switch main weapon
                break;
        }
    }


//////////////////////////////////////////////////////////
//	void method to set reactions for the pressed Key    //
//	Input	: KeyEvent 									//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void pressKey(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP :
                player.actionControl(1);//moving up
                break;
            case KeyEvent.VK_DOWN:
                player.actionControl(2);//moving down
                break;
            case KeyEvent.VK_LEFT:
                player.actionControl(3);//moving left
                break;
            case KeyEvent.VK_RIGHT:
                player.actionControl(4);//moving right
                break;
            case KeyEvent.VK_D:
                player.actionControl(9);//fire
                break;
        }
    }

//////////////////////////////////////////////////////////
//	void method to set reactions for the released Key   //
//	Input	: KeyEvent 									//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void releaseKey(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP :
                player.actionControl(5);//stop moving up
                break;
            case KeyEvent.VK_DOWN:
                player.actionControl(6);//stop moving down
                break;
            case KeyEvent.VK_LEFT:
                player.actionControl(7);//stop moving left
                break;
            case KeyEvent.VK_RIGHT:
                player.actionControl(8);//stop moving right
                break;
            case KeyEvent.VK_S:
                player.actionControl(10);//switch to next main weapon
                break;
            case KeyEvent.VK_W:
                player.actionControl(11);//switch to next item
                break;
            case KeyEvent.VK_E:
                player.actionControl(12,player);//use current item
                break;
        }
    }

}
