import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mock_Blob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mock_Blob extends Actor
{
    /**
     * Act - do whatever the Mock_Blob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        if(isTouching(Play.class)) {
            Elmos_World e = new Elmos_World();
            Greenfoot.setWorld(e);
        }
    }
    public void move() {
        if (Greenfoot.isKeyDown("d") && getX() < ((Main_Menu)getWorld()).getWidth() - (getImage().getWidth() / 2)) {
            setLocation(getX()+2, getY());
        }
        if (Greenfoot.isKeyDown("a") && getX() > (getImage().getWidth()) / 2) {
            setLocation(getX()-2, getY());
        }
        if (Greenfoot.isKeyDown("w") && getY() > (getImage().getHeight()) / 2) {
            setLocation(getX(), getY()-2);
        }
        if (Greenfoot.isKeyDown("s") && getY() < ((Main_Menu)getWorld()).getHeight() - (getImage().getHeight() / 2)) {
            setLocation(getX(), getY()+2*1);
        }
    }
}
