import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aardbei here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aardbei extends Fruit
{
    private GreenfootImage aardbei;
    private GreenfootImage aardbeif1;
    private GreenfootImage aardbeif2;
    public int levensduur = 300;
    public Aardbei() 
    {
        aardbei = new GreenfootImage("aardbei_transparant.png");
        aardbeif1 = new GreenfootImage("aardbei_transparant 1.png");
        aardbeif2 = new GreenfootImage("aardbei_transparant 2.png");
        // Add your action code here.
    }  
    public void act()
    {
        if ( getOneIntersectingObject(Fly.class) != null )
        {
            
            Fly fly = (Fly) getOneIntersectingObject(Fly.class);
            fly.stop();
        if (timer(levensduur) == 50)
            fly.start();
        }
        getWorld().removeObject(this);
    }
    
}
