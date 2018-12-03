import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Scorebord extends Actor
{
    private GreenfootImage scorebord;
    
    public void act() 
    {
        scorebord = new GreenfootImage("scorebord.jpg");
        setImage(scorebord);
        
        getWorld().showText(Integer.toString(MyWorld.EindScore), 610, 277);
        getWorld().showText(Integer.toString(MyWorld.lvl), 610, 312);
        
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().removeObject(this);
        }
    }    
}
