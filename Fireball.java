import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int dx = 0;
    public int dy = 0;
    public void act() 
    {
        if (getX() <= 0 || getX() >= ((Elmos_World)getWorld()).getWidth() || getY() <= 0 || getY() >= ((Elmos_World)getWorld()).getHeight()) {
            ((Elmos_World)getWorld()).removeObject(this);
        }
        else {
            move();
        }
    }
    public void move() {
        int x = ((Elmos_World)getWorld()).me.getX();
        int y = ((Elmos_World)getWorld()).me.getY();
        dy = 0-(getY() - y) - ((getY() - y)/1000);
        dx = 0-(getX() - x) - ((getX() - x)/1000);
        setLocation(getX()+dx, getY()+dy);
    }
   
}
