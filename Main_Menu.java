import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Main_Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main_Menu extends World
{

    /**
     * Constructor for objects of class Main_Menu.
     * 
     */
    public Mock_Blob eelo = new Mock_Blob();
    public Logo yey = new Logo();
    public Play ya = new Play();
    public int current = 1;
    public int current1 = 1;
    public int timer = 4;
    public Main_Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1);
        addObject(eelo, 365, 330);
        addObject(yey, 375, 116);
        addObject(ya, 375, 230);
        setPaintOrder(Mock_Blob.class);
        addObject(new Credits(), 375, 480);
    }
    
    public void act() {
        timer--;
        if(timer <= 0) {
            yey.change("" + current);
            ya.change("" + current1);
            current++;
            current1++;
            if(current > 8) {
                current = 1;
            }
            if(current1 > 6) {
                current1 = 1;
            }
            timer = 4;
        }
    }
}
