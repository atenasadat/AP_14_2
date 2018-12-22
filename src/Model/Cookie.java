package Model;

public class Cookie extends Item
{
    private final int size=2;

    public Cookie(int x , int y) {
        super.size =2;
        super.setX(x);
        super.setY(y);
        super.setType("cookie");

    }

    public int getSize()
    {
        return size;
    }
}
