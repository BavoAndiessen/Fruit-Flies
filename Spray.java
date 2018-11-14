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
        image2 = new GreenfootImage("Spray_stage1.png");
        image3 = new GreenfootImage("Spray_stage2.png");
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
    }   
    /**
     * Set images to generate a spraying motion which kills the flies.
     * 
     */
    public void sprayTime(){
        if (Timer == 500)
        {
            setImage(image2);
        }
        if (Timer == 530)
        {
            setImage(image3);
        }
        if (Timer == 830)
        {
            setImage(image1);
            Timer = 0;
        }
}
}


