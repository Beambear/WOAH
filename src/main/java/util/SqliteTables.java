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
//          3.setting: userID/account/ resolution_width/resolution_height/firekey
//
import java.sql.*;

public class SqliteTables {

//////////////////////////////////////////////////////////
//	A method to build the connection with Database      //
//	Input	: None										//
//	Output	: Connection								//
//////////////////////////////////////////////////////////
    private Connection connectDB(){
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

    //////////////////////////////////////////////////////////
    //	void method to create database tables               //
    //  1.Accounts table contains ID,ACCOUNT,PASSWORD       //
    //  2.Scoreboard table contains ID,ACCOUNT,SCORES       //
    //  3.Seeting table, contains ID, RESOLUTION, KEYS      //
    //	Input	: None										//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////////////////////
    public void createTables() throws SQLException {
        Connection c = connectDB();
        System.out.println("testtesttest");
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

        Statement settingStatement = c.createStatement();
        String settingTable = " CREATE TABLE SETTING"
                            + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + "ACCOUNT TEXT NOT NULL UNIQUE,"
                            + "RESOLUTION_WIDTH INT NOT NULL,"
                            + "RESOLUTION_HEIGHT INT NOT NULL,"
                            + "FIRE_KEY TEXT NOT NULL)";
        settingStatement.executeUpdate(settingTable);
        System.out.println("Setting created");
        settingStatement.close();

        c.close();
    }
    private void createAccountTable(){

    }

    //////////////////////////////////////////////////////////
    //	void method to insert new account info to database  //
    //  Input	: None										//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////////////////////
    public void insertAccount(String username, String password) throws SQLException{
        Connection c = connectDB();
        String insert = "INSERT INTO ACCOUNTS (ACCOUNT,PASSWORD)"
                        + "VALUES (?, ?);";
        PreparedStatement accountsStatement = c.prepareStatement(insert);
        accountsStatement.setString(1,username);
        accountsStatement.setString(2,password);
        accountsStatement.executeUpdate();
        c.close();
        insertScore(username,0);    //initial score table
        insertSetting(username,1280,720,"D");   //default
        System.out.println("new account created");
    }

    //////////////////////////////////////////////////////////
    //	void method to insert setting info to database      //
    //  Input	: None										//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////////////////////////////
    public void insertSetting(String username, int width, int height, String fireKey){
        Connection c = connectDB();
        String insert = "INSERT INTO SETTING (ACCOUNT,RESOLUTION_WIDTH,RESOLUTION_HEIGHT,FIRE_KEY)"
                + "VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement settingStatement = null;
            settingStatement = c.prepareStatement(insert);
            settingStatement.setString(1,username);
            settingStatement.setInt(2,width);
            settingStatement.setInt(3,height);
            settingStatement.setString(4,fireKey);
            settingStatement.executeUpdate();
            System.out.println("Setting data created");
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            updateSetting(username,width, height, fireKey);
        }
    }

