package Model;

import java.util.ArrayList;

public class Warehouse
{

    private int MAXCAPACITY = 100;
    private int currentcapacityleft = 0;
   private ArrayList <Item> warehouseItems = new ArrayList<>();

    public ArrayList<Item> getWarehouseItems() {
        return warehouseItems;
    }

    public void setWarehouseItems(ArrayList<Item> warehouseItems) {
        this.warehouseItems = warehouseItems;
    }

    public void Upgrade()
    {
        if(MAXCAPACITY+20<160)
        {
            MAXCAPACITY+=20;
        }
        else
        {
            System.out.println("not possible");
        }
    }

    public void AddItem(ArrayList<String> type)
    {




        for (int i = 0; i <type.size() ; i++)
        {
            //TODO X,Y
            if(type.get(i).equals("egg"))
            {
                if(currentcapacityleft + 2 < MAXCAPACITY ) {
                    warehouseItems.add(new Egg(0, 0));
                    currentcapacityleft += 2;
                }
            }
            else if (type.get(i).equals("flour"))
            {
                if(currentcapacityleft + 2  < MAXCAPACITY )
                warehouseItems.add(new Flour(0,0));
                currentcapacityleft += 2;

            }
            else if (type.get(i).equals("dress"))
            {
                if(currentcapacityleft+ 2 < MAXCAPACITY )
                warehouseItems.add(new Dress(0,0));
                currentcapacityleft += 2;

            }
            else if (type.get(i).equals("cloth"))
            {
                if(currentcapacityleft+ 2 < MAXCAPACITY )
                warehouseItems.add(new Cloth(0,0));
                currentcapacityleft += 2;

            }
            else if (type.get(i).equals("fiber"))
            {
                if(currentcapacityleft+ 2 < MAXCAPACITY )
                warehouseItems.add(new Fiber(0,0));
                currentcapacityleft += 2;

            }
            else if (type.get(i).equals("bread"))
            {
                if(currentcapacityleft+ 2 < MAXCAPACITY )
                warehouseItems.add(new Cookie(0,0));
                currentcapacityleft += 2;

            }
            else if(type.get(i).equals("cotton"))
            {
                if(currentcapacityleft+ 2 < MAXCAPACITY )
                warehouseItems.add(new Cotton(0,0));
                currentcapacityleft += 2;

            }
        }

    }
}

