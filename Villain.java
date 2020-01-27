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
    public int fireTimer = 70;
    
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
            fireTimer = 70;
        }
        if (health <= 0) {
            ((Elmos_World)getWorld()).removeObject(this);
            //write code to call the end of the game
        }
        ((Elmos_World)getWorld()).showText("Villain Health: " + health, getX(), getY()-50);
        ((Elmos_World)getWorld()).showText("", getX(), getY()-50);
        
    }  
}
