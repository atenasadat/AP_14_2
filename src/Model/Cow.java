package Model;

import java.util.ArrayList;

public class Cow extends Domestic{
    private final int COST=200;


    public Cow(int x, int y, String type) {
        super(x, y, type);
    }

    public int getCOST() {
        return COST;
    }


    public void NextTurn(int n, Farm farm,Warehouse warehouse,ArrayList<Grass> grass)
    {
        for (int i = 0; i < n; i++) {
            Move(farm.getWIDTH(),farm.getHEIGHT());
        }
    }


    public void Move(int WIDTH,int HEIGHT) {
        int random = FindRandom();
        if (random == 0) {
            if (Y + 1 <= HEIGHT)
                Y++;
            else
                Y--;

        } else if (random == 1) {
            if (X + 1 <= WIDTH)
                X += 1;
            else
                X--;
        } else if (random == 2) {
            if (Y - 1 >= 0)
                Y -= 1;
            else
                Y++;

        } else if (random == 3)
        {
            if(X-1>= 0)
                X -= 1;
            else
                X++;
        }
    }
}
