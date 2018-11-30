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
    int speed = 8; // + MyWorld.lvl*3 (telt het level maal 3 op bij de snelheid van de vlieg)

    final int RECHTERMUUR = 1078;
    final int BOVENMUUR = 33;
    final int ONDERMUUR = 575;

    public void act() {

        checkWindows();
        move(speed);
        if (atWorldsEnd()) {
            setRotation(Greenfoot.getRandomNumber(360));
        } else if (atColor(Colors.GRAY_WALL)) {
            int currentRotation = getRotation();
            int randomAngle = Greenfoot.getRandomNumber(180);
            setRotation(currentRotation + randomAngle);

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

    // Vragen aan mevr. Brouns wat hier de beste werkwijze is
    public void checkWindows() {

        int additionalAngle = Greenfoot.getRandomNumber(180);

        // FIXME: opkuisen  

        if (getX() > RECHTERMUUR) {
            setRotation(90 + additionalAngle);
        }
        if (getY() < BOVENMUUR) {
            setRotation(additionalAngle);
        } 
        if (getY() > ONDERMUUR) {
            setRotation(-additionalAngle);
        }
        if (getX()<120 && getY()>120)
        {
            //Stuk onder raam vermijden 
            setRotation(-additionalAngle);
        }
        if (getX()<135 && getY()>120 && getY()<674)
        {
            //Niet voorbij de linkermuur
            setRotation(90 -additionalAngle);
        }
        if (getX()>138 && getX()<652 && getY()>255 && getY()<265)
        {
            //Niet voorbij het bovenste stuk van de middelste muur 
            //in het huis
            setRotation(-additionalAngle);
        }
        if (getX()>138 && getX()<652 && getY()>265 && getY()<285)
        {
            //Niet voorbij het onderste stuk van de middelste muur 
            //in het huis
            setRotation(additionalAngle);
        }
        if (getX()>651 && getX()<652 && getY()>255 && getY()<275)
        {
            //Niet voorbij het rechtse stuk van de middelste muur 
            //in het huis
            setRotation(90-additionalAngle);
        }
    }

    public boolean atColor(Colors colorToLookFor) {

        Color currentColor = map.getColorAt(this.getX(), this.getY());

        speed = 8;

        int red = currentColor.getRed();
        int green = currentColor.getGreen();
        int blue = currentColor.getBlue();

        switch (colorToLookFor) {
            case GRAY_WALL:
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
    GRAY_WALL,
    // possible other colors for detecting fruit in the future

    BlUE,
    RED,
    YELLOW,
    GREEN,

}

