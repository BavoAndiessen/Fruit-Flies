import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Appel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Appel extends Fruit
{
    /**
     * Act - do whatever the Appel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage appel;
    private GreenfootImage appelf1;
    private GreenfootImage appelf2;
    public int Timer = 0;
    public Appel() 
    {
        appel = new GreenfootImage("appel_transparant.png");
        appelf1 = new GreenfootImage("appel_transparant 1.png");    
        appelf2 = new GreenfootImage("appel_transparant 2.png");
        setImage (appel);
        // Add your action code here.
    }   

    public void act()
    {
        Fly fly = (Fly) getOneIntersectingObject(Fly.class);
        List<Fly> flies = getIntersectingObjects(Fly.class);
        if (fly != null)
        {
            for(Fly vlieg : flies)
            {
                vlieg.stop();
            }        
            Timer ++;
            if (Timer == 1)
            { 
                setImage (appel);
            }
            if (Timer == 400)
            {
                setImage (appelf1);
            }
            if (Timer == 600)
            {
                setImage (appelf2);
            }
            if (Timer == 650)
            {
                getWorld().removeObject(this);
            }
        }
    }   
}
