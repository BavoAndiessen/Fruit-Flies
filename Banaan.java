import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Appel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banaan extends Fruit
{
    /**
     * Act - do whatever the Appel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage banaan;
    private GreenfootImage banaanf1;
    private GreenfootImage banaanf2;
    public int Timer = 0;
    public Banaan() 
    {
        banaan = new GreenfootImage("bannaan_transparant.png");        
        banaanf1 = new GreenfootImage("bannaan_transparant 1.png");        
        banaanf2 = new GreenfootImage("bannaan_transparant 2.png");        
        setImage (banaan);
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
                setImage (banaan);
            }
            if (Timer == 400)
            {
                setImage (banaanf1);
            }
            if (Timer == 600)
            {
                setImage (banaanf2);
            }
            if (Timer == 650)
            {
                getWorld().removeObject(this);
            }
        }
    }   
}
