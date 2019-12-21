import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kingBlob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blob extends Actor
{
    /**
     * Act - do whatever the kingBlob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move();
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
}
