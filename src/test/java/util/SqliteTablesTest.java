package util;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class SqliteTablesTest {
    SqliteTables test;
    @Before
    public void dbTest(){
        test = new SqliteTables();
        try {
            test.createTables();
        } catch (SQLException e) {
        }
        try {
            test.insertAccount("test1234","test1234");
        } catch (SQLException e) {
            System.out.println("Account already exists");
        }
        test.insertScore("test1234",2);

        test.checkUserInfo(1);
    }
    @Test
    public void insertAccount() {
        try {
            assertEquals(true,test.login("test1234","test1234"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            assertEquals(false,test.login("test1234","4321tset"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            assertEquals(false,test.login("4312341","testtda"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void insertScore() {
    }

    @Test
    public void updateScore() {
    }

    @Test
    public void checkUserInfo() {
        String expectedOutput = "info check for ID:(1)\nID: "+"1"+"\nAccount:"+"test1234"+"\nScore:2";

        assertEquals(expectedOutput,test.checkUserInfo(1));
    }
}