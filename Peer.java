import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Appel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Peer extends Fruit
{
    /**
     * Act - do whatever the Appel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage peer;
    private GreenfootImage peerf1;
    private GreenfootImage peerf2;
    public int Timer = 0;
    public Peer() 
    {
        peer = new GreenfootImage("peer_transparant.png");
        peer.scale(112,90);
        peerf1 = new GreenfootImage("peer_transparant 1.png");
        peerf1.scale(112,90);
        peerf2 = new GreenfootImage("peer_transparant 2.png");
        peerf2.scale(112,90);
        setImage (peer);
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
                setImage (peer);
            }
            if (Timer == 400)
            {
                setImage (peerf1);
            }
            if (Timer == 600)
            {
                setImage (peerf2);
            }
            if (Timer == 650)
            {
                getWorld().removeObject(this);
            }
        }
    }   
}
