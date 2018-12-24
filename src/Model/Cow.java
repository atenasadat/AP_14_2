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


    public void NextTurn(int n)
    {
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
