package Model;

import java.util.ArrayList;

public class FlourToBread  extends Workshop{
    private  final int x=3;
    private final int y=3;
    private int level;
    private int MAXLEVEL =3;
    private int producetime=10;
    private int tempneed;
    private boolean isstarted;


    public FlourToBread(int level) {
        this.level = level;
    }

    @Override
    public void produce(ArrayList<Item> warehouseitems, ArrayList<Item> farmitem) {



    int counter=0;
        for (int i = 0; i <warehouseitems.size() ; i++)
    {
        if(warehouseitems.get(i).getType().equals("flour"))
        {
            counter++;
        }
    }

    tempneed=  numberofneeded(level , counter);

        for (int i = warehouseitems.size(); i >=0 ; i--)
    {
        if(tempneed>0)
        {
            if (warehouseitems.get(i) instanceof Flour)
            {
                warehouseitems.remove(i);
                tempneed--;
            }
        }
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
            if (DecreaseMoney(super.level0upgrade)) ;
            level = level - MAXLEVEL >= 0 ? (level++) : level;
        }

        else if(level == 1)
        {

            if (DecreaseMoney(super.level1Upgrade)) ;
            level = level - MAXLEVEL >= 0 ? (level++) : level;
        }
        else if(level == 2)
        {

            if (DecreaseMoney(super.level2Upgrade)) ;
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
    public void NextTurn(int n,ArrayList<Item> warehouseitem , ArrayList<Item> farmitem)
    {   if (isstarted) {
        if (n > producetime)
        {
            for (int i = 0; i <tempneed ; i++)
            {//TODO Generating Random X and Y
                farmitem.add(new Cookie( x , y-8 ));
            }
            producetime=10;
        }
        else
        {
            producetime-=n;
        }
    }
    else
        isstarted=false;
    }
}
