import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mob_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mob_2 extends Actor
{
    /**
     * Act - do whatever the Mob_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int health = 15;
    private int dx;
    private int dy;
    public void act() 
    {
        // I made him bounce around the screen for now, but eventually we should set it up so that once a person
        // gets into a certain range within him, he starts to follow them and attack them.
        setLocation(getX()+dx, getY()+dy);
        
        if(getX() > ((Elmos_World)getWorld()).getWidth() - (getImage().getWidth() / 2) || getX() < (getImage().getWidth()) / 2) {
            dx = -dx;
        }
        if(getY() > ((Elmos_World)getWorld()).getHeight() - (getImage().getHeight() / 2) || getY() < (getImage().getHeight()) / 2) {
            dy = -dy;
        }
        direct();
        
    }    
    public void direct() {
         dx = 0-((getX() - ((Elmos_World)getWorld()).me.getX())/40);
         dy = 0-((getY() - ((Elmos_World)getWorld()).me.getY())/40);
    }
}
