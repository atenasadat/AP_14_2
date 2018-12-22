package Model;

public class Dress extends Item
{
    private final int size=2;

    public Dress(int x, int y) {
        super.size =2;
        super.setX(x);
        super.setY(y);
        super.setType("dress");
    }

    public int getSize()
    {
        return size;
    }
}
