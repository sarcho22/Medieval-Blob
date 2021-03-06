import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class kingBlob here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Blob extends Actor
{
    public int health = 100;
    private int mobTimer = 40;
    private int fireballTimer = 20;
    public int actionTimer = 10;
    public static Actor i_value1 = null;
    public static Actor i_value2 = null;
    public static Actor i_value3 = null;
    public boolean sword = false;
    public boolean pickaxe = false;
    public boolean key = false;
    public boolean holdingSomething = false;
    public int speed = 3;
    public int distance = 30;
    public boolean touching = false;
    /**
     * Act - do whatever the kingBlob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!((Elmos_World)getWorld()).e_pressed) {
            move();
        }
        checkMobs();
        mobTimer--;
        fireballTimer--;
        actionTimer--;
        if(actionTimer <= 0) {
            action();
            actionTimer = 10;
        }
        if(!isTouching(Sword.class)) {
            sword = false;
        }
        if (!isTouching(Pickaxe.class)) {
            pickaxe = false;
        }
        if (!isTouching(Key.class)) {
            key = false;
        }
    }    
    
    public void action() {
        if(Greenfoot.isKeyDown("f")) {
            if(((Elmos_World)getWorld()).i1.isSword) {
                attack();
            }
            if(((Elmos_World)getWorld()).i1.isPickaxe) {
                mine();
            }
            if(((Elmos_World)getWorld()).i1.isKey) {
                unlock();
            }
        }
        if(Greenfoot.isKeyDown("2") && !((Elmos_World)getWorld()).i2.isEmpty){
            String temp = ((Elmos_World)getWorld()).i1.identity;
            ((Elmos_World)getWorld()).i1.turnOff(((Elmos_World)getWorld()).i2.identity);
            ((Elmos_World)getWorld()).i2.turnOff(temp);
        }
        if(Greenfoot.isKeyDown("3") && !((Elmos_World)getWorld()).i3.isEmpty){
            String temp = ((Elmos_World)getWorld()).i1.identity;
            ((Elmos_World)getWorld()).i1.turnOff(((Elmos_World)getWorld()).i3.identity);
            ((Elmos_World)getWorld()).i3.turnOff(temp);
        }
    }
    
    public void move() {
        if (Greenfoot.isKeyDown("d") && getX() < ((Elmos_World)getWorld()).getWidth() - (getImage().getWidth() / 2)) {
            setLocation(getX()+2, getY());
        }
        if (Greenfoot.isKeyDown("a") && getX() > (getImage().getWidth()) / 2) {
            setLocation(getX()-2, getY());
        }
        if (Greenfoot.isKeyDown("w") && getY() > (getImage().getHeight()) / 2) {
            setLocation(getX(), getY()-2);
        }
        if (Greenfoot.isKeyDown("s") && getY() < ((Elmos_World)getWorld()).getHeight() - (getImage().getHeight() / 2)) {
            setLocation(getX(), getY()+2*1);
        }
    }
    public void checkMobs() {
        if(mobTimer <= 0) {
            if(isTouching(Mob_1.class)) {
                health -= 5;
                checkHealth();
                mobTimer = 40;
            }   
            if(isTouching(Mob_2.class)) {
                health -= 8;
                checkHealth();
                mobTimer = 40;
            }   
        }
        if (fireballTimer <= 0) {
            if(isTouching(Fireball.class)) {
                health -= 10;
                checkHealth();
                removeTouching(Fireball.class);
            }
            if (isTouching(Villain.class)) {
                health -= 6;
                checkHealth();
            }
            fireballTimer = 20;
        }
    }
    // public void rearrangeYourselfImmediately1(String direction) {
        // if(direction.equals("left")){
            // ((Elmos_World)getWorld()).removeObject(i_value1);
            // getWorld().addObject(i_value1, getX()+27, getY()-(3*Elmos_World.i1.getImage().getHeight()));
        // }
        // if(direction.equals("right")){
            // ((Elmos_World)getWorld()).removeObject(i_value1);
            // getWorld().addObject(i_value1, getX()+33, getY()-(3*Elmos_World.i1.getImage().getHeight()));
        // }
        // if(direction.equals("down")){
            // ((Elmos_World)getWorld()).removeObject(i_value1);
            // getWorld().addObject(i_value1, getX()+distance, getY()-(3*Elmos_World.i1.getImage().getHeight())+3);
        // }
        // if(direction.equals("up")){
            // ((Elmos_World)getWorld()).removeObject(i_value1);
            // getWorld().addObject(i_value1, getX()+distance, getY()-(3*Elmos_World.i1.getImage().getHeight())-3);
        // }
    // }
    
    // public void rearrangeYourselfImmediately2(String direction) {
        // if(direction.equals("left")){
            // ((Elmos_World)getWorld()).removeObject(i_value2);
            // getWorld().addObject(i_value2, getX()+27, getY()-(2*Elmos_World.i2.getImage().getHeight()));
        // }
        // if(direction.equals("right")){
            // ((Elmos_World)getWorld()).removeObject(i_value2);
            // getWorld().addObject(i_value2, getX()+33, getY()-(2*Elmos_World.i2.getImage().getHeight()));
        // }
        // if(direction.equals("down")){
            // ((Elmos_World)getWorld()).removeObject(i_value2);
            // getWorld().addObject(i_value2, getX()+30, getY()-(2*Elmos_World.i2.getImage().getHeight())+3);
        // }
        // if(direction.equals("up")){
            // ((Elmos_World)getWorld()).removeObject(i_value2);
            // getWorld().addObject(i_value2, getX()+30, getY()-(2*Elmos_World.i2.getImage().getHeight())-3);
        // }
    // }
    
    // public void rearrangeYourselfImmediately3(String direction) {
        // if(direction.equals("left")){
            // ((Elmos_World)getWorld()).removeObject(i_value3);
            // getWorld().addObject(i_value3, getX()+27, getY()-(1*Elmos_World.i2.getImage().getHeight()));
        // }
        // if(direction.equals("right")){
            // ((Elmos_World)getWorld()).removeObject(i_value3);
            // getWorld().addObject(i_value3, getX()+33, getY()-(1*Elmos_World.i2.getImage().getHeight()));
        // }
        // if(direction.equals("down")){
            // ((Elmos_World)getWorld()).removeObject(i_value3);
            // getWorld().addObject(i_value3, getX()+distance, getY()-(1*Elmos_World.i2.getImage().getHeight())+3);
        // }
        // if(direction.equals("up")){
            // ((Elmos_World)getWorld()).removeObject(i_value3);
            // getWorld().addObject(i_value3, getX()+distance, getY()-(1*Elmos_World.i2.getImage().getHeight())-3);
        // }
    // }
    
    public void checkHealth() {
        if(health <= 0) {
            Game_Over e = new Game_Over();
            Greenfoot.setWorld(e);
        }
    }
    
    public void attack() {
        if (isTouching(Mob_1.class)){
            removeTouching(Mob_1.class);
            health += 5;
        }
        if (isTouching(Mob_2.class)){
            Mob_2 v = (Mob_2)(getOneIntersectingObject(Mob_2.class));
            v.health -= 5;
        }
        if (isTouching(Villain.class)) {
            Villain v = (Villain)(getOneIntersectingObject(Villain.class));
            v.health -= 10;
        }
    }
    
    public void mine() {
        if (isTouching(therock.class)){
            Key key = new Key();
            therock whe = (therock)(getOneIntersectingObject(therock.class));
            ((Elmos_World)getWorld()).addObject(key, whe.getX(), whe.getY());
            removeTouching(therock.class);
        }
        if (isTouching(Rock.class)){
            Rock whe = (Rock)(getOneIntersectingObject(Rock.class));
            Mob_1 m1 = new Mob_1();
            ((Elmos_World)getWorld()).addObject(m1, whe.getX(), whe.getY());
            Mob_1 m2 = new Mob_1();
            ((Elmos_World)getWorld()).addObject(m2, whe.getX(), whe.getY());
            Mob_1 m3 = new Mob_1();
            ((Elmos_World)getWorld()).addObject(m3, whe.getX(), whe.getY());
            removeTouching(Rock.class);
        }
        if (isTouching(Rock1.class)) {
            Rock1 whe = (Rock1)(getOneIntersectingObject(Rock1.class));
            Mob_1 m1 = new Mob_1();
            ((Elmos_World)getWorld()).addObject(m1, whe.getX(), whe.getY());
            Mob_1 m2 = new Mob_1();
            ((Elmos_World)getWorld()).addObject(m2, whe.getX(), whe.getY());
            Mob_2 m3 = new Mob_2();
            ((Elmos_World)getWorld()).addObject(m3, whe.getX(), whe.getY());
            removeTouching(Rock1.class);
        }
    }
    
    public void unlock() {
        if (isTouching(Door.class)){
            if(((Elmos_World)getWorld()).i1.identity.equals("key")) {
                ((Elmos_World)getWorld()).i1.identity = "";
                ((Elmos_World)getWorld()).i1.turnOff("empty!");
            }
            if(((Elmos_World)getWorld()).i2.identity.equals("key")) {
                ((Elmos_World)getWorld()).i2.identity = "";
                ((Elmos_World)getWorld()).i2.turnOff("empty!");
            }
            if(((Elmos_World)getWorld()).i3.identity.equals("key")) {
                ((Elmos_World)getWorld()).i3.identity = "";
                ((Elmos_World)getWorld()).i3.turnOff("empty!");
            }
            removeTouching(Key.class);
            ((Elmos_World)getWorld()).nextLevel();
        }
    }
    /*
    public void store_inven(String blep, boolean open_inventory){
        if(blep.equals("sword")) {
            if(open_inventory && !sword) {
                sword = true;
                if(Elmos_World.i1.isSword) {
                    i_value1 = new Sword();
                    ((Elmos_World)getWorld()).addObject(i_value1, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                    //Elmos_World.i1.turnOff("sword");
                }
                else if(Elmos_World.i2.isSword) {
                    i_value2 = new Sword();
                    ((Elmos_World)getWorld()).addObject(i_value2, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                    //Elmos_World.i2.turnOff("sword");
                }
                else if(Elmos_World.i3.isSword) {
                    i_value3 = new Sword();
                    getWorld().addObject(i_value3, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                    //Elmos_World.i3.turnOff("sword");
                }
            }
            //if(!Elmos_World.e_pressed){
              //  if (!Elmos_World.i1.isEmpty) {
              //      getWorld().removeObject(i_value1);
              //  }
              //  if (!Elmos_World.i2.isEmpty) {
              //      getWorld().removeObject(i_value2);
              //  }
              //  if (!Elmos_World.i3.isEmpty) {
              //      getWorld().removeObject(i_value3);
              //  }
            //}
        }
        if (blep.equals("pickaxe")) {
            if(!pickaxe) {
                pickaxe = true;
                if(Elmos_World.i1.isPickaxe) {
                    i_value1 = new Pickaxe();
                    getWorld().addObject(i_value1, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                    Elmos_World.i1.turnOff("pickaxe");
                }
                else if(Elmos_World.i2.isPickaxe) {
                    i_value2 = new Pickaxe();
                    getWorld().addObject(i_value2, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                    Elmos_World.i2.turnOff("pickaxe");
                }
                else if(Elmos_World.i3.isPickaxe) {
                    i_value3 = new Pickaxe();
                    getWorld().addObject(i_value3, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                    Elmos_World.i3.turnOff("pickaxe");
                }
            }
        }
        if (blep.equals("key")) {
            if(Elmos_World.e_pressed && !key) {
            key = true;
            if(Elmos_World.i1.isKey) {
                i_value1 = new Key();
                getWorld().addObject(i_value1, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                Elmos_World.i1.turnOff("key");
            }
            else if(Elmos_World.i2.isKey) {
                i_value2 = new Key();
                getWorld().addObject(i_value2, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                Elmos_World.i2.turnOff("key");
            }
            else if(Elmos_World.i3.isKey) {
                i_value3 = new Key();
                getWorld().addObject(i_value3, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                Elmos_World.i3.turnOff("key");
            }
            }
        }
        if(!open_inventory){
                if (!Elmos_World.i1.isEmpty) {
                    getWorld().removeObject(i_value1);
                }
                if (!Elmos_World.i2.isEmpty) {
                    getWorld().removeObject(i_value2);
                }
                if (!Elmos_World.i1.isEmpty) {
                    getWorld().removeObject(i_value3);
                }
        }
    }
    */
}
