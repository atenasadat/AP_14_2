package Model;

import java.util.ArrayList;

public class CottonToFiber extends Workshop{

    private  int x=4;
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

    public CottonToFiber(int level) {
        this.level = level;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMAXLEVEL() {
        return MAXLEVEL;
    }

    public void setMAXLEVEL(int MAXLEVEL) {
        this.MAXLEVEL = MAXLEVEL;
    }

    @Override
    public void produce(ArrayList<Item> warehouseitems, ArrayList<Item> farmitem)
    {

        int counter=0;
        for (int i = 0; i <warehouseitems.size() ; i++)
        {
            if(warehouseitems.get(i).getType().equals("cotton"))
            {
                counter++;
            }
        }

        tempneed=  numberofneeded(level , counter);

        for (int i = warehouseitems.size(); i >=0 ; i--)
        {
            if(tempneed>0)
            {
                if (warehouseitems.get(i) instanceof Cotton)
                {
                    warehouseitems.remove(i);
                    tempneed--;
                }
            }
        }

        for (int i = 0; i <tempneed ; i++)
        {//TODO Generating Random X and Y
            farmitem.add(new Fiber( x+4 , y-8 ));

        }
    }
    public int numberofneeded(int level , int counter)
    {
        int numberofitemsneeded = counter-level>=0 ? level: counter;

        return numberofitemsneeded;
    }

    ////// newly added//////
    public boolean canproduce(ArrayList<Item> warehouseitems)
    {
        int cnt=0;
        for (int i = 0; i <warehouseitems.size() ; i++)
        {
            if(warehouseitems.get(i) instanceof Cotton)

                cnt++;

        }
        if(cnt ==0)
            return false;
        else
            return true;

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
                farmitem.add(new Fiber(x + 4, y - 8));
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
