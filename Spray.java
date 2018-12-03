import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Spray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spray extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    public int Timer = 0;
    public Spray()
    {
        image1 = new GreenfootImage("Spray_idle.png");
        image1.scale(111,76);
        image2 = new GreenfootImage("Spray_stage1.png");
        image2.scale(111,76);
        image3 = new GreenfootImage("Spray_stage2.png");
        image3.scale(111,76);
        setImage(image1);
    }
    /**
     * Act - do whatever the Spray wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Timer++;    
        sprayTime();
        if (Timer > 10*MyWorld.lvl+500)
        {
            exterminateFly();
        }
    }   
    /**
     * Set images to generate a spraying motion which kills the flies.
     * 
     */
        public void sprayTime(){
        if (Timer == 10*MyWorld.lvl+500)
        {
            Greenfoot.playSound("Spray.mp3");
            setImage(image2);
        }
        if (Timer == 10*MyWorld.lvl+530)
        {
            setImage(image3);
        }
        if (Timer == 10*MyWorld.lvl+830)
        {
            setImage(image1);
            Timer = 0;
        }
}
    /**
     * Exterminates the fly when the fly touches to spray.
     */
       public void exterminateFly(){
        if (isTouching(Fly.class))
        {
            removeTouching(Fly.class);
            MyWorld.Score++;
            MyWorld.FlyCountDisplay = MyWorld.FlyCountDisplay - 1;
        }
}
}


