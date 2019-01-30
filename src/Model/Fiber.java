package Model;

public class Fiber extends Item
{



    public Fiber(int x , int y)
    {
        super.size =2;
        super.cost=15;
        super.setX(x);
        super.setY(y);
        cost = 25;
        setType("fiber");


    }

    public int getSize()
    {
        return size;
    }
}
