package Model;

public class Egg extends Item
{
    public Egg(int x, int y) {
        super.size =2;
        super.setX(x);
        super.setY(y);
        super.setType("egg");
    }

    private final int size=1;
        public int getSize()
        {
            return size;
        }
}
