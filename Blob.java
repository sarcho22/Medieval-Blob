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
