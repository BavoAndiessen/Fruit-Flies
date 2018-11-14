import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{  
    public int FlyCount = 0;
    
    public MyWorld()
    {    
        super(1159, 674, 1); 

        GreenfootImage grondplan = new GreenfootImage("grondplan.PNG");
        setBackground(grondplan); 

        act();
    }

    public void act()
        { 
          int kans = Greenfoot.getRandomNumber(200);
          
          if (kans < 10 && FlyCount < 20)
          {
                int geslacht = Greenfoot.getRandomNumber(3);

                if (geslacht == 1)
                {
                    Fly fly = new Fly(true);
                    addObject(fly,30,74);
                    FlyCount++;
                }

                if (geslacht == 2)
                {
                    Fly fly = new Fly(false);
                    addObject(fly,30,74);
                    FlyCount++;
                }
            
            }
        }

}
