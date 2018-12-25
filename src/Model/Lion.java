package Model;

public class Lion extends Wild {
    private int cagesize=20;
    private  final int timeincage = 5;
    public int getCagesize() {
        return cagesize;
    }

    public void setCagesize(int cagesize) {
        this.cagesize = cagesize;
    }

    public Lion(int x, int y, String type, boolean ISatcage) {
        super(x, y, type, ISatcage);
    }

    @Override
    public void NextTurn(int n, Farm farm, Warehouse warehouse)
    {


    }
}
