import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends Actor
{
    /**
     * Act - do whatever the inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean isPickaxe;
    public boolean isSword;
    
    public void act() 
    {
        // Add your action code here.
        if(isTouching(Pickaxe.class)) {
            turnOff("pickaxe");
        }
        if(isTouching(Sword.class)) {
            turnOff("sword");
        }
    }
    
    public void turnOff(String current) {
        if(current == "sword") {
            isSword = true;
            isPickaxe = false;
        }
        if(current == "pickaxe") {
            isSword = false;
            isPickaxe = true;
        }
    }
}
