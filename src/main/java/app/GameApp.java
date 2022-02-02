package app;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: GameApp
// 	Description:
//		This is the main class of the whole project.
//      Contains the main method and a method for console start menu
//
import main.GameFrame;

import java.util.Scanner;

//////////////////////////////////////////////////////////
//	Main method                                			//
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
public class GameApp {
    public static void main(String[] args){
        GameApp drive = new GameApp();
        drive.menu();
    }

//////////////////////////////////////////////////////////
//	A void method, this will initial a menu in console  //
//  before starting the game. Player can choose         //
//  1.start new game                                    //
//  2.load saved game                                   //
//  3.Exit                                              //
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void menu() {
        System.out.println("Welcome to <World of Aircraft Half-life!>");

            System.out.println("What you want to do:");
            System.out.println("(1)start new game \n(2)load	\n(3)Exit");
            Scanner keyboard = new Scanner(System.in);
            String option = keyboard.nextLine();
            switch(option)
            {
                case "1":
                    new GameFrame("new");
                    break;
                case "2":
                    new GameFrame("load");
                    break;
                case "3":
                    System.out.println("see you next time.");
                    System.exit(0);
                default:
                    System.out.println("invalid input, please try again.");
                    break;
            }
    }
}


