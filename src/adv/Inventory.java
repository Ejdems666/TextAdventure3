/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adv;

import adv.item.Item;

import java.util.ArrayList;

/**
 *
 * @author thomasthimothee
 */
public class Inventory {
    private ArrayList<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<Item>();
    }
    
    public void addToInventory(Item item) {
        inventory.add(item);
    }
    
    public Item PickUp (int index)
    {
        Item item = inventory.get(index);
        inventory.remove(index);
        return item;
        
    }
       
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        for (int i= 0; i < inventory.size(); i++)
        {
            res.append(inventory.get(i).getName());
            res.append(" ");
        }
        return res.toString();  //this toString is another toString, it is the toString method of the obecjt res which is a StringBuilder  
    }
    
    
    
}
