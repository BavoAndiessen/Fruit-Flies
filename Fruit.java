import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fruit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fruit extends Actor
{
    /**
     * Act - do whatever the Fruit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int timer = 0;
    
    public void act() 
    {
        timer++;
    }  
    public int timer(int levensduur)
    {
      if (timer == levensduur-200)
        { 
            return levensduur-200;
        }
      if (timer == levensduur-100)
        {
            return levensduur-100;
        }
      if (timer == levensduur)
        {
            return levensduur;
        }
      return 0;
    }
}
