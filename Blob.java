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
    /**
     * Act - do whatever the kingBlob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move();
        checkMobs();
    }    
    
    public void action() {
        if(Greenfoot.isKeyDown("f")) {
            attack();
        }
    }
    
    public void move() {
        if (Greenfoot.isKeyDown("right") && getX() < ((Elmos_World)getWorld()).getWidth() - (getImage().getWidth() / 2)) {
            setLocation(getX()+3, getY());
        }
        if (Greenfoot.isKeyDown("left") && getX() > (getImage().getWidth()) / 2) {
            setLocation(getX()-3, getY());
        }
        if (Greenfoot.isKeyDown("up") && getY() > (getImage().getHeight()) / 2) {
            setLocation(getX(), getY()-3);
        }
        if (Greenfoot.isKeyDown("down") && getY() < ((Elmos_World)getWorld()).getHeight() - (getImage().getHeight() / 2)) {
            setLocation(getX(), getY()+3);
        }
    }
    
    public void checkMobs() {
        if(isTouching(Mob_1.class)) {
            health -= 5;
            checkHealth();
        }
    }
    
    public void checkHealth() {
        if(health <= 0) {
            Greenfoot.stop();
        }
    }
    
    public void attack() {
        if(Elmos_World.i1.isSword) {
        }
    }
}
