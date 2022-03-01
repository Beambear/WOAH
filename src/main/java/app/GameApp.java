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


public class GameApp {
    //////////////////////////////////////////////////////////
    //	Main method                                			//
    //	Input	: None										//
    //	Output	: None										//
    //////////////////////////////////////////////////////////
    public static void main(String[] args){
        SqliteTables database = new SqliteTables();
        try {
            database.createTables();
        } catch (SQLException e) {
        }
        Test test = new Test();
//        test.streamTest();
//        test.dbTest();
        GameApp drive = new GameApp();
        drive.Homepage();
    }

//////////////////////////////////////////////////////////
//	A login menu for sign in/ sign up                   //
//  1.start new game                                    //
//  2.load saved game                                   //
//  3.Exit                                              //
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////

    public void Homepage() {
        System.out.println("Welcome to <World of Aircraft Half-life!>");

        while(true){

            System.out.println("What you want to do:");
            System.out.println("(1)Log in \n(2)Sign up	\n(3)Exit \n(4)Scoreboard Related");
            Scanner keyboard = new Scanner(System.in);
            String option = keyboard.nextLine();
            SqliteTables database = new SqliteTables();
            switch(option)
            {
                case "1":
                    System.out.print("username: ");
                    String accountLI = keyboard.nextLine();
                    System.out.print("password: ");
                    String passwordLI = keyboard.nextLine();
                    try {
                        database.login(accountLI,passwordLI);
                    } catch (SQLException e) {
//                        e.printStackTrace();
                        break;
                    }
                    menu(accountLI);
                    break;
                case "2":
                    System.out.print("username: ");
                    String accountSU = keyboard.nextLine();
                    System.out.print("password: ");
                    String passwordSU = keyboard.nextLine();
                    try {
                        database.insertAccount(accountSU,passwordSU);
                        database.login(accountSU,passwordSU);
                    } catch (SQLException e) {
                        System.out.println("Account already exists");
                    }
                    menu(accountSU);
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
    //  before starting the game. Player can choose         //
    //  1.start new game                                    //
    //  2.load saved game                                   //
    //  3.Exit                                              //
    //	Input	: username									//
    //	Output	: None										//
    //////////////////////////////////////////////////////////
    public void menu(String username) {
        System.out.println("Welcome to <World of Aircraft Half-life!>");

        boolean flag = true;
        while(flag == true){

            System.out.println("What you want to do:");
            System.out.println("(1)new game \n(2)load	\n(3)scoreboard\n (4)setting\n (5)log out\n");
            Scanner keyboard = new Scanner(System.in);
            String option = keyboard.nextLine();
            switch(option)
            {
                case "1":   //new game
                    System.out.println("-> new game");
                    new GameFrame(username, "new");
                    break;
                case "2":   //load game
                    System.out.println("-> load game");
                    new GameFrame(username, "load");
                    break;
                case "3":   //scoreboard
//                    menuDB();
                    break;
                case "4":   //setting
                    settingMenu(username);
                    break;
                case "5": //log out
                    flag = false;
                    System.out.println("see you next time.");
                    break;
                default:
                    System.out.println("invalid input, please try again.");
                    break;
            }
        }
    }

    //////////////////////////////////////////////////////////
    //	A void method, this will initial a menu in console  //
    //  to manage game setting. Player can choose           //
    //  1.resolution                                        //
    //  2.change fire key                                   //
    //  3.Back                                              //
    //	Input	: username									//
    //	Output	: None										//
    ////////////////////////////////////////////////////////////////////

    public void settingMenu(String username) {
        System.out.println("Welcome to <World of Aircraft Half-life!>");

        boolean flag = true;
        while (flag == true) {

            System.out.println("What you want to do:");
            System.out.println("(1)resolution \n(2)change fire key	\n(3)back");
            Scanner keyboard = new Scanner(System.in);
            String option = keyboard.nextLine();
            switch (option) {
                case "1":   //resolution
                    SqliteTables database = new SqliteTables();
//                    System.out.println("Current resolution: " + " ");
                    System.out.print("\nchose desired resolution\n(1)1280 * 720 (default)\n(2)1280 * 1024\n(3)1600x1200");
                    int[] resolution = choseResolution();
                    database.updateResolution(username,resolution[0],resolution[1]);
                    break;
                case "2":   //change fire key
                    newFireKey(username);
                    break;
                case "3":   //back
                    flag = false;
                    break;
                default:
                    System.out.println("invalid input, please try again.");
                    break;
            }
        }
    }

    //////////////////////////////////////////////////////////
    //	An int[] method to manage resolution setting        //
    //	Input	: None		    							//
    //	Output	: resolution[]								//
    ////////////////////////////////////////////////////////////////////
    public int[] choseResolution(){
        int[] resolution = new int[2];
        Scanner keyboard = new Scanner(System.in);
        String option = keyboard.nextLine();
        switch (option){
            case "1":
                resolution= new int[]{1280, 720};
                break;
            case "2":
                resolution= new int[]{1280, 1024};
                break;
            case "3":
                resolution= new int[]{1600,1200};
                break;
        }
        return resolution;
    }

    //////////////////////////////////////////////////////////
    //	A void method to manage hot key setting             //
    //	Input	: username		    						//
    //	Output	: None								        //
    ////////////////////////////////////////////////////////////////////
    public void newFireKey(String username){
        System.out.print("new fire key:");
        Scanner keyboard = new Scanner(System.in);
        String fireKey = keyboard.nextLine();
        SqliteTables database = new SqliteTables();
        database.updateFireKey(username,fireKey);
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



