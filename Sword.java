import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Actor
{
    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean pickedUp = false;
    public int timer = 13;
    public void act() 
    {
        // Add your action code here.
        if(isTouching(Blob.class)) {
            setLocation(Elmos_World.me.getX()+Elmos_World.me.getImage().getWidth()/2, Elmos_World.me.getY()-10);
            Sword_Image i = new Sword_Image();
            if (Elmos_World.e_pressed){
                ((Elmos_World) getWorld()).addObject(i, 1, 1);
            }
            //later get rid of calling store_inven thing idk
            
            timer--;
            if (!pickedUp) {
                if (Elmos_World.i1.isEmpty) {
                    Elmos_World.i1.turnOff("sword");
                }
                else if (Elmos_World.i2.isEmpty) {
                    Elmos_World.i2.turnOff("sword");
                }
                else if (Elmos_World.i3.isEmpty) {
                    Elmos_World.i3.turnOff("sword");
                }
                pickedUp = true;
            }
            if (timer <= 0 && !Elmos_World.i1.isSword) {
                getWorld().removeObject(this);
            }
        }
    }   
}
