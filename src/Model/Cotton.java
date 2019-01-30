package Model;

public class Cotton extends Item
{

    public Cotton(int x , int y) {
        super.size = 2;
        super.cost=10;
        super.setY(y);
        super.setX(x);
super.setType("cotton");

    }

    public int getSize()
    {
        return size;
    }
}
