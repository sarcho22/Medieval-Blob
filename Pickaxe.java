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
    public boolean pickedUp = false;
    public int blah = 13;
    public void act() 
    {
        if(isTouching(Blob.class)) {
            setLocation(Elmos_World.me.getX()+Elmos_World.me.getImage().getWidth()/2, Elmos_World.me.getY()-10);
            blah--;
            if (!pickedUp) {
                if (Elmos_World.i1.isEmpty) {
                    Elmos_World.i1.turnOff("pickaxe");
                }
                else if (Elmos_World.i2.isEmpty) {
                    Elmos_World.i2.turnOff("pickaxe");
                    getWorld().showText("" + Elmos_World.i2.isPickaxe, 200,300);
                }
                else if (Elmos_World.i3.isEmpty) {
                    Elmos_World.i3.turnOff("pickaxe");
                }
                pickedUp = true;
            }
            if (blah <= 0 && !Elmos_World.i1.isPickaxe) {
                getWorld().removeObject(this);
            }
        }
        
      
    }    
}
