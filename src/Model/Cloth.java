package Model;

public class Cloth extends Item {

    public Cloth(int x, int y)
    {
        super.size = 2;
        super.setX(x);
        super.setY(y);
        super.setType("cloth");
    }

    public int getSize()
    {
        return size;
    }
}
