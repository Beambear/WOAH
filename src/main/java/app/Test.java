package app;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: Test
// 	Description:
//		Used to test some temporary code
//

import main.Weapon;
import main.WeaponPlayer;
import util.SqliteTables;

import java.sql.SQLException;
import java.util.ArrayList;

//////////////////////////////////////////////////////////
//	void method                                			//
//	Input	: None										//
//	Output	: None										//
//////////////////////////////////////////////////////////
public class Test {
    public void streamTest(){
        ArrayList<String> codes = new ArrayList<>();
        codes.add("player01");
        codes.add("player02");
        ArrayList<Weapon> weapons = new ArrayList<>();
        codes.stream().forEach(s->weapons.add(new WeaponPlayer(s)));
        System.out.println(weapons.get(0).getWeaponCode());
    }

    public void dbTest(){
        SqliteTables test = new SqliteTables();
        try {
            test.createTables();
        } catch (SQLException e) {
            System.out.println("Accounts Table already exists");
        }

        try {
            test.insertAccount("test1234","test1234");
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("Account already exists");
        }

        test.insertScore("test1234",2);


        try {
            test.login("test1234","test1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        test.checkUserInfo(1);
    }
}
