package Model;

public class Bear extends Wild {
    private int cagesize=30;

    public int getCagesize() {
        return cagesize;
    }

    public void setCagesize(int cagesize) {
        this.cagesize = cagesize;
    }

    public Bear(int x, int y, String type, boolean ISatcage, int timeincage, String type1) {
        super(x, y, type, ISatcage, timeincage, type1);
    }
}
