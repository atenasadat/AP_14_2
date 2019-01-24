package Model;

import java.util.ArrayList;

public class Sheep extends Domestic {


    private final int COST=150;

    public Sheep(int x, int y, String type) {
        super(x, y, type);
        super.produceTime = 5;
        super.hungrytime = 4;
        super.deathTime = 5;
        super.ishungry=false;
        super.goToGrass=false;
        super.death=false;
    }



    public int getCOST() {
        return COST;
    }

    public void produceFiber(ArrayList<Item> farmitem)
    {
        farmitem.add(new Fiber(X,Y));
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
                produceFiber(farm.itemArrayList);
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
                death=true;//       وقتی nextturn شیپ در farm صدا زده شد آن هاایی که مردند را از Array پاک می کنیم.
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
