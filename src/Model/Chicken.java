package Model;

import java.util.ArrayList;

public class Chicken extends Domestic
{
    private final int COST=100;



    public Chicken(int x, int y, String type) {
        super(x, y, type);
        super.produceTime = 5;
        super.hungrytime = 4;
        super.deathTime = 5;
        super.ishungry=false;
        super.goToGrass=false;
        super.death=false;
    }


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


    public int getCOST() {
        return COST;
    }




    public void produceEgg(ArrayList<Item> farmitem)
    {

        farmitem.add(new Egg(X,Y));
    }

    public void NextTurn(int n, Farm farm,Warehouse warehouse,ArrayList<Grass> grass)
    {
        int x_yMin[]=new int[2];

        for (int i = 0; i < n ; i++)
        {
            if(hungrytime==0)
            {
                ishungry=true;
            }


            if (produceTime==0)
            {
                produceEgg(farm.itemArrayList);
                produceTime=5;
            }
            if(ishungry==true && goToGrass==false && death==false)
            {

                x_yMin=minDistanceToGrass(grass);
                if(x_yMin[0]!=-1 && x_yMin[1]!=-1)
                {
                    goToGrass = true;
                }

            }
            if ((!ishungry || (ishungry==true && goToGrass==false))&& death==false)
                Move(farm.getWIDTH(),farm.getHEIGHT());

            if(deathTime==0)
            {
                death=true;//       وقتی nextturn مرغ در farm صدا زده شد آن هاایی که مردند را از Array پاک می کنیم.
            }


            if(ishungry && goToGrass && death==false)
            {
                MoveTograss(x_yMin);

                if(Eat(grass))
                {
                    goToGrass=false;
                    ishungry=false;
                    hungrytime=5;
                }
            }
            if ( ishungry==true && goToGrass==false)
            {
                deathTime--;
            }
            hungrytime--;
            produceTime--;

        }

    }
}
