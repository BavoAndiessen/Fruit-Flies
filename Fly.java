import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Creature
{
    boolean male;
    int speed = 8;
    
    public void act() {
        
        
        move(speed);
        if (atWorldsEnd()) {
            setRotation(Greenfoot.getRandomNumber(360));
        } else if (atColor(Colors.GRAY)) {
            int currentRotation = getRotation();
            int randomAngle = Greenfoot.getRandomNumber(180);
            setRotation(currentRotation + randomAngle);
            
        }
        
        checkWindows();
    }   
    
    
    
    
    public boolean atWorldsEnd() {
        if (getX() < 3 || getX() > getWorld().getWidth() - 3) {
            return true;
        }
        if (getY() < 3 || getY() > getWorld().getHeight() - 3) {
            return true;
        } else {
            return false;
        }
    }
    
    public Fly(boolean male) {
        
        map = new GreenfootImage("grondplan.PNG");
        setRotation(Greenfoot.getRandomNumber(360));
        
        // determine gender
        if (male) {
            setImage("maleFly25.png");
        } else {
            setImage("femaleFly35.png");
        }
    }
    
    public void checkWindows() {
        if (getX() > 1100) {
            setRotation(170 + Greenfoot.getRandomNumber(20));
        } else if (getX() > 1078) {
            setRotation(getRotation() + 90 + Greenfoot.getRandomNumber(180));
        }
        if (getY() < 33) {
            setRotation(80 + Greenfoot.getRandomNumber(20));
        }
    }
    
    public boolean atColor(Colors colorToLookFor) {
        
        Color currentColor = map.getColorAt(this.getX(), this.getY());
        
        speed = 8;
        
        int red = currentColor.getRed();
        int green = currentColor.getGreen();
        int blue = currentColor.getBlue();
        
        switch (colorToLookFor) {
           case GRAY:
                return (red == 128 && green == 128 && blue == 128);  
           default:
                return false;
                
        }

        
    }
    
    public void stop() {
        speed = 0;
    }
    
    public void start() {
        speed = 8;
    }
}



enum Colors {
    GRAY,
    // possible extra colors for detecting fruit:
    
    BlUE,
    RED,
    YELLOW,
    GREEN,
    
}

