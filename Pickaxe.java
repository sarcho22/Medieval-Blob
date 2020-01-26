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
    public boolean ever_touched = false;
    
    public void act() 
    {
        if (((Elmos_World)getWorld()).i1.isPickaxe) {
            setLocation(((Elmos_World)getWorld()).me.getX()+((Elmos_World)getWorld()).me.getImage().getWidth()/2, ((Elmos_World)getWorld()).me.getY()-10);
        }
        //check();
        if(isTouching(Blob.class)) {
            setLocation(((Elmos_World)getWorld()).me.getX()+((Elmos_World)getWorld()).me.getImage().getWidth()/2, ((Elmos_World)getWorld()).me.getY()-10);
            Pickaxe_Image i = new Pickaxe_Image();
            ever_touched = true;
            timer--;
            if (!pickedUp) {
                if (((Elmos_World)getWorld()).i1.isEmpty) {
                    ((Elmos_World)getWorld()).i1.turnOff("pickaxe");
                }
                else if (((Elmos_World)getWorld()).i2.isEmpty) {
                    ((Elmos_World)getWorld()).i2.turnOff("pickaxe");
                }
                else if (((Elmos_World)getWorld()).i3.isEmpty) {
                    ((Elmos_World)getWorld()).i3.turnOff("pickaxe");
                }
                pickedUp = true;
            }
            if (timer <= 0 && !((Elmos_World)getWorld()).i1.isPickaxe) {
                setLocation(-5000, -5000);
            }
        }
        if (((Elmos_World)getWorld()).e_pressed && !something_normal && ever_touched){
                if(((Elmos_World)getWorld()).i1.isPickaxe) {
                    ((Elmos_World)getWorld()).addObject(i, ((Elmos_World)getWorld()).me.getX()+30, ((Elmos_World)getWorld()).me.getY()-(3*((Elmos_World)getWorld()).i1.getImage().getHeight()));
                }
                else if(((Elmos_World)getWorld()).i2.isPickaxe) {
                    ((Elmos_World)getWorld()).addObject(i, ((Elmos_World)getWorld()).me.getX()+30, ((Elmos_World)getWorld()).me.getY()-(2*((Elmos_World)getWorld()).i1.getImage().getHeight()));
                }
                else if(((Elmos_World)getWorld()).i3.isPickaxe) {
                    ((Elmos_World) getWorld()).addObject(i, ((Elmos_World)getWorld()).me.getX()+30, ((Elmos_World)getWorld()).me.getY()-(1*((Elmos_World)getWorld()).i1.getImage().getHeight()));
                }
                something_normal = true;
            }
        else if(!((Elmos_World)getWorld()).e_pressed && ever_touched){
            if(i.getWorld() != null) {
              getWorld().removeObject(i);
            }
            something_normal = false;
        }
        
    } 
    // public boolean check() {
        // if(isTouching(Mob_1.class)) {
            // return true;
        // }
        // else{
            // return false;
        // }
    // }
}
