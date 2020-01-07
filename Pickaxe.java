import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pickaxe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pickaxe extends Actor
{
    /**
     * Act - do whatever the pickaxe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean firstPickedUp = false;
    public void act() 
    {
        if(isTouching(Blob.class) && !Elmos_World.me.holdingSomething) {
            firstPickedUp = true;
            Elmos_World.me.holdingSomething = true;
        }
        if (firstPickedUp) {
            setLocation(Elmos_World.me.getX()+Elmos_World.me.getImage().getWidth()/2, Elmos_World.me.getY()-10);
        } 
      
    }    
}
