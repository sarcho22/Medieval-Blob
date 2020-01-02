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
    public boolean isKey;
    public boolean isEmpty;
    
    public void act() 
    {
        // Add your action code here.
        if(isTouching(Pickaxe.class)) {
            turnOff("pickaxe");
        }
        if(isTouching(Sword.class)) {
            turnOff("sword");
        }
        if(isTouching(Key.class)) {
            turnOff("key");
        }
        //displayImage();
    }
    
    public void turnOff(String current) {
        if(current == "sword") {
            isSword = true;
            isPickaxe = false;
            isKey = false;
            isEmpty = false;
        }
        if(current == "pickaxe") {
            isSword = false;
            isPickaxe = true;
            isKey = false;
            isEmpty = false;
        }
        if(current == "key") {
            isSword = false;
            isPickaxe = false;
            isKey = true;
            isEmpty = false;
        }
    }
    
    //public void displayImage() {
    //    if()
    //}
}
