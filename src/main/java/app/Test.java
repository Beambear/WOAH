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
}
