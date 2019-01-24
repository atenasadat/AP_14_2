package Model;

import java.util.ArrayList;

public class Warehouse
{

    private int MAXCAPACITY = 100;
    private int currentcapacityleft = 0;
    private final int MAXUPGRADE = 160;
    private final int UPGRADEAMOUNT = 20;
    private final int upgradeMoney = 200;
    private int x = 2;
    private int y = 2;
    User user=User.getUser();
    private ArrayList <Item> warehouseItems = new ArrayList<>();


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int getMAXCAPACITY() {
        return MAXCAPACITY;
    }

    public void setMAXCAPACITY(int MAXCAPACITY) {
        this.MAXCAPACITY = MAXCAPACITY;
    }

    public int getCurrentcapacityleft() {
        return currentcapacityleft;
    }

    public void setCurrentcapacityleft(int currentcapacityleft) {
        this.currentcapacityleft = currentcapacityleft;
    }

    public int getMAXUPGRADE() {
        return MAXUPGRADE;
    }

    public int getUPGRADEAMOUNT() {
        return UPGRADEAMOUNT;
    }

    public ArrayList<Item> getWarehouseItems() {
        return warehouseItems;
    }

    public void setWarehouseItems(ArrayList<Item> warehouseItems) {
        this.warehouseItems = warehouseItems;
    }

    public void Upgrade()
    {
        if(MAXCAPACITY + UPGRADEAMOUNT < MAXUPGRADE)
        {
           if(user.DecreaseMoney(upgradeMoney))
            MAXCAPACITY += UPGRADEAMOUNT;
        }
        else
        {
            System.out.println("not possible");
        }
    }

    public boolean AddItem(ArrayList<String> type)
    {
        for (int i = 0; i <type.size() ; i++)
        {
            if(type.get(i).equals("egg"))
            {
                if(currentcapacityleft + 2 < MAXCAPACITY )
                {
                    warehouseItems.add(new Egg(0, 0));
                    currentcapacityleft += 2;
                    return true;
                }
                else
                    System.out.println("warehouse is full!");
            }
            else if (type.get(i).equals("flour"))
            {
                if(currentcapacityleft + 2  < MAXCAPACITY ) {
                    warehouseItems.add(new Flour(0, 0));
                    currentcapacityleft += 2;
                    return true;

                }
                else
                    System.out.println("warehouse is full!");

            }
            else if (type.get(i).equals("dress"))
            {
                if(currentcapacityleft+ 2 < MAXCAPACITY ) {
                    warehouseItems.add(new Dress(0, 0));
                    currentcapacityleft += 2;
                    return true;


                }
                else
                    System.out.println("warehouse is full!");
            }
            else if (type.get(i).equals("cloth"))
            {
                if(currentcapacityleft+ 2 < MAXCAPACITY ) {
                    warehouseItems.add(new Cloth(0, 0));
                    currentcapacityleft += 2;
                    return true;

                }
                else
                    System.out.println("warehouse is full!");
            }
            else if (type.get(i).equals("fiber"))
            {
                if(currentcapacityleft+ 2 < MAXCAPACITY ) {
                    warehouseItems.add(new Fiber(0, 0));
                    currentcapacityleft += 2;
                    return true;

                }
                else
                    System.out.println("warehouse is full!");
            }
            else if (type.get(i).equals("bread"))
            {
                if(currentcapacityleft+ 2 < MAXCAPACITY ) {
                    warehouseItems.add(new Cookie(0, 0));
                    currentcapacityleft += 2;
                    return true;
                }
                else
                    System.out.println("warehouse is full!");
            }
            else if(type.get(i).equals("cotton"))
            {
                if(currentcapacityleft+ 2 < MAXCAPACITY ) {
                    warehouseItems.add(new Cotton(0, 0));
                    currentcapacityleft += 2;
                    return true;
                }
                else
                    System.out.println("warehouse is full!");
            }
        }
        return false;

    }
}