    //////////////////////////////////////////////////////////
    //	void method to update new setting info to database  //
    //  Input	: username,width,height,hot keys     		//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////
    public void updateSetting(String username,int width, int height, String fireKey){
        Connection c = connectDB();
        String update = "UPDATE setting"
                + " set RESOLUTION_WIDTH = "+width
                + " set RESOLUTION_HEIGHT = "+height
                + " set fireKey = "+fireKey
                + " where ACCOUNT = '" +username+"';";
        try {
            Statement updateStatement = c.createStatement();
            updateStatement.executeUpdate(update);
            c.close();
            System.out.println("setting saved");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////
    //	void method to update new setting info to database  //
    //  Input	: username,width,height     				//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////
    public void updateResolution(String username,int width, int height){
        Connection c = connectDB();
        String update = "UPDATE setting"
                + " set RESOLUTION_WIDTH = "+width+","
                + " set RESOLUTION_HEIGHT = "+height+","
                + " where ACCOUNT = '" +username+"';";
        try {
            Statement updateStatement = c.createStatement();
            updateStatement.executeUpdate(update);
            c.close();
            System.out.println("setting saved");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////
    //	void method to update new setting info to database  //
    //  Input	: username,width,height     				//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////
    public void updateFireKey(String username,String fireKey){
        Connection c = connectDB();
        String update = "UPDATE setting"
                + " set fireKey = "+fireKey
                + " where ACCOUNT = '" +username+"';";
        try {
            Statement updateStatement = c.createStatement();
            updateStatement.executeUpdate(update);
            c.close();
            System.out.println("setting saved");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////
    //	void method to insert new score info to database    //
    //  Input	: None										//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////
    public void insertScore(String username, int score){
        Connection c = connectDB();
        String insert = "INSERT INTO SCOREBOARD (ACCOUNT,SCORE)"
                + "VALUES (?, ?);";
        try {
            PreparedStatement accountsStatement = null;
            accountsStatement = c.prepareStatement(insert);
            accountsStatement.setString(1,username);
            accountsStatement.setInt(2,score);
            accountsStatement.executeUpdate();
            c.close();
        } catch (SQLException e) {
            updateScore(username,score);
        }
        System.out.println("Scoreboard updated");
    }

    //////////////////////////////////////////////////////////
    //	void method to update new score info to database    //
    //  Input	: None										//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////
    public void updateScore(String username, int score){
        Connection c = connectDB();
        String update = "UPDATE SCOREBOARD"
                + " set SCORE = "+score
                + " where ACCOUNT = '" +username+"';";
        try {
            Statement updateStatement = c.createStatement();
            updateStatement.executeUpdate(update);
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////
    //	user login, check username & password               //
    //  Input	: Username, password						//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////
    public boolean login(String username, String password) throws SQLException{
        Connection c = connectDB();
        String query = "SELECT * FROM ACCOUNTS;";
        Statement queryStatement = c.createStatement();
        ResultSet result = queryStatement.executeQuery(query);
        boolean hasAccount = false;
        boolean login = false;
        while( result.next()){
            String usernameDB = result.getString("ACCOUNT");
            String passwordDB = result.getString("PASSWORD");
            if(usernameDB.equals(username) && passwordDB.equals(password))
            {
                hasAccount = true;
                login = true;
                System.out.println("Hello "+usernameDB);
                break;
            }
            if(usernameDB.equals(username) && !passwordDB.equals(password)){
                hasAccount = true;
                System.out.println("Wrong password");
                break;
            }
        }
        if(hasAccount == false){
            System.out.println("account not exists");
        }
        return login;
    }

    //////////////////////////////////////////////////////////
    //	Find user info (account,password,score) based on ID //
    //  Input	: ID                						//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////
    public String checkUserInfo(int userID){
        Connection c = connectDB();
        String printResult = null;
        String check = "SELECT ACCOUNTS.ID, ACCOUNTS.ACCOUNT, SCOREBOARD.SCORE FROM ACCOUNTS " +
                "INNER JOIN SCOREBOARD " +
                "WHERE ACCOUNTS.ID = "+userID+" AND SCOREBOARD.ID = "+userID+";";
        try {
            Statement checkStatement = c.createStatement();
            ResultSet result = checkStatement.executeQuery(check);
            printResult = "info check for ID:("+userID+")\nID: "+result.getString("ID")+"\nAccount:"+result.getString("ACCOUNT")+"\nScore:"+result.getInt("SCORE");
            System.out.println(printResult);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return printResult;
    }

    //////////////////////////////////////////////////////////
    //	Load resolution data                                //
    //  Input	: username             						//
    //	Output	: resolution[] 								//
    //////////////////////////////////////////////////////////
    public int[] getResolution(String username){
        Connection c = connectDB();
        int[] resolution = new int[2];
        String getResolution = "SELECT ";
        return resolution;
    }
}
