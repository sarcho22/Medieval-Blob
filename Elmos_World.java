import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elmos_World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elmos_World extends World
{
    public static Inventory i1 = new Inventory();
    public static Inventory i2 = new Inventory();
    public static Inventory i3 = new Inventory();
    public static Blob me = new Blob();
    public static boolean e_pressed = false;
    private int countDown = 10;
    
    public Elmos_World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1);
        setPaintOrder(Sword_Image.class, Pickaxe_Image.class, Key_Image.class);
        addObject(me, me.getImage().getWidth()/2, getHeight()/2);
    }
    public void act() {
        
        if(e_pressed) {
            showInventory(me.getX(), me.getY());
        }
        else{
            hideInventory();
        }
        if(countDown <= 0) {
            action();
            countDown = 10;
        }
        countDown--;
    }
    
    public void action() {
        if(Greenfoot.isKeyDown("e")) {
            if(e_pressed) {
                e_pressed = false;
            }
            else{
                e_pressed = true;
            }
        }
        
        // if(e_pressed) {
            // if (Greenfoot.isKeyDown("d")) {
                // hideInventory();
                // showInventory(me.getX(), me.getY());
                // if (!i1.isEmpty) {
                    // me.rearrangeYourselfImmediately1("right");
                // }
                // if (!i2.isEmpty) {
                    // me.rearrangeYourselfImmediately2("right");
                // }
                // if (!i3.isEmpty) {
                    // me.rearrangeYourselfImmediately3("right");
                // }
            // }
            // if (Greenfoot.isKeyDown("a")) {
                // hideInventory();
                // showInventory(me.getX(), me.getY());
                // if (!i1.isEmpty) {
                    // me.rearrangeYourselfImmediately1("left");
                // }
                // if (!i2.isEmpty) {
                    // me.rearrangeYourselfImmediately2("left");
                // }
                // if (!i3.isEmpty) {
                    // me.rearrangeYourselfImmediately3("left");
                // }
            // }
            // if (Greenfoot.isKeyDown("w")) {
                // hideInventory();
                // showInventory(me.getX(), me.getY());
                // if (!i1.isEmpty) {
                    // me.rearrangeYourselfImmediately1("up");
                // }
                // if (!i2.isEmpty) {
                    // me.rearrangeYourselfImmediately2("up");
                // }
                // if (!i3.isEmpty) {
                    // me.rearrangeYourselfImmediately3("up");
                // }
            // }
            // if (Greenfoot.isKeyDown("s")) {
                // hideInventory();
                // showInventory(me.getX(), me.getY());
                // if (!i1.isEmpty) {
                    // me.rearrangeYourselfImmediately1("down");
                // }
                // if (!i2.isEmpty) {
                    // me.rearrangeYourselfImmediately2("down");
                // }
                // if (!i3.isEmpty) {
                    // me.rearrangeYourselfImmediately3("down");
                // }
            // }
        // }
       
    }
    
    public void showInventory(int x, int y) {
        addObject(i1, x+30, y-(3*i1.getImage().getHeight()));
        addObject(i2, x+30, y-(2*i2.getImage().getHeight()));
        addObject(i3, x+30, y-(1*i3.getImage().getHeight()));
    }
    
    public void hideInventory() {
        removeObject(i1);
        removeObject(i2);
        removeObject(i3);
    }
    
    
}
