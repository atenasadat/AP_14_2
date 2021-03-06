package Model;

import java.util.ArrayList;

public class EggToFlour extends Workshop{
    private  final int x = 0;
    private final int y = 2;
    private int level;
    private int MAXLEVEL =3;
    private int producetime ;
    private boolean isstarted;
    private int tempneed;
    private int cost = 100;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int getMAXLEVEL() {
        return MAXLEVEL;
    }

    public void setMAXLEVEL(int MAXLEVEL) {
        this.MAXLEVEL = MAXLEVEL;
    }

    public boolean isIsstarted() {
        return isstarted;
    }

    public void setIsstarted(boolean isstarted) {
        this.isstarted = isstarted;
    }

    public int getTempneed() {
        return tempneed;
    }

    public void setTempneed(int tempneed) {
        this.tempneed = tempneed;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getProducetime() {
        return producetime;
    }

    public void setProducetime(int producetime) {
        this.producetime = producetime;
    }

    public int getLevel() {
        return level;
    }

    public EggToFlour(int level)
    {
        this.level = level;

    }

    public void produce(ArrayList<Item> warehouseitems , ArrayList<Item> farmitem)
    {
        int counter=0;
        for (int i = 0; i <warehouseitems.size() ; i++)
        {
            if(warehouseitems.get(i).getType().equals("egg"))
            {
                counter++;
            }
        }

        tempneed=  numberofneeded(level , counter);

        for (int i = warehouseitems.size(); i >=0 ; i--)
        {
            if(tempneed>0)
            {
                if (warehouseitems.get(i) instanceof Egg)
                {
                    warehouseitems.remove(i);
                    tempneed--;
                }
            }


        }
        producetime=10;

        isstarted=true;

    }
    ////// newly added//////
    public boolean canproduce(ArrayList<Item> warehouseitems)
    {
        int cnt=0;
        for (int i = 0; i <warehouseitems.size() ; i++)
        {
            if(warehouseitems.get(i) instanceof Egg)

                cnt++;

        }
        if(cnt ==0)
            return false;
        else
            return true;

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
           System.out.printf("NOT POSSIBLE!!!");

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
             System.out.println("no enough money");
            return false;

        }
    }


    public void NextTurn(int n,ArrayList<Item> warehouseitem , ArrayList<Item> farmitem)
    {   if (isstarted)
    {
        if (n > getProducetime())
        {
            for (int i = 0; i < tempneed; i++)
            {
                //TODO Generating Random X and Y
                farmitem.add(new Flour(x + 4, y - 8));
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
