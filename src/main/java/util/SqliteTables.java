package util;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: SqliteTables
// 	Description:
//		Used to manage the database.
//      The database contains two tables.
//          1.accounts: userID/username/password
//          2.scoreBoard:userID/highScore
//
import java.sql.*;

public class SqliteTables {

    //////////////////////////////////////////////////////////
//	A void method, this will initial a menu in console  //
//  before starting the game. Player can choose         //
//  1.start new game                                    //
//  2.load saved game                                   //
//  3.Exit                                              //
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public Connection connectDB(){
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:WOAH.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Database connected");
        return c;
    }

    public void createTables() throws SQLException {
        Connection c = connectDB();
        Statement accountsStatement = c.createStatement();
        String accountTable =" CREATE TABLE ACCOUNTS"
                        + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "ACCOUNT TEXT NOT NULL UNIQUE,"
                        + "PASSWORD TEXT NOT NULL)";
        accountsStatement.executeUpdate(accountTable);
        accountsStatement.close();
        System.out.println("Accounts Table created");

        Statement scoreBoardStatement = c.createStatement();
        String scoreTable = " CREATE TABLE SCOREBOARD"
                        + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "ACCOUNT TEXT NOT NULL UNIQUE,"
                        + "SCORE INTEGER NOT NULL)";
        scoreBoardStatement.executeUpdate(scoreTable);
        scoreBoardStatement.close();
        System.out.println("Scoreboard created");
        c.close();

    }

    public void insertAccount(String username, String password) throws SQLException{
        Connection c = connectDB();
        String insert = "INSERT INTO ACCOUNTS (ACCOUNT,PASSWORD)"
                        + "VALUES (?, ?);";
        PreparedStatement accountsStatement = c.prepareStatement(insert);
        accountsStatement.setString(1,username);
        accountsStatement.setString(2,password);
        accountsStatement.executeUpdate();
        c.close();
        System.out.println("new account created");
    }

    public void insertScore(String username, int score) throws SQLException{
        Connection c = connectDB();
        String insert = "INSERT INTO SCOREBOARD (ACCOUNT,SCORE)"
                + "VALUES (?, ?);";
        PreparedStatement accountsStatement = c.prepareStatement(insert);
        accountsStatement.setString(1,username);
        accountsStatement.setInt(2,score);
        accountsStatement.executeUpdate();
        c.close();
        System.out.println("Scoreboard updated");
    }
}
