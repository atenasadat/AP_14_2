package Model;

public class Item {
    private String type;
    private int X;
    private int Y;
    protected int size;
    protected int cost;

    public int getCost() {
        return cost;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType()

    {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setY(int y) {
        Y = y;
    }
}
