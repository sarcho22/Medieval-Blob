import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pickaxe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pickaxe extends Actor
{
    /**
     * Act - do whatever the Pickaxe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean pickedUp = false;
    public int timer = 13;
    public boolean something_normal = false;
    public Pickaxe_Image i = new Pickaxe_Image();
    
    public void act() 
    {
        // Add your action code here.
        if(isTouching(Blob.class)) {
            setLocation(Elmos_World.me.getX()+Elmos_World.me.getImage().getWidth()/2, Elmos_World.me.getY()-10);
            
            if (Elmos_World.e_pressed && !something_normal){
                if(Elmos_World.i1.isPickaxe) {
                    ((Elmos_World)getWorld()).addObject(i, Elmos_World.me.getX()+30, Elmos_World.me.getY()-(3*Elmos_World.i1.getImage().getHeight()));
                }
                else if(Elmos_World.i2.isPickaxe) {
                    ((Elmos_World)getWorld()).addObject(i, Elmos_World.me.getX()+30, Elmos_World.me.getY()-(2*Elmos_World.i1.getImage().getHeight()));
                }
                else if(Elmos_World.i3.isPickaxe) {
                    ((Elmos_World) getWorld()).addObject(i, Elmos_World.me.getX()+30, Elmos_World.me.getY()-(1*Elmos_World.i1.getImage().getHeight()));
                }
                something_normal = true;
            }
            else if(!Elmos_World.e_pressed){
                getWorld().removeObject(i);
                something_normal = false;
            }
            timer--;
            if (!pickedUp) {
                if (Elmos_World.i1.isEmpty) {
                    Elmos_World.i1.turnOff("pickaxe");
                }
                else if (Elmos_World.i2.isEmpty) {
                    Elmos_World.i2.turnOff("pickaxe");
                }
                else if (Elmos_World.i3.isEmpty) {
                    Elmos_World.i3.turnOff("pickaxe");
                }
                pickedUp = true;
            }
            if (timer <= 0 && !Elmos_World.i1.isPickaxe) {
                getWorld().removeObject(this);
            }
        }
    }   
}
