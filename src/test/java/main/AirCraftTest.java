package main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirCraftTest {
    AirCraft test01;
    AirCraft test02;
    @Before
    public void before(){
        test01 = new AirCraft();
        test01.setFuel(100);
        test01.setMoveSpeed(10);

        test02 = new AirCraft();
        test02.setFuel(0);
        test02.setMoveSpeed(5);
    }

    @Test
    public void isZeroFuel() {
        assertEquals(false,test01.isZeroFuel());
        assertEquals(true,test02.isZeroFuel());
    }

}