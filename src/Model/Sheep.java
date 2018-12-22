package Model;

public class Sheep extends Domestic {
    public Sheep(int x, int y, String type) {
        super(x, y, type);
    }

    private final int COST=150;

    public int getCOST() {
        return COST;
    }
}
