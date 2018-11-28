import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Label extends Actor
{
    public Label(String text)
        {
            GreenfootImage kader = new GreenfootImage(text.length()*10, 20);
            kader.drawString(text, 10, 20);
            
            setImage(kader);
        }
        
    public void setText(String text)
    {
        GreenfootImage kader = getImage();
        kader.clear();
        kader.drawString(text, 10, 20);
    }
}
