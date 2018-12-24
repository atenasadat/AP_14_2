package Model;

import java.util.ArrayList;

public class Chicken extends Domestic
{
    private final int COST=100;
    private int produceTime=5;
    private int hungrytime = 5;
    private int ishungry=0;

    private final int MAXHEALTH = 5;

    public int getHungrytime() {
        return hungrytime;
    }

    public void setHungrytime(int hungrytime) {
        this.hungrytime = hungrytime;
    }

    public int getIshungry() {
        return ishungry;
    }

    public void setIshungry(int ishungry) {
        this.ishungry = ishungry;
    }

    public int getMAXHEALTH() {
        return MAXHEALTH;
    }

    public Chicken(int x, int y, String type) {
        super(x, y, type);
    }


    public int getCOST() {
        return COST;
    }

    public void produceEgg(ArrayList<Item> farmitem)
    {

        farmitem.add(new Egg(X,Y));
    }

    public void NextTurn(int n, ArrayList<Item> farmitem)
    {
        int temp =n ;

        int t = (n / produceTime);
        if(n>=produceTime)
        {
            for (int i = 0; i < t; i++)
            {
                produceEgg(farmitem);
                n -= produceTime;
            }
        }
        if(n < produceTime)
        {
            produceTime -= n;

        }
        if(produceTime ==0)
            produceTime = 5;


        for (int i = 0; i < temp ; i++)
        {
            Move();
        }



    }
    public void Move()
    {
        //TODO LIKE MOD
        int random=FindRandom();

        if (random == 0)
            Y+=1;
        else if (random ==1)
            X+=1;
        else if (random==2)
            Y-=1;
        else if (random==3)
            X-=1;
    }

    public void smartmove(ArrayList<Item> farmitem)
    {



    }
    public void checkhungry(int n)
    {
        int temp =n ;

        int t = (n / hungrytime);
        if(n>=hungrytime)
        {
            for (int i = 0; i < t; i++)
            {
                ishungry = 1;
                smartmove();
                n -= hungrytime;
            }
        }
        if(n < hungrytime)
        {
            hungrytime -= n;

        }
        if(hungrytime ==0)
            hungrytime = 5;
    }
}
