package Model;

import java.util.ArrayList;

public class Animal
{
    private int X;
    private int Y;
    private String Type;
    public Animal(int x, int y, String type) {
        X = x;
        Y = y;
        Type = type;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setY(int y) {
        Y = y;
    }
}