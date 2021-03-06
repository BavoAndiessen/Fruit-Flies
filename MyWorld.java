import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends World
{  
    public static int FlyCount = 0; //het is niet de bedoeling dat deze int verandert wanneer een vlieg dood gaat
    public static int FruitCount = 0;
    public static int FlyCountDisplay = 0;
    public static int lvl = 1;
    public static int Score = 0;
    private int timer = 8001;
    public static int EindScore;
    
    Label FlyDisplay = new Label("Aantal vliegen: 0");
    Label Scorebord = new Label("Dode vliegen: 0");
    Label Level = new Label("Level: 1");
    Label TimerDisplay = new Label("Time left: 0");
    
    public MyWorld()
    {    
        super(1159, 674, 1); 

        GreenfootImage grondplan = new GreenfootImage("grondplan.PNG");
        setBackground(grondplan); 
        
        addObject (FlyDisplay,500, 600);
        addObject (Scorebord,499, 620);
        addObject (Level, 502, 640);
        addObject (TimerDisplay, 503, 660);
        
        Vliegenmepper Vliegenmepper = new Vliegenmepper();
        addObject (Vliegenmepper, 100, 100);
        
        Spray Spray = new Spray();
        addObject(Spray, 930, 80);

        act();
    }

    public void act()
    { 

        timer--;

        
        if (timer == 0) 
        {
            Scorebord Scorebord = new Scorebord();
            addObject (Scorebord, getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
        SpawnVlieg();
        labels();
        spawnFruit();  
    }
        
    public void spawnFruit()
    {
        int kansNewFruit = Greenfoot.getRandomNumber(5000);
          
          if (kansNewFruit < 10 && FruitCount < 4)
          {
              int fruitsoort = Greenfoot.getRandomNumber(6);
              
                  int[] fruitSpawnX = {550, 440, 850, 920, 190, 1020, 190}; //vooraf bepaalde coördinaten van logische 'fruitplaatsen'
                  int[] fruitSpawnY = {230, 380, 500, 440, 350, 420, 120};

              switch (fruitsoort) {
                 case 1:
                    Aardbei Aardbei = new Aardbei();
                    addObject (Aardbei, fruitSpawnX[FruitCount], fruitSpawnY[FruitCount]);

                 case 2:
                    Appel Appel = new Appel();
                    addObject (Appel, fruitSpawnX[FruitCount], fruitSpawnY[FruitCount]);

                 case 3:
                    Banaan Banaan = new Banaan();
                    addObject (Banaan, fruitSpawnX[FruitCount], fruitSpawnY[FruitCount]);

                 case 4:
                    Kers Kers = new Kers();
                    addObject (Kers, fruitSpawnX[FruitCount], fruitSpawnY[FruitCount]);

                 case 5:
                    Peer Peer = new Peer();
                    addObject (Peer, fruitSpawnX[FruitCount], fruitSpawnY[FruitCount]);
              }
                            
              FruitCount++;
              
              //if statement voor elke fruitsoort net zoals bij de vliegen
          }
    }
        
    public void labels()
    {
        FlyDisplay.setText("Aantal vliegen: "+ FlyCountDisplay);
        Scorebord.setText("Dode vliegen: " + Score); //+ score vanuit Spray/mepper klasse
        Level.setText("Level: " + lvl);
        TimerDisplay.setText("Time Left: " + timer);
          
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
                    Fly fly = new Fly(true, true);
                    addObject(fly,30,74);
                    FlyCount++;
                    FlyCountDisplay++;
                }

                if (geslacht == 2)
                {
                    Fly fly = new Fly(false, true);
                    addObject(fly,30,74);
                    FlyCount++;
                    FlyCountDisplay++;
                }
            
            }
    }
}
