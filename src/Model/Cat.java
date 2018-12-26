package Model;

import java.util.ArrayList;

public class Cat extends Animal {
    private int level;
    private final int upgradeMoney=50;

    public int getUpgradeMoney() {
        return upgradeMoney;
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Cat(int x, int y, String type) {
        super(x, y, type);

    }

    public void Upgrade() {
        if (level == 1)
            System.out.println("not possible");
        else
            level = 1;
    }

    public void NextTurn(int n,Farm farm,Warehouse warehouse) {
        for (int i = 0; i < n; i++)
        {
            if (farm.hasItem())
            {
                if (level == 0)
                {
                    int X_Y[]=FindRandItem(farm.getItemArrayList());
                    Move(farm.getWIDTH(), farm.getHEIGHT(), X_Y);
                    getItem(farm.itemArrayList, warehouse,X_Y);
                }
                else
                {
                    int[] X_Y=MinDistance(farm.getItemArrayList());
                    Move(farm.getWIDTH(), farm.getHEIGHT(), X_Y);
                    getItem(farm.itemArrayList, warehouse,X_Y);
                }
            }
        }
    }


    public void Move(int WIDTH,int HEIGHT,int[] X_Y)
    {
        int x=X_Y[0];
        int y=X_Y[1];
        if (X == x && y < Y)
        {
            Y--;
        }
        if (X == x && y > Y)
        {
            Y++;
        }
        if (Y==y && x<X)
        {
            X--;
        }
        if (Y==y && x>X)
        {
            X++;
        }
        if (x> X && y>Y)
        {
            X++;
            Y++;
        }
        if (x> X && y<Y)
        {
            X++;
            Y--;
        }
        if (x< X && y<Y)
        {
            X--;
            Y--;
        }
        if (x<X && y>Y)
        {
            X--;
            Y++;
        }
    }

    public void getItem(ArrayList<Item> farmitem,Warehouse warehouse, int[] X_Y)
    {
        ArrayList<String> itemadded=new ArrayList<>();
        for (int i = farmitem.size()-1; i >=0 ; i--)
        {
            if (X_Y[0] == farmitem.get(i).getX() && X_Y[1] == farmitem.get(i).getY())
            {
                if(warehouse.getCurrentcapacityleft()+farmitem.get(i).getSize()<=warehouse.getMAXCAPACITY())
                {
                    itemadded.add(farmitem.get(i).getType());
                    farmitem.remove(i);
                }
            }
        }
        warehouse.AddItem(itemadded);
    }

    public int[] MinDistance(ArrayList<Item> farmitem)
    {

        double min=2500;
        int[] X_Ymin=new int[2];
        for(int i=farmitem.size()-1;i>=0;i--)
        {
            if(farmitem.get(i).getType().equals("grass"))
            {
                double distance=Math.pow(X-farmitem.get(i).getX(),2)+Math.pow(Y-farmitem.get(i).getY(),2);
                if(distance<min)
                {
                    min=distance;
                    X_Ymin[0]=farmitem.get(i).getX();
                    X_Ymin[1]=farmitem.get(i).getY();
                }
            }
        }
        return X_Ymin;
    }

    public int[] FindRandItem(ArrayList<Item> farmitem)
    {
        int[] X_Y=new int[2];
        int indexOfItem= (int) (Math.random()%farmitem.size());
        for(int i=farmitem.size()-1;i>=0;i--)
        {
            if(indexOfItem==i)
            {
                X_Y[0]=farmitem.get(i).getX();
                X_Y[1]=farmitem.get(i).getY();

            }
        }
        return X_Y;
    }
}
