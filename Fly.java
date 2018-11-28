import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Actor
{
    boolean male;
    int speed = 8;
    private GreenfootImage map;
    public void act() {
        
        
        move(speed);
        if (atWorldsEnd()) {
            setRotation(Greenfoot.getRandomNumber(360));
        } else if (atWall()) {
            setRotation(Greenfoot.getRandomNumber(360));
            
        }
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
    
    public boolean atWall() {
        Color color = map.getColorAt(this.getX(), this.getY());
        
        speed = 8;
        
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        return (red == 128 && green == 128 && blue == 128);
    }
    
    public void stop(){
        speed = 0;
    }
    
    public void start() {
        speed = 8;
    }
}
