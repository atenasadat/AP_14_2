package Model;

import java.util.ArrayList;

public class Chicken extends Domestic
{
    private final int COST=100;
    private int produceTime=5;
    private int hungrytime = 5;
    private boolean ishungry;
    private final int MAXHEALTH = 5;

    public int getHungrytime() {
        return hungrytime;
    }

    public void setHungrytime(int hungrytime) {
        this.hungrytime = hungrytime;
    }

    public boolean isIshungry() {
        return ishungry;
    }

    public void setIshungry(boolean ishungry) {
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

    public void NextTurn(int n, Farm farm,Warehouse warehouse)
    {

        for (int i = 0; i < n ; i++)
        {
            if (!ishungry)
                Move();
            else {
                SmartMove(farm.itemArrayList);
                Eat(farm.itemArrayList);
            }
            produceTime--;
            checkhungry(n);
            if (produceTime==0)
            {
                produceEgg(farm.itemArrayList);
                produceTime=5;
            }
        }

    }
    public void Move()
    {
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

    public int[] SmartMove(ArrayList<Item> farmitem)
    {
        //TODO BFS
        double min=2500;
        int[] X_Ymin=new int[2];
        for(int i=farmitem.size()-1;i>=0;i--)
        {
            if(farmitem.get(i).getType().equals("grass"))
            {
                double distance=Math.pow(X-farmitem.get(i).getX(),2)+Math.pow(Y-farmitem.get(i).getY(),2);
                if(distance<min)
                {
                    min=distance;
                     X_Ymin[0]=farmitem.get(i).getX();
                     X_Ymin[1]=farmitem.get(i).getY();
                }
            }
        }
        return X_Ymin;
    }

    ///
    ////
    ////

    public void Eat(ArrayList<Item> farmitem)
    {

        for (int i = farmitem.size()-1; i >= 0; i--)
        {
            if (farmitem.get(i).getType().equals("grass"))
            {
                if (X == farmitem.get(i).getX() && Y == farmitem.get(i).getY())
                {
                    farmitem.remove(i);
                }
            }
        }
    }
    public void checkhungry(int n)
    {
        if (hungrytime==0){
            ishungry=true;
        }
        else
            hungrytime--;
    }
}
