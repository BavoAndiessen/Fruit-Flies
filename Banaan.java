import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        banaan = new GreenfootImage("banaan_transparant.png");
        banaan.scale(112,90);
        banaanf1 = new GreenfootImage("banaan_transparant 1.png");
        banaanf1.scale(112,90);
        banaanf2 = new GreenfootImage("banaan_transparant 2.png");
        banaanf2.scale(112,90);
        setImage (banaan);
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
