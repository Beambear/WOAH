package util;
import main.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
                    // 每隔3秒执行一次
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
        String filePath=("User_Saved_Data.txt");			//set file path
        File userFile = new File(filePath);								//set file
        try {
            userFile.createNewFile();									//create new file
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            FileOutputStream fop = new FileOutputStream(userFile);		//initialize fop
            OutputStreamWriter writer = new OutputStreamWriter(fop);	//initializeriter
            System.out.println("saving current fuel: "+player.getFuel());
            writer.append(player.getFuel()+" ");	//save fuel status
            writer.close();
            fop.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] userData;
    public static Player loadGame(){
        Player playerLoad = new Player();
        String filePath = ("user_saved_Data.txt");
        Path myPath = Paths.get(filePath);
        try {
            String dataRead = Files.readString(myPath);	//read data from file path
            userData = dataRead.split(" ");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        playerLoad.setFuel(Integer.parseInt(userData[0]));
        return playerLoad;
        }
    }
