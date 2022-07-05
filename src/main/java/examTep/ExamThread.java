package examTep;

import main.GameFrame;
import main.Player;
import util.GameUtil;

public class ExamThread {
    public void() throws InterruptedException{

        new GameFrame.Graphic().start();

        Music musicRun = new Music();
        Thread tMusic = new Thread(musicRun);
        tMusic.start();


    }
}
class Graphic extends Thread{
    @Override
    public void run(Player player) {
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

class Music implements Runnable{
    public void run(){
        String musicPath;
        while(true){
            playerMusic(musicPath);
        }
    }
}
