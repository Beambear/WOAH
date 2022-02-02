package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: Inventory
// 	Description:
//		This is a generic class to store different
//      types of items which are picked up by player.
//      Contains 1 attributes.
//      Contains getters & setters.
public class Inventory<T> {
    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    private T item;
}
