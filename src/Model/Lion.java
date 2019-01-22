package Model;

public class Lion extends Wild {
    public Lion(int x, int y, String type) {
        super(x, y, type);
        super.cageSize=20;
    }

    public int getCagesize() {
        return cageSize;
    }

    public void setCagesize(int cagesize) {
        this.cageSize = cagesize;
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
