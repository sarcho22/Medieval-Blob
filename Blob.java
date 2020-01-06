import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class kingBlob here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Blob extends Actor
{
private int health = 100;
private int countDown = 10;
public static Actor i = null;
public boolean sword = false;
/**
 * Act - do whatever the kingBlob wants to do. This method is called whenever
 * the 'Act' or 'Run' button gets pressed in the environment.
 */
public void act() 
{
    // Add your action code here.
    move();
    checkMobs();
    countDown--;
    action();
    if(isTouching(Sword.class)) {
        if(Elmos_World.e_pressed && !sword) {
            i = new Sword();
            sword = true;
                if(Elmos_World.i1.isEmpty) {
                    getWorld().addObject(i, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                }
                else if(Elmos_World.i2.isEmpty) {
                    getWorld().addObject(i, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                }
                else if(Elmos_World.i3.isEmpty) {
                    getWorld().addObject(i, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight()));
                }
                
        }
        if(!Elmos_World.e_pressed){
            getWorld().removeObject(i);
        }
    }
    else{
        sword = false;
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
            setLocation(getX()+3, getY());
        }
        if (Greenfoot.isKeyDown("a") && getX() > (getImage().getWidth()) / 2) {
            setLocation(getX()-3, getY());
        }
        if (Greenfoot.isKeyDown("w") && getY() > (getImage().getHeight()) / 2) {
            setLocation(getX(), getY()-3);
        }
        if (Greenfoot.isKeyDown("s") && getY() < ((Elmos_World)getWorld()).getHeight() - (getImage().getHeight() / 2)) {
            setLocation(getX(), getY()+3);
        }
    }
    
    public void checkMobs() {
        if(countDown <= 0) {
            if(isTouching(Mob_1.class)) {
                health -= 5;
                checkHealth();
                countDown = 10;
            }   
        }
        
    }
    
    
    
    public void rearrangeYourselfImmediately(String direction) {
        if(direction.equals("left")){
            ((Elmos_World)getWorld()).removeObject(i);
            getWorld().addObject(i, getX()+27, getY()-(2*Elmos_World.i1.getImage().getHeight()));
        }
        if(direction.equals("right")){
            ((Elmos_World)getWorld()).removeObject(i);
            getWorld().addObject(i, getX()+33, getY()-(2*Elmos_World.i1.getImage().getHeight()));
        }
        if(direction.equals("down")){
            ((Elmos_World)getWorld()).removeObject(i);
            getWorld().addObject(i, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight())+3);
        }
        if(direction.equals("up")){
            ((Elmos_World)getWorld()).removeObject(i);
            getWorld().addObject(i, getX()+30, getY()-(2*Elmos_World.i1.getImage().getHeight())-3);
        }
    }
    
    public void checkHealth() {
        if(health <= 0) {
            Greenfoot.stop();
        }
    }
    
    public void attack() {
        
    }
    
    public void mine() {
    }
    
    public void unlock() {
        // also check if u touching door
    }
}
