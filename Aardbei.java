import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Appel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aardbei extends Fruit
{
    /**
     * Act - do whatever the Appel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage aardbei;
    private GreenfootImage aardbeif1;
    private GreenfootImage aardbeif2;
    public int Timer = 0;
    public Aardbei() 
    {
        aardbei = new GreenfootImage("aardbei_transparant.png");
        aardbei.scale(112,90);
        aardbeif1 = new GreenfootImage("aardbei_transparant 1.png");
        aardbeif1.scale(112,90);
        aardbeif2 = new GreenfootImage("aardbei_transparant 2.png");
        aardbeif2.scale(112,90);
        setImage (aardbei);
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
                setImage (aardbei);
            }
            if (Timer == 400)
            {
                setImage (aardbeif1);
            }
            if (Timer == 600)
            {
                setImage (aardbeif2);
            }
            if (Timer == 650)
            {
                getWorld().removeObject(this);
            }
        }
    }   
}
