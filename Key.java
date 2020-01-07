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
    public int blah = 13;
    public void act() 
    {
        if(isTouching(Blob.class)) {
            setLocation(Elmos_World.me.getX()+Elmos_World.me.getImage().getWidth()/2, Elmos_World.me.getY()-10);
            blah--;
            if (!pickedUp) {
                if (Elmos_World.i1.isEmpty) {
                    Elmos_World.i1.turnOff("key");
                }
                else if (Elmos_World.i2.isEmpty) {
                    Elmos_World.i2.turnOff("key");
                }
                else if (Elmos_World.i3.isEmpty) {
                    Elmos_World.i3.turnOff("key");
                }
                pickedUp = true;
            }
            if (blah <=  0 && !Elmos_World.i1.isKey) {
                getWorld().removeObject(this);
            }
        }
        
    }  
}
