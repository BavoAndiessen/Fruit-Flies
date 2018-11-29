import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Appel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kers extends Fruit
{
    /**
     * Act - do whatever the Appel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage kers;
    private GreenfootImage kersf1;
    private GreenfootImage kersf2;
    public int Timer = 0;
    public Kers() 
    {
        kers = new GreenfootImage("kers_transparant.png");
        kers.scale(112,90);
        kersf1 = new GreenfootImage("kers_transparant 1.png");
        kersf1.scale(112,90);
        kersf2 = new GreenfootImage("kers_transparant 2.png");
        kersf2.scale(112,90);
        setImage (kers);
        // Add your action code here.
    }   

    public void act()
    {
        Fly fly = (Fly) getOneIntersectingObject(Fly.class);
        if (fly != null)
        {
            fly.stop();
            Timer ++;
            if (Timer == 1)
            { 
                setImage (kers);
            }
            if (Timer == 400)
            {
                setImage (kersf1);
            }
            if (Timer == 600)
            {
                setImage (kersf2);
            }
            if (Timer == 650)
            {
                getWorld().removeObject(this);
            }
        }
    }   
}
