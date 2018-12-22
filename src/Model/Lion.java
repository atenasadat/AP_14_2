package Model;

public class Lion extends Wild {
    private int cagesize=20;

    public int getCagesize() {
        return cagesize;
    }

    public void setCagesize(int cagesize) {
        this.cagesize = cagesize;
    }

    public Lion(int x, int y, String type, boolean ISatcage, int timeincage, String type1) {
        super(x, y, type, ISatcage, timeincage, type1);
    }
}
