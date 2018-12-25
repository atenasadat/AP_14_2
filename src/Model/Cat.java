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
        for (int i = 0; i < n; i++) {
            if (level == 0) {
                Move(farm.getWIDTH(),farm.getHEIGHT());
                getItem(farm.itemArrayList,warehouse);
            } else {
                SmartMove(farm.itemArrayList);
                getItem(farm.itemArrayList,warehouse);
            }
        }
    }


    public void Move(int WIDTH,int HEIGHT) {
        //TODO LIKE MOD
        int random = FindRandom();
        if (random == 0) {
            if (Y + 1 <= HEIGHT)
                Y++;
            else
                Y--;

        } else if (random == 1) {
            if (X + 1 <= WIDTH)
                X += 1;
            else
                X--;
        } else if (random == 2) {
            if (Y - 1 >= 0)
                Y -= 1;
            else
                Y++;

        } else if (random == 3)
        {
            if(X-1>= 0)
            X -= 1;
            else
            X++;
        }
    }
    public void SmartMove(ArrayList<Item> farmitem) {


    }

    public void getItem(ArrayList<Item> farmitem,Warehouse warehouse) {
        ArrayList<String> itemadded=new ArrayList<>();
        for (int i = farmitem.size()-1; i >=0 ; i--) {
            if (X==farmitem.get(i).getX() && Y== farmitem.get(i).getY()){
                if(warehouse.getCurrentcapacityleft()+farmitem.get(i).getSize()<=warehouse.getMAXCAPACITY()){
                    itemadded.add(farmitem.get(i).getType());
                    farmitem.remove(i);
                }
            }
        }
        warehouse.AddItem(itemadded);
    }
}
