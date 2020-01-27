import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Villain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Villain extends Actor
{
    /**
     * Act - do whatever the Villain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int health = 100;
    public int timer = 27;
    public int fireTimer = 150;
    
    public void act() 
    {
        // Add your action code here.
        timer--;
        fireTimer--;
        if (timer <= 0) {
            timer = 27;
            if (((Elmos_World)getWorld()).me.getX() <= getX()) {
                setLocation(getX() - 2, getY());
            }
            else {
                setLocation(getX() + 2, getY());
            }
            if (((Elmos_World)getWorld()).me.getY() <= getY()) {
                setLocation(getX(), getY() - 2);
            }
            else {
                setLocation(getX(), getY() + 2);
            }
        }
        if (fireTimer <= 0) {
            Fireball f = new Fireball();
            // if (((Elmos_World)getWorld()).me.getX() <= getX()) {
                // f.dx = -2;
            // }
            // else {
                // f.dx = 2;
            // }
            // if (((Elmos_World)getWorld()).me.getY() <= getY()) {
                // f.dy = -2;
            // }
            // else {
                // f.dy = 2;
            // } 
            ((Elmos_World)getWorld()).addObject(f, getX(), getY());
            f.rawr();
            fireTimer = 150;
        }
        if (health <= 0) {
            Key k = new Key();
            ((Elmos_World)getWorld()).addObject(k, getX(), getY());
            ((Elmos_World)getWorld()).removeObject(this);
        }
        
        
    }  
}
