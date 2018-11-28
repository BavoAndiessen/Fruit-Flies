import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{  
    public int FlyCount = 0; //het is niet de bedoeling dat deze int verandert wanneer een vlieg dood gaat
    public int FruitCount = 0;
    public int FlyCountDisplay = 0;
    public static int lvl = 1;
    public static int Score = 0;
    
    Label FlyDisplay = new Label("Aantal vliegen: 0");
    Label Scorebord = new Label("Score: 0");
    Label Level = new Label("Level: 1");
    Label FruitDisplay = new Label("Fruit: 0");
    
    public MyWorld()
    {    
        super(1159, 674, 1); 

        GreenfootImage grondplan = new GreenfootImage("grondplan.PNG");
        setBackground(grondplan); 
        
        addObject (FlyDisplay,500, 600);
        addObject (Scorebord,499, 620);
        addObject (Level, 502, 640);
        addObject (FruitDisplay, 503, 660);
        
        Vliegenmepper Vliegenmepper = new Vliegenmepper();
        addObject (Vliegenmepper, 100, 100);
        
        Spray Spray = new Spray();
        addObject(Spray, 930, 80);

        act();
    }

    public void act()
    { 
        SpawnVlieg();
        labels();
        spawnFruit();  
    }
        
    public void spawnFruit()
    {
        int kansNewFruit = Greenfoot.getRandomNumber(10000);
          
          if (kansNewFruit < 10 && FruitCount < 4)
          {
              int fruitsoort = Greenfoot.getRandomNumber(6);
              
              if (fruitsoort == 1)
              {
                  Aardbei Aardbei = new Aardbei();
                  addObject (Aardbei, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
              }
              
              if (fruitsoort == 2)
              {
                  Appel Appel = new Appel();
                  addObject (Appel, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
              }
              
              if (fruitsoort == 3)
              {
                  Banaan Banaan = new Banaan();
                  addObject (Banaan, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
              }
              
              if (fruitsoort == 4)
              {
                  Kers Kers = new Kers();
                  addObject (Kers, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
              }
              
              if (fruitsoort == 5)
              {
                  Peer Peer = new Peer();
                  addObject (Peer, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
              }
              
              FruitCount++;
              
              //if statement voor elke fruitsoort net zoals bij de vliegen
          }
    }
        
    public void labels()
    {
        FlyDisplay.setText("Aantal vliegen: "+ FlyCountDisplay);
        Scorebord.setText("Score: " + Score); //+ score vanuit Spray/mepper klasse
        Level.setText("Level: " + lvl);
        FruitDisplay.setText("Fruit: " + FruitCount);
        
        FlyCountDisplay = FlyCount - Score;
          
          if (Score == 20)
          {
              Score = 0;
              lvl++;
              FlyCount = 0;
          }
    }
        
    public void SpawnVlieg()
    {
        int kansNewFly = Greenfoot.getRandomNumber(1000);
          
          if (kansNewFly < 10 && FlyCount < 20)
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
