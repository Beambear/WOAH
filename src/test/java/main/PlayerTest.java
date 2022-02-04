package main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player;
    @Before
    public void before(){
        player = new Player();
    }
    @Test
    public void useItem() {
        player.useItem(player);
        assertEquals(15,player.getMoveSpeed());
    }

    @Test
    public void fire() {
        player.fire();
        assertNotNull(player.bulletList.get(0));
    }
}