import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Done here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Done extends World
{
    public int timer = 300;
    /**
     * Constructor for objects of class Done.
     * 
     */
    public Done()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1);
    }
    
    public void act() {
        timer--;
        if(timer <= 0) {
            setBackground(new GreenfootImage("done.png"));
            showText("lol sorry did u panic? u should've known", 500, 310);
            showText("tsk tsk, u suck :3", 500, 330);
            showText("congratz tho", 500, 350);
            showText("thx for playing", 500, 370);
            addObject(new Credits(), 375, 480);
        }
    }
}
