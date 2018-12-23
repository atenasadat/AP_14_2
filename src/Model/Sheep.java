package Model;

import java.util.ArrayList;

public class Sheep extends Domestic {
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

    public void NextTurn(int n,ArrayList<Item> farmitem)
    {
        if(n>=produceTime)
        {
            produceFiber(farmitem);
            produceTime=n;
        }
        else
        {
            produceTime-=n;
        }
        for (int i = 0; i < n; i++) {
            Move();
        }
    }

    public void Move(){
        //TODO LIKE MOD
        int random=FindRandom();
        if (random==0)
            Y+=1;
        else if (random==1)
            X+=1;
        else if (random==2)
            Y-=1;
        else if (random==3)
            X-=1;
    }
}
