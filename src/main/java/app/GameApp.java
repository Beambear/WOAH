package app;

import main.GameFrame;

import java.util.Scanner;

public class GameApp {
    public static void main(String[] args){
        GameApp drive = new GameApp();
        drive.menu();
    }

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

    public String ezJunitTest(){

        String printA= "Hello World!";
        System.out.println(printA);
        return printA;
    }
}


