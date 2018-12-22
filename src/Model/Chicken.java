package Model;

public class Chicken extends Domestic{
    private final int COST=100;

    public Chicken(int x, int y, String type) {
        super(x, y, type);
    }

    public int getCOST() {
        return COST;
    }
}
