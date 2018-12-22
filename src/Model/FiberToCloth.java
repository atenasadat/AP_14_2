package Model;

import java.util.ArrayList;

public class FiberToCloth  extends Workshop{

    private final int x = 48;
    private final  int y =48;
    private int level =0;
    private final int MAXLEVEL =3;

    public FiberToCloth(int level) {
        this.level = level;
    }

    @Override
    public void produce(ArrayList<Item> warehouseitems, ArrayList<Item> farmitem) {
        int counter=0;
        for (int i = 0; i <warehouseitems.size() ; i++)
        {
            if(warehouseitems.get(i).getType().equals("fiber"))
            {
                counter++;
            }
        }

        int tempneed=  numberofneeded(level , counter);

        for (int i = warehouseitems.size(); i >=0 ; i--)
        {
            if(tempneed>0)
            {
                if (warehouseitems.get(i) instanceof Fiber)
                {
                    warehouseitems.remove(i);
                    tempneed--;
                }
            }
        }

        for (int i = 0; i <tempneed ; i++)
        {//TODO Generating Random X and Y
            farmitem.add(new Cloth(x+4 , y-8 ));

        }


    }
    public int numberofneeded(int level , int counter)
    {
        int numberofitemsneeded = counter-level>=0 ? level: counter;

        return numberofitemsneeded;
    }

    @Override
    public void Upgrade(int level)
    {
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
}
