package Model;

import java.util.ArrayList;

public class Truck extends Transportaion{
    ArrayList<Item> items=new ArrayList<>();
    ArrayList<Animal> truckcagedanimal=new ArrayList<>();

    public Truck()
    {
        MAXCAPACITY=50;
        currentCapacity=0;
        UpgradeMoney=50;
        timeTravel=10;
        doneTraveling=false;
    }

    @Override
    public boolean Travel(ArrayList<Wild> cageanimal,ArrayList<Item> warehouseitem,String itemname)
    {

        boolean flag = false;
        for (int i = warehouseitem.size()-1; i >= 0; i--)
        {
            if (warehouseitem.get(i).getType().equals(itemname))
            {

                if(currentCapacity + warehouseitem.get(i).getSize()  < MAXCAPACITY)
                {
                    System.out.println("size of warehouseitems before"+ warehouseitem.size());
                    items.add(warehouseitem.get(i));
                    currentCapacity = currentCapacity + warehouseitem.get(i).getSize();
                    warehouseitem.remove(i);
                    System.out.println("size of warehouseitems after"+ warehouseitem.size());
                    return true;
                }
                else
                    System.out.println("truck in full!!");
            }
        }
        for (int i = cageanimal.size()-1; i >=0 ; i--)
        {
            if (warehouseitem.get(i).getType().equals(itemname))
            {
                if (cageanimal.get(i) instanceof Lion){
                    if (currentCapacity+((Lion) cageanimal.get(i)).getCagesize()<MAXCAPACITY){
                        truckcagedanimal.add(cageanimal.get(i));
                        cageanimal.remove(i);
                        currentCapacity = currentCapacity + ((Lion) cageanimal.get(i)).getCagesize();
                       return  true;
                    }
                }
            }


        }
        return false;
    }
    public void Clear(ArrayList<Item> warehouseitems)
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

    public void Nextturn(int n)
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
                doneTraveling=true;
                timeTravel=10;

            }
            else if (n < timeTravel)
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
