package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnvironmentObjectTest {
    StageCeiling test01;

    @Test
    public void isOutWindow() {
        test01 = new StageCeiling();
        test01.setX(-800);
        assertEquals(true,test01.isOutWindow());

        test01.setX(-701);
        assertEquals(true,test01.isOutWindow());

        test01.setX(-699);
        assertEquals(false,test01.isOutWindow());
    }
}