import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    public GreenfootImage map;
    int speed = 8;
    
    public void act() {
        
    }    
    
    public boolean atColor(String colorToLookFor) {
        
        Color currentColor = map.getColorAt(this.getX(), this.getY());
        
        speed = 8;
        
        int red = currentColor.getRed();
        int green = currentColor.getGreen();
        int blue = currentColor.getBlue();
        if (colorToLookFor == "gray") {
            return (red == 128 && green == 128 && blue == 128);
        } else {
            return false;
        }
        
    }
}
