import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Elmos_World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elmos_World extends World
{
    public Inventory i1 = new Inventory();
    public Inventory i2 = new Inventory();
    public Inventory i3 = new Inventory();
    public Blob me = new Blob();
    public boolean e_pressed = false;
    private int actionTimer = 10;
    public int currentLevel = 0;
    public int maxLevel = 7;

    public Elmos_World()
    {    
        super(750, 500, 1);
        setPaintOrder(Border.class, Sword_Image.class, Pickaxe_Image.class, Key_Image.class, Sword.class, Pickaxe.class, Key.class, Blob.class, Villain.class, Door.class);
        addObject(me, me.getImage().getWidth()/2, getHeight()/2);
        addObject(new Border(), 0, 0);
        addObject(new Border(), 1 * 500, 0);
        addObject(new Border(), 0, getHeight());
        addObject(new Border(), 1 * 500, getHeight());
        nextLevel();
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
        if(currentLevel >= maxLevel) {
            Done e = new Done();
            Greenfoot.setWorld(e);
        }
        else{
            removeObjects(getObjects(Mob_1.class));
            removeObjects(getObjects(Rock.class));
            removeObjects(getObjects(therock.class));
            removeObjects(getObjects(Rock1.class));
            removeObjects(getObjects(Mob_2.class));
            me.setLocation(me.getImage().getWidth()/2, getHeight()/2);
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
                    break;
                case 4:
                    level4();
                    break;
                case 5:
                    level5();
                    break;
                case 6:
                    level6();
                    break;
                case 7:
                    maxLevelFunc();
                    break;
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
        ArrayList<Actor> rawr = new ArrayList<Actor>(Arrays.asList(new Rock(), new Rock(),new therock()));
        
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 221, 323);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 375, 435);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 633, 179);
        
        Sword sword = new Sword();
        addObject(sword,543,436);
        Door door = new Door();
        addObject(door, 750, 250);
        showText("See a green thing?", 375, 355);
        showText("That's a Mob!", 375, 370);
        showText("Press 'F' while holding the sword to defeat it.", 375, 385);
        showText("Good Luck!", 375, 400);
    }
    
    public void level4() {
        showText("", 375, 355);
        showText("", 375, 370);
        showText("", 375, 385);
        showText("", 375, 400);
        Door door = new Door();
        addObject(door, 750, 250);
        
        ArrayList<Actor> rawr = new ArrayList<Actor>(Arrays.asList(new Rock(), new Rock(), new Rock(), new Rock(), new Rock(), new therock()));
        
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 560, 38);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 348, 313);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 253, 257);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 692, 363);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 164, 157);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 467, 423);
    }
    
    public void level5() {
        Door door = new Door();
        addObject(door, 750, 250);
        ArrayList<Actor> rawr = new ArrayList<Actor>(Arrays.asList(new Rock(), new Rock(), new Rock(), new therock(), new Rock1(), new Rock1()));
        
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 612, 310);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 402, 108);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 111, 383);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 295, 410);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 300, 170);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 511, 199);
    }
    
    public void level6() {
        Door door = new Door();
        addObject(door, 750, 250);
        ArrayList<Actor> rawr = new ArrayList<Actor>(Arrays.asList(new Rock(), new Rock(), new therock(), new therock(), new Rock1(), new Rock1()));
        
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 246, 452);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 312, 362);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 195, 328);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 483, 193);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 582, 210);
        addObject(rawr.remove((int)(Math.random()*rawr.size())), 623, 284);
    }
    
    public void maxLevelFunc() {
        addObject(new Villain(), 740, 250);
    }
}
