package Model;

import java.util.ArrayList;

public class Warehouse
{
   private ArrayList <Item> warehouseItems=new ArrayList<>();

    public ArrayList<Item> getWarehouseItems() {
        return warehouseItems;
    }

    public void setWarehouseItems(ArrayList<Item> warehouseItems) {
        this.warehouseItems = warehouseItems;
    }

    public void AddItem(ArrayList<String>type)
    {
        for (int i = 0; i <type.size() ; i++)
        {
            //TODO X,Y
            if(type.get(i).equals("egg"))
            {
                warehouseItems.add(new Egg(0,0));
            }
            else if (type.get(i).equals("flour"))
            {
                warehouseItems.add(new Flour(0,0));
            }
            else if (type.get(i).equals("dress"))
            {
                warehouseItems.add(new Dress(0,0));
            }
            else if (type.get(i).equals("cloth"))
            {
                warehouseItems.add(new Cloth(0,0));
            }
            else if (type.get(i).equals("fiber"))
            {
                warehouseItems.add(new Fiber(0,0));
            }
            else if (type.get(i).equals("bread"))
            {
                warehouseItems.add(new Cookie(0,0));
            }
            else if(type.get(i).equals("cotton"))
            {
                warehouseItems.add(new Cotton(0,0));
            }
        }

    }






}

