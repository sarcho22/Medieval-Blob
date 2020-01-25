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
    private int actionTimer = 10;
    public int currentLevel = 0;
    public int maxLevel = 3;

    public Elmos_World()
    {    
        super(750, 500, 1);
        setPaintOrder(Border.class, Sword_Image.class, Pickaxe_Image.class, Key_Image.class);
        addObject(me, me.getImage().getWidth()/2, getHeight()/2);
        addObject(new Border(), 0, 0);
        addObject(new Border(), 1 * 500, 0);
        addObject(new Border(), 0, getHeight());
        addObject(new Border(), 1 * 500, getHeight());
        showText("Welcome to Medieval Blob.", 375, 200);
        showText("Press 'Enter' to begin!", 375, 215);
    }

    public void act() {
        if(e_pressed) {
            showInventory(me.getX(), me.getY());
        }
        else{
            hideInventory();
        }
        if(actionTimer <= 0) {
            action();
            actionTimer = 10;
        }
        actionTimer--;
        if (currentLevel > 0){
            showText("Health: " + me.health, 690, 25);
        }
        if (Greenfoot.isKeyDown("enter") && currentLevel == 0){
            showText("", 375, 200);
            showText("", 375, 215);
            nextLevel();
        }
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
    
    public void nextLevel() {
        if(currentLevel > maxLevel) {
            showText("Great Job! You finished " + currentLevel + " levels!", 375, 200);
        }
        else{
            showText("Level: " + (currentLevel + 1), 35, 25);
            switch(++currentLevel){
                case 1:
                    level1();
                    break;
                case 2: 
                    level2();
                    break;
                case 3: 
                    level3();
            }
        }
    }
    
    public void level1() {
        Pickaxe pickaxe = new Pickaxe();
        addObject(pickaxe,446,250);
        Key key = new Key();
        addObject(key,685,45);
        Door door = new Door();
        addObject(door, 750, 250);
        showText("Use 'W' 'A' 'S' 'D' to move, press 'E' to open your inventory.", 375, 355);
        showText("Go to the pickaxe to pick it up! Press '1', '2', or '3' to switch items", 375, 370);
        showText("To get to the next level, find the key, pick it up,", 375, 385);
        showText("and press 'F' once you're touching the door (and holding the key).", 375, 400);
    }
    
    public void level2() {
        me.setLocation(me.getImage().getWidth()/2, getHeight()/2);
        therock rock = new therock();
        addObject(rock, 400, 250);
        Door door = new Door();
        addObject(door, 750, 250);
        showText("Can't find the key?", 375, 355);
        showText("Try mining the rock! Hint: You have to use the pickaxe.", 375, 370);
        showText("Press 'F' to use any item, not just the key.", 375, 385);
        showText("Good Luck!", 375, 400);
    }
    
    public void level3() {
        me.setLocation(me.getImage().getWidth()/2, getHeight()/2);
        therock rock = new therock();
        addObject(rock, 400, 250);
        Rock rock1 = new Rock();
        addObject(rock1, 375, 125);
        Rock rock2 = new Rock();
        addObject(rock2, 500, 179);
        Sword sword = new Sword();
        addObject(sword,543,436);
        Door door = new Door();
        addObject(door, 750, 250);
        showText("See a green thing?", 375, 355);
        showText("That's a Mob!", 375, 370);
        showText("Press 'F' while holding sword to defeat it.", 375, 385);
        showText("Good Luck!", 375, 400);
    }
}
