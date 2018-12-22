package Model;

public class Cow extends Domestic{
    private final int COST=200;

    public Cow(int x, int y, String type) {
        super(x, y, type);
    }

    public int getCOST() {
        return COST;
    }
}
