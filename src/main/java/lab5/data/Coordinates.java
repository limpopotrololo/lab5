package lab5.data;

import lab5.exeptions.*;

/**
 * Coordinates of SpaceMarine
 */
public class Coordinates {

    private Integer x; //can't be null
    private Integer y; //must be more -84 and can't be null

    public Coordinates(Integer x, Integer y) throws IncorrectData {
        setX(x);
        setY(y);
    }
    public Coordinates(){}

    /**
     *
     * @return x
     */
    public Integer getX() {
        return x;
    }

    /**
     *
     * @return y
     */
    public Integer getY() {
        return y;
    }

    /**
     * set x
     * @param x
     * @throws IncorrectData
     */
    public void setX(Integer x) throws IncorrectData {
        if (x == null) {
            throw new IncorrectData();
        }
        this.x = x;
    }

    /**
     * set y
     * @param y
     */
    public void setY(Integer y) {
        if ((y < -84) || (y == null)) {
            throw new IllegalArgumentException("Значение не подходит по ОДЗ");
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates: " + "\n" +
                "x = " + x + "\n" +
                "y = " + y;
    }
}
