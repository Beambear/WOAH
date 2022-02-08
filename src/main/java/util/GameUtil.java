package util;
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

    //load image
    public static BufferedImage loadBufferedImage(String imagePath){
        try{
            return ImageIO.read(new FileInputStream(imagePath));
        } catch (IOException e){
            e.printStackTrace();
        }
        return  null;
    }

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
    //save
    public static void save(Player player) {
        System.out.println("Saving...");
//        String filePath=(Constant.SAVED_FILE_PATH);			//set file path
        File userFile = new File(Constant.SAVED_FILE_PATH);								//set file
        try {
            userFile.createNewFile();									//create new file
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream(userFile));		//initialize fop
            // writer.append(player.getFuel()+" ");	//save fuel status
            outfile.writeObject(new SavedData(player));
//            writer.close();
            outfile.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Player loadGame(){
        Player playerLoad = new Player();
//        String filePath = ("user_saved_Data.txt");
        Path myPath = Paths.get(Constant.SAVED_FILE_PATH);
        try {
//            String dataRead = Files.readString(myPath);	//read data from file path
//            userData = dataRead.split(" ");
            ObjectInputStream infile = new ObjectInputStream(new FileInputStream(Constant.SAVED_FILE_PATH));
            playerLoad = (Player) infile.readObject();//////////////////////////////////////////////////
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        playerLoad.setFuel(Integer.parseInt(userData[0]));
        return playerLoad;
        }

        public static class SavedData{
        public  SavedData(){}
            String playerName;
            int scores;
            int playerLocationX;
            int playerLocationY;
            ArrayList<String> mainWeaponInventoryCodes;
            ArrayList<String> itemInventoryCodes;
            public  SavedData(Player player){
                this.playerName=player.getPlayerName();
                this.scores = player.getScore();
                this.playerLocationX = player.getPlayerLocationX();
                this.playerLocationY = player.getPlayerLocationY();
                for(int i=0; i< player.getMainWeaponInventory().getInventory().size();i ++){
                    this.mainWeaponInventoryCodes.add(player.getMainWeaponInventory().getInventory(i).getWeaponCode());
                }
                for(int i=0; i< player.getItemInventory().getInventory().size();i ++){
                    this.itemInventoryCodes.add(player.getItemInventory().getInventory(i).getItemCode());
                }
            }
        }
    }
