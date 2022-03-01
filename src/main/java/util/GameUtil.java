package util;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: GameUtil
// 	Description:
//		This class contains some function methods for this game.
//      1. load buffered image
//      2. game save & load functions
//
import main.Player;
import main.Weapon;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GameUtil {

//////////////////////////////////////////////////////////
//	method used to load and return buffered image   	//
//	Input	: String image Path     					//
//	Output	: BufferedImage 							//
//////////////////////////////////////////////////////////
    public static BufferedImage loadBufferedImage(String imagePath){
        try{
            return ImageIO.read(new FileInputStream(imagePath));
        } catch (IOException e){
            e.printStackTrace();
        }
        return  null;
    }


//////////////////////////////////////////////////////////
//	game auto save function, implement save() every 10s //
//	Input	: Player                 					//
//	Output	: None										//
//////////////////////////////////////////////////////////
    //Game auto save
    public static void autoSave(Player player){
        new Thread(() -> {
            while (true) {
                try {
                    //run every 10 seconds
                    Thread.sleep(10000);
                    GameUtil.save(player);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


//////////////////////////////////////////////////////////
//	output important game information as dat            //
//	Input	: Player                 					//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public static void save(Player player) {
        System.out.println("Saving...");
        File userFile = new File(player.getPlayerName()+Constant.SAVED_FILE_PATH);			//set file
        try {
            userFile.createNewFile();									//create new file
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream(userFile));		//initialize fop
            outfile.writeObject(new SavedData(player));
            outfile.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

//////////////////////////////////////////////////////////
//	input important game information from dat           //
//	Input	:                       					//
//	Output	: SavedData									//
//////////////////////////////////////////////////////////
    public static SavedData loadGame(String username){
        SavedData dataLoad = new SavedData();
        try {
            ObjectInputStream infile = new ObjectInputStream(new FileInputStream(username+Constant.SAVED_FILE_PATH));
            dataLoad = (SavedData) infile.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataLoad;
        }


    //------------------------------------------------------------------------
    //	Author: Jipeng Liu
    //
    //
    // 	Class: SavedData
    // 	Description:
    //		Object class, contains attribute to store important game information
    //
        public static class SavedData implements Serializable{
            public  SavedData(){}
            String playerName;
            int fuel;
            int scores;
            int playerLocationX;
            int playerLocationY;
            ArrayList<String> mainWeaponInventoryCodes;
            ArrayList<String> itemInventoryCodes;

//////////////////////////////////////////////////////////
//	Constructor, read the attribute from Player         //
//        to set this.attributes                        //
//	Input	: Player                   					//
//	Output	: None  									//
//////////////////////////////////////////////////////////
            public  SavedData(Player player){
                this.playerName=player.getPlayerName();
                this.scores = player.getScore();
                this.fuel = player.getFuel();
                this.playerLocationX = player.getPlayerLocationX();
                this.playerLocationY = player.getPlayerLocationY();
                this.mainWeaponInventoryCodes = new ArrayList<String>();
                this.itemInventoryCodes = new ArrayList<String>();
                for(int i=0; i< player.getMainWeaponInventory().getInventory().size();i ++){
                    this.mainWeaponInventoryCodes.add(player.getMainWeaponInventory().getInventory(i).getWeaponCode());
                }
                for(int i=0; i< player.getItemInventory().getInventory().size();i ++){
                    this.itemInventoryCodes.add(player.getItemInventory().getInventory(i).getItemCode());
                }
            }
            public String getPlayerName() {
                return playerName;
            }

            public int getFuel() {
                return fuel;
            }

            public int getScores() {
                return scores;
            }

            public int getPlayerLocationX() {
                return playerLocationX;
            }

            public int getPlayerLocationY() {
                return playerLocationY;
            }

            public ArrayList<String> getMainWeaponInventoryCodes() {
                return mainWeaponInventoryCodes;
            }

            public ArrayList<String> getItemInventoryCodes() {
                return itemInventoryCodes;
            }
        }
    }
