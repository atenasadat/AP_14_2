package Model;

public class Bear extends Wild {
    private int cagesize=30;


    public Bear(int x, int y, String type) {
        super(x, y, type);
        super.cageSize=20;
    }

    public int getCagesize() {
        return cagesize;
    }

    public void setCagesize(int cagesize) {
        this.cagesize = cagesize;
    }



    @Override
    public void NextTurn(int n,Farm farm)
    {

        for(int i=0;i<n;i++)
        {
            Move(farm.getWIDTH(),farm.getHEIGHT());
            kildDomestic(farm.animalArrayList);

        }

    }

}

