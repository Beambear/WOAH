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
//	A method to build the connection with Database      //
//	Input	: None										//
//	Output	: Connection								//
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

    //////////////////////////////////////////////////////////
    //	void method to create database tables               //
    //  1.Accounts table contains ID,ACCOUNT,PASSWORD       //
    //  2.Scoreboard table contains ID,ACCOUNT,SCORES       //
    //	Input	: None										//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////
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

    //////////////////////////////////////////////////////////
    //	void method to insert new account info to database  //
    //  Input	: None										//
    //	Output	: None      								//
    //////////////////////////////////////////////////////////
    public void insertAccount(String username, String password) throws SQLException{
        Connection c = connectDB();
        String insert = "INSERT INTO ACCOUNTS (ACCOUNT,PASSWORD)"
                        + "VALUES (?, ?);";
        PreparedStatement accountsStatement = c.prepareStatement(insert);
        accountsStatement.setString(1,username);
        accountsStatement.setString(2,password);
        accountsStatement.executeUpdate();
        c.close();
        insertScore(username,0);
        System.out.println("new account created");
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
}
