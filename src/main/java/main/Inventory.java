package main;

import java.util.ArrayList;

//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: Inventory
// 	Description:
//		This is a generic class to store different
//      types of items/Weapons/autoWeapons/reward items which are picked up by player.
//      Store things and switch desired item to [0] as selected one.
//      Remove used item from inventory.
//      Contains 1 attributes.
//      Contains getters & setters.
public class Inventory<T> {
    private ArrayList<T> inventory;

    public ArrayList<T> getInventory() {
        return inventory;
    }
    public T getInventory(int index) {
        return inventory.get(index);
    }

    public void setInventory(ArrayList<T> inventory) {
        this.inventory = inventory;
    }
    public void setInventory(int index,T item) {
        this.inventory.set(index,item);
    }

    public Inventory(){
        inventory = new ArrayList<T>();
    }
    public void add(T item){
        inventory.add(item);
    }
    public void switchItem(){
        T currItem = inventory.get(0);
        for(int i=0;i<inventory.size()-1;i++){
            inventory.set(i,inventory.get(i+1));
        }
        inventory.set(inventory.size()-1,currItem);
    }
    public void removeCurrentItem(){
        inventory.remove(0);
    }

}
