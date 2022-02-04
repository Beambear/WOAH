package main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {
    Inventory<Item> inventory;
    @Before
    public void before(){
        inventory = new Inventory<Item>();
        inventory.add(new Item("item01"));
        inventory.add(new Item("item02"));
    }
    @Test
    public void add() {
//        inventory.add(new Item("random"));
//        System.out.println(inventory.getInventory(0).getItemCode());
//        assertEquals("null",inventory.getInventory(0));
        assertNotNull(inventory);
        assertEquals("item01",inventory.getInventory(0).getItemCode());
        assertEquals("item02",inventory.getInventory(1).getItemCode());
    }

    @Test
    public void switchItem() {
        inventory.switchItem();
        assertEquals("item02",inventory.getInventory(0).getItemCode());
        assertEquals("item01",inventory.getInventory(1).getItemCode());
    }

    @Test
    public void removeCurrentItem() {
        inventory.removeCurrentItem();
        assertEquals("item02",inventory.getInventory(0).getItemCode());
    }
}