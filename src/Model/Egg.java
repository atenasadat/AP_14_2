package Model;

public class Egg extends Item
{
    public Egg(int x, int y) {
        super.size =2;
        super.cost=10;
        super.setX(x);
        super.setY(y);
        super.setType("egg");
    }


        public int getSize()
        {
            return size;
        }
}
