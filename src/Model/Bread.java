package Model;

public class Bread extends Item{
    public Bread(int x , int y) {
        super.size = 2;
        super.cost = 15;
        super.setX(x);
        super.setY(y);
        super.setType("bread");

    }

    public int getSize()
    {
        return size;
    }
}
