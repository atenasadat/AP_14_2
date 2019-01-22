package Model;

public class Flour extends Item {

    public int getSize()
    {
        return size;
    }

    public Flour(int x , int y)
    {
        super.size = 2;
        super.setX(x);
        super.setY(y);


    }


}
