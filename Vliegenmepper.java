import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vliegenmepper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vliegenmepper extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    public int pauze = 0;

    public Vliegenmepper()
    {
        image1 = new GreenfootImage("vliegenmepper.png");
        image2 = new GreenfootImage("vliegenmepper2.png");
        setImage(image1);
    }

    /**
     * Act - do whatever the Vliegenmepper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        String key = Greenfoot.getKey(); 
        
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-20);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            turn(20);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            move(-5);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            move(5);
        }  
        if ((key != null && key.equals("space")))
        {
            setImage(image2);
            Greenfoot.playSound("Clap.mp3");
            Kill();
        }
        else
        {
            setImage(image1);            
        }

    }  

    public void Kill()
    {
        if ( isTouching(Fly.class))
        {
            removeTouching(Fly.class);  
            MyWorld.Score++;
            MyWorld.FlyCountDisplay = MyWorld.FlyCountDisplay - 1;
        }
    }
}
