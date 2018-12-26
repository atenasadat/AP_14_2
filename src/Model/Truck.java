package Model;

import java.util.ArrayList;

public class Truck extends Transportaion{
    ArrayList<Item> items=new ArrayList<>();

    public Truck() {
        MAXCAPACITY=50;
        currentCapacity=0;
        UpgradeMoney=50;
        timeTravel=10;
    }

    @Override
    public void Travel(ArrayList<Wild> cageanimal,ArrayList<Item> warehouseitem,int Count,String itemname) {
        for (int i = warehouseitem.size()-1; i >=0 ; i--) {
            if (warehouseitem.get(i).getType().equals(itemname)){
                if(currentCapacity + warehouseitem.get(i).getSize()  < MAXCAPACITY)
                {
                   items.add(warehouseitem.get(i));
                    warehouseitem.remove(i);
                   currentCapacity = currentCapacity + warehouseitem.get(i).getSize();
                }
            }
        }
    }
    public void CLear(ArrayList<Item> warehouseitems)
    {
        for (int i = items.size()-1; i >=0 ; i--)
        {
            warehouseitems.add(items.get(i));
            items.remove(i);
        }
        currentCapacity=0;
    }

    public void Go()
    {
        isTravelling=true;
    }

    public void nextturn(int n)
    {
        if(isTravelling)
        {
            if (n >= timeTravel)
            {
                for (int i = items.size() - 1; i >= 0; i--)
                {
                    user.IncreaseMoney(items.get(i).getCost());
                }
                items.clear();
                n -= timeTravel;
                isTravelling=false;

            }
            if (n < timeTravel)
            {
                timeTravel -= n;
            }
            if (n == 0)
            {
                timeTravel = 10;

            }
        }


    }

    public void Upgrade()
    {
        if(user.DecreaseMoney(UpgradeMoney))
        {
            if (MAXCAPACITY + 10 <= 100)
                MAXCAPACITY += 10;
            else
                System.out.println("not possible");
        }
    }
}
