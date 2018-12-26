package Model;

import java.util.ArrayList;

public class Sheep extends Domestic {
    @Override
    public void NextTurn(int n, Farm farm, Warehouse warehouse) {
        if(n>=produceTime)
        {
            produceFiber(farm.getItemArrayList());
            produceTime=n;
        }
        else
        {
            produceTime-=n;
        }
        for (int i = 0; i < n; i++) {
            Move(farm.getWIDTH(),farm.getHEIGHT());
        }
    }

    public Sheep(int x, int y, String type) {
        super(x, y, type);
    }

    private final int COST=150;
    private int produceTime=5;

    public int getCOST() {
        return COST;
    }

    public void produceFiber(ArrayList<Item> farmitem)
    {
        farmitem.add(new Fiber(X,Y));
    }

    public void Move(int WIDTH,int HEIGHT) {
        //TODO LIKE MOD
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
                Y --;
            else
                Y++;

        } else if (random == 3) {
            if (X - 1 >= 0)
                X -= 1;
            else
                X++;
        }
    }
}
