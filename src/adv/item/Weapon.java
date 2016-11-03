/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adv.item;

/**
 *
 * @author thomasthimothee
 */
public class Weapon extends Item
{

    public int use()
    {
        return this.getDamage();
    }

}
