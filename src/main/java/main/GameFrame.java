package main;

import static util.Constant.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameFrame extends Frame {
    public GameFrame(){
        //window visiable
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
    }
}
