package Model;

import java.util.ArrayList;

public class BakeCake extends Workshop {

    private   int x=0;
    private  int y=2;
    private int level;
    private int MAXLEVEL =3;
    private int producetime ;
    private boolean isstarted;
    private int tempneed;

    public int getProducetime() {
        return producetime;
    }

    public void setProducetime(int producetime) {
        this.producetime = producetime;
    }

    public BakeCake(int level) {
        this.level = level;
    }

    @Override
    public  void produce(ArrayList<Item> warehouseitems, ArrayList<Item> farmitem) {
        int counter1 =0;
        int counter2 =0;
        for (int i = 0; i <warehouseitems.size() ; i++)
        {
            if(warehouseitems.get(i).getType().equals("cookie"))
            {
                counter1++;
            }

            if(warehouseitems.get(i).getType().equals("egg"))
            {
                counter2++;

            }
        }
        int tempneed1 = numberofneeded(level , counter1);
        int tempneed2=numberofneeded(level,counter2);
        int tempMin= Math.min(tempneed1,tempneed2);
        tempneed1=tempMin;
        tempneed2=tempMin;

        for(int i=warehouseitems.size()-1;i>=0;i--)
        {
            if (tempneed1 > 0)
            {

                if (warehouseitems.get(i) instanceof Cookie)
                {
                    warehouseitems.remove(i);
                    tempneed1--;
                }
            }
            if (tempneed2 > 0)
            {
                if (warehouseitems.get(i) instanceof Egg)
                {
                    warehouseitems.remove(i);
                    tempneed2--;
                }
            }
        }
    }

    @Override
    public void Upgrade(int level) {
        if( level ==0 )
        {
            if (DecreaseMoney(super.level0upgrade))
            level = level - MAXLEVEL >= 0 ? (level++) : level;
        }

        else if(level == 1)
        {

            if (DecreaseMoney(super.level1Upgrade))
            level = level - MAXLEVEL >= 0 ? (level++) : level;
        }
        else if(level == 2)
        {

            if (DecreaseMoney(super.level2Upgrade))
            level = level - MAXLEVEL >= 0 ? (level++) : level;

        }   else if(level == 3)
        {
            ///TODO IN VIEW  System.out.printf("NOT POSSIBLE!!!");

        }
    }
    public boolean DecreaseMoney(int money)
    {
        if(user.getMoney()>money)
        {
            user.setMoney(user.getMoney()-money);
            return true;
        }
        else
        {
            //TODO IN VIEW System.out.println("no enough money");
            return false;

        }
    }

    public int numberofneeded(int level , int counter)
    {
        int numberofitemsneeded = counter-level>=0 ? level: counter;

        return numberofitemsneeded;
    }


    public void NextTurn(int n,ArrayList<Item> warehouseitem , ArrayList<Item> farmitem)
    {   if (isstarted)
    {
        if (n > getProducetime())
        {
            for (int i = 0; i < tempneed; i++)
            {
                //TODO Generating Random X and Y
                farmitem.add(new Cake(x + 4, y - 8));
            }
            producetime=10;
        }
        else
        {
            producetime -= n;
        }
    }
        isstarted=false;
    }



}
