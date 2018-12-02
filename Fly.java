import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Collections;

/**
 * Write a description of class Fly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Creature
{
    public boolean male;
    public boolean fertile = true;
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
        // small random movements
        int angle = Greenfoot.getRandomNumber(7);
        if (!eatingFruit()) {
            setRotation(getRotation() - 3 + angle);
        }

        if (fertile) {
            if (touchingFlyOfOtherGender()) {
                System.out.println("success");
                int genderOfNewBabyFly = Greenfoot.getRandomNumber(1);

                int numberOfBabyFlies = 0;
                while(numberOfBabyFlies < 8) {
                    if (genderOfNewBabyFly == 1) { 
                        getWorld().addObject(new Fly(true), getX(), getY());
                    } else {
                        getWorld().addObject(new Fly(false), getX(), getY());
                    }
                    numberOfBabyFlies++;
                }
                fertile = false;

            }
            
        }

    }   

    private boolean eatingFruit() {
        return (getOneIntersectingObject(Fruit.class) != null);
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
        int x = getX();
        int y = getY();

        if (x > RECHTERMUUR) {
            setRotation(90 + additionalAngle);
        } else if (y < BOVENMUUR) {
            setRotation(additionalAngle);
        } else if (y > ONDERMUUR) {
            setRotation(-additionalAngle);
        } else if ( x < 120 && y > 120) {
            //Stuk onder raam vermijden 
            setRotation(-additionalAngle);
        } else if (x < 135 && y > 120 && y < 674) {
            //Niet voorbij de linkermuur
            setRotation(90 -additionalAngle);
        } else if (x > 138 && x < 652 && y > 255 && y < 265) {
            //Niet voorbij het bovenste stuk van de middelste muur
            setRotation(-additionalAngle);
        } else if (x > 138 && x < 652 && y > 265 && y < 285) {
            //Niet voorbij het onderste stuk van de middelste muur
            setRotation(additionalAngle);
        } else if (x > 651 && x < 652 && y > 255 && y < 275) {
            //Niet voorbij het rechtse stuk van de middelste muur
            setRotation(90-additionalAngle);
        }
    }

    public boolean touchingFlyOfOtherGender() {
        Fly fly = (Fly) getOneIntersectingObject(Fly.class);

        boolean oppositeGender = !male;
        if (fly != null) {
            if (fly.eatingFruit() && fly.male != oppositeGender) {
                return true;
            }
        }

        return false;
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
