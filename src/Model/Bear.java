package Model;

public class Bear extends Wild {
    private int cagesize=30;

    public int getCagesize() {
        return cagesize;
    }

    public void setCagesize(int cagesize) {
        this.cagesize = cagesize;
    }

    public Bear(int x, int y, String type, boolean ISatcage) {
        super(x, y, type, ISatcage);
    }

    @Override
    public void NextTurn(int n) {

    }
}

