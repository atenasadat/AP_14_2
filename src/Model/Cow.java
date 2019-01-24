package Model;

import java.util.ArrayList;

public class Cow extends Domestic{
    private final int COST=200 ;


    public Cow(int x, int y, String type)
    {
        super(x, y, type);
    }


    public int getCOST()
    {
        return COST;
    }


    public void NextTurn(int n, Farm farm,Warehouse warehouse,ArrayList<Grass> grass)
    {
        for (int i = 0; i < n; i++)
        {
            Move(farm.getWIDTH(),farm.getHEIGHT());
        }
    }
}
