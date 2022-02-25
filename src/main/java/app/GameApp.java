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
import util.SqliteTables;

import java.sql.SQLException;
import java.util.Scanner;

//////////////////////////////////////////////////////////
//	Main method                                			//
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
public class GameApp {
    public static void main(String[] args){
        Test test = new Test();
//        test.streamTest();
//        test.dbTest();
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
        while(true){

            System.out.println("What you want to do:");
            System.out.println("(1)start new game \n(2)load	\n(3)Exit \n(4)Scoreboard Related");
            Scanner keyboard = new Scanner(System.in);
            String option = keyboard.nextLine();
            switch(option)
            {
                case "1":
                    System.out.println("-> new game");
                    new GameFrame("new");
                    break;
                case "2":
                    System.out.println("-> load game");
                    new GameFrame("load");
                    break;
                case "3":
                    System.out.println("see you next time.");
                    System.exit(0);
                case "4":
                    menuDB();
                    break;
                default:
                    System.out.println("invalid input, please try again.");
                    break;
            }
        }
    }

//////////////////////////////////////////////////////////
//	A void method, this will initial a menu in console  //
//  for database related things                         //
//  (1)add new scores                                   //
//  (2)sign up test                                     //
//  (3)sign in test                                     //
//  (4)check user infomation                            //
//  (5)exit//  2.load saved game                        //
//  Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void menuDB(){
        System.out.println("Loading Database...");
        while(true){
            SqliteTables database = new SqliteTables();
            try {
                database.createTables();
            } catch (SQLException e) {
            }
            System.out.println("(1)add new scores \n(2)sign up test	\n(3)sign in test \n(4)check user infomation \n(5)exit");
            Scanner keyboard = new Scanner(System.in);
            String option = keyboard.nextLine();
            switch(option)
            {
                case "1":
                    System.out.println("username:__");
                    String username = keyboard.nextLine();
                    System.out.println("score:__");
                    int score = keyboard.nextInt();
                    database.insertScore(username,score);
                    break;
                case "2":
                    System.out.println("username:__");
                    String accountSU = keyboard.nextLine();
                    System.out.println("password:__");
                    String passwordSU = keyboard.nextLine();
                    try {
                        database.insertAccount(accountSU,passwordSU);
                    } catch (SQLException e) {
                        System.out.println("Account already exists");
                    }
                    break;
                case "3":
                    System.out.println("username:__");
                    String accountSI = keyboard.nextLine();
                    System.out.println("password:__");
                    String passwordSI = keyboard.nextLine();
                    try {
                        database.login(accountSI,passwordSI);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    System.out.println("target userID:__");
                    int userID = keyboard.nextInt();
                    database.checkUserInfo(userID);
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("invalid input, please try again.");
                    break;
            }
        }
    }
}


