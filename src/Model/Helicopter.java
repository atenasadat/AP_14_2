package Model;

import java.util.ArrayList;

public class Helicopter extends Transportaion {
    ArrayList<Item> items=new ArrayList<>();
    public Helicopter() {
        super.MAXCAPACITY=100;
        super.currentCapacity=0;
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

            if(cageanimal.get(i).getType().equals(itemname))
            {
               //if (super.currentCapacity )

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
    public void Go(){

    }
    public void Upgrade(){
        if(MAXCAPACITY+10<=100)
            MAXCAPACITY+=10;
        else
            System.out.println("not possible");

    }
}
