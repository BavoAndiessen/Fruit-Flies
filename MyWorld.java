import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{  
    public int i = 0;
    
    public MyWorld()
    {    
        super(1159, 674, 1); 

        GreenfootImage grondplan = new GreenfootImage("grondplan.PNG");
        setBackground(grondplan); 

        act();
    }

    public void act()
        {      
          while (i <= 20)
            {

            	int kans = Greenfoot.getRandomNumber(10000);
            	int geslacht = Greenfoot.getRandomNumber(3);

            	if (kans < 20 && geslacht == 1)
            	{
            		Fly fly = new Fly(true);
                	addObject(fly,30,74);            
                	i++; 
            	}

            	if (kans < 20 && geslacht == 2)
            	{
            		Fly fly = new Fly(false);
                	addObject(fly,30,74);
                	i++; 
            	}
            	
                
            } 
        }
}
