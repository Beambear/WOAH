package main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    Item item;
    Player player;
    @Before
    public void before(){
        item = new Item();
        player = new Player();
    }

    @Test
    public void useItem() {
        item.useItem(player);
        assertEquals(15,player.getMoveSpeed());
    }
}