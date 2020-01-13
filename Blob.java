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
private int countDown = 40;
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
    // Add your action code here.
    if (!Elmos_World.e_pressed) {
        move();
    }
    checkMobs();
    countDown--;
    //action();
    if(isTouching(Sword.class)) {
        //store_inven("sword", Elmos_World.e_pressed);
    }
    else{
        sword = false;
    }
    if (isTouching(Pickaxe.class)) {
        //store_inven("pickaxe");
    }
    else {
        pickaxe = false;
    }
    if (isTouching(Key.class)) {
        //store_inven("key");
    }
    else {
        key = false;
    }
}    
    
    public void action() {
        if(Greenfoot.isKeyDown("f")) {
            if(Elmos_World.i1.isSword) {
                attack();
            }
            if(Elmos_World.i1.isPickaxe) {
                mine();
            }
            if(Elmos_World.i1.isKey) {
                unlock();
            }
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
        if(countDown <= 0) {
            if(isTouching(Mob_1.class)) {
                health -= 5;
                checkHealth();
                countDown = 40;
            }   
        }
        
    }
    public void rearrangeYourselfImmediately1(String direction) {
        if(direction.equals("left")){
            ((Elmos_World)getWorld()).removeObject(i_value1);
            getWorld().addObject(i_value1, getX()+27, getY()-(3*Elmos_World.i1.getImage().getHeight()));
        }
        if(direction.equals("right")){
            ((Elmos_World)getWorld()).removeObject(i_value1);
            getWorld().addObject(i_value1, getX()+33, getY()-(3*Elmos_World.i1.getImage().getHeight()));
        }
        if(direction.equals("down")){
            ((Elmos_World)getWorld()).removeObject(i_value1);
            getWorld().addObject(i_value1, getX()+distance, getY()-(3*Elmos_World.i1.getImage().getHeight())+3);
        }
        if(direction.equals("up")){
            ((Elmos_World)getWorld()).removeObject(i_value1);
            getWorld().addObject(i_value1, getX()+distance, getY()-(3*Elmos_World.i1.getImage().getHeight())-3);
        }
    }
    
    public void rearrangeYourselfImmediately2(String direction) {
        if(direction.equals("left")){
            ((Elmos_World)getWorld()).removeObject(i_value2);
            getWorld().addObject(i_value2, getX()+27, getY()-(2*Elmos_World.i2.getImage().getHeight()));
        }
        if(direction.equals("right")){
            ((Elmos_World)getWorld()).removeObject(i_value2);
            getWorld().addObject(i_value2, getX()+33, getY()-(2*Elmos_World.i2.getImage().getHeight()));
        }
        if(direction.equals("down")){
            ((Elmos_World)getWorld()).removeObject(i_value2);
            getWorld().addObject(i_value2, getX()+30, getY()-(2*Elmos_World.i2.getImage().getHeight())+3);
        }
        if(direction.equals("up")){
            ((Elmos_World)getWorld()).removeObject(i_value2);
            getWorld().addObject(i_value2, getX()+30, getY()-(2*Elmos_World.i2.getImage().getHeight())-3);
        }
    }
    
    public void rearrangeYourselfImmediately3(String direction) {
        if(direction.equals("left")){
            ((Elmos_World)getWorld()).removeObject(i_value3);
            getWorld().addObject(i_value3, getX()+27, getY()-(1*Elmos_World.i2.getImage().getHeight()));
        }
        if(direction.equals("right")){
            ((Elmos_World)getWorld()).removeObject(i_value3);
            getWorld().addObject(i_value3, getX()+33, getY()-(1*Elmos_World.i2.getImage().getHeight()));
        }
        if(direction.equals("down")){
            ((Elmos_World)getWorld()).removeObject(i_value3);
            getWorld().addObject(i_value3, getX()+distance, getY()-(1*Elmos_World.i2.getImage().getHeight())+3);
        }
        if(direction.equals("up")){
            ((Elmos_World)getWorld()).removeObject(i_value3);
            getWorld().addObject(i_value3, getX()+distance, getY()-(1*Elmos_World.i2.getImage().getHeight())-3);
        }
    }
    
    public void checkHealth() {
        if(health <= 0) {
            getWorld().showText("You died. You suck. Try harder lol", 375, 250);
            Greenfoot.stop();
        }
    }
    
    public void attack() {
        if(i_value1.getWorld() != null && touching && countDown <= 0) {
            countDown = 35;
        }
    }
    
    public void mine() {
    }
    
    public void unlock() {
        // also check if u touching door
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
