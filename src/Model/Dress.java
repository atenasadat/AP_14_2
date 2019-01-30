package Model;

public class Dress extends Item
{

    public Dress(int x, int y)
    {
        super.size =2;
        super.cost=25;
        super.setX(x);
        super.setY(y);
        super.setType("dress");
    }

    public int getSize()
    {
        return size;
    }
}
