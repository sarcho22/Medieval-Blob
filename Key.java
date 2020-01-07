import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Actor
{
    /**
     * Act - do whatever the Key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean pickedUp = false;
    public void act() 
    {
        if(isTouching(Blob.class)) {
            pickedUp = true;
            setLocation(Elmos_World.me.getX()+Elmos_World.me.getImage().getWidth()/2, Elmos_World.me.getY()-10);
        }
    }  
}
