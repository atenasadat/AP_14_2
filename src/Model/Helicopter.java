package Model;

import java.util.ArrayList;

public class Helicopter extends Transportaion {
    ArrayList<Item> items=new ArrayList<>();
    ArrayList<Animal>helicoptercageanimal=new ArrayList<>();
    public Helicopter() {
        MAXCAPACITY=100;
        currentCapacity=0;
        UpgradeMoney=100;
    }


    @Override
    public void Travel (ArrayList<Wild> cageanimal, ArrayList<Item> warehousearrayList, int Count, String itemname) {
        for (int i = warehousearrayList.size()-1; i >=0 ; i--)
        {
            if(warehousearrayList.get(i).getType().equals(itemname)){
                if(super.currentCapacity + warehousearrayList.get(i).getSize()  <  super.MAXCAPACITY)
                {
                    items.add(warehousearrayList.get(i));
                    warehousearrayList.remove(i);
                    super.currentCapacity = super.currentCapacity + warehousearrayList.get(i).getSize();

                }
            }
        }
        for (int i = cageanimal.size() - 1; i >=0 ; i--)
        {

            if (warehousearrayList.get(i).getType().equals(itemname)){
                if (cageanimal.get(i) instanceof Lion){
                    if (currentCapacity+((Lion) cageanimal.get(i)).getCagesize()<MAXCAPACITY){
                        helicoptercageanimal.add(cageanimal.get(i));
                        cageanimal.remove(i);
                        currentCapacity = currentCapacity + ((Lion) cageanimal.get(i)).getCagesize();
                    }
                }
            }

        }
    }

    @Override
    public void Nextturn(int n)
    {
        if(isTravelling)
        {
            if (n >= timeTravel)
            {
                items.clear();
                n -= timeTravel;
                isTravelling=false;
                doneTraveling=true;
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





    public void Clear(ArrayList<Item> mapitems){
        for (int i = items.size()-1; i >=0 ; i--) {
            mapitems.add(items.get(i));
            items.remove(i);
        }
        currentCapacity=0;
    }

    public void Go()
    {
        isTravelling=true;
        for (int i = items.size() - 1; i >= 0; i--)
        {
            user.IncreaseMoney(items.get(i).getCost());
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
