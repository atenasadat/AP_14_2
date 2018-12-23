package Model;

import java.util.ArrayList;

public class Cat extends Animal {
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Cat(int x, int y, String type) {
        super(x, y, type);

    }
    public void Upgrade(){
        if (level==1)
            System.out.println("not possible");
        else
            level=1;
    }
    public void NextTurn(ArrayList<Item> farmitem,ArrayList<Item> warehouseitem){
        if (level==0){
            Move();
            getItem(farmitem,warehouseitem);
        }
        else {
            SmartMove(farmitem);
        }
    }

    public void Move(){
        //TODO LIKE MOD
        int random=FindRandom();
        if (random==0)
            Y+=1;
        else if (random==1)
            X+=1;
        else if (random==2)
            Y-=1;
        else if (random==3)
            X-=1;
        return;
    }
    public void SmartMove(ArrayList<Item> farmitem){



    }
    public void getItem(ArrayList<Item> farmitem,ArrayList<Item> warehouseitem)
    {
      for(int i=farmitem.size()-1;i>=0;i--)
      {
          if(farmitem.get(i).getX()==X && farmitem.get(i).getY()==Y)
          {
              String itemName=farmitem.get(i).getType();
              farmitem.remove(i);
              if(itemName.equals("egg"))
                warehouseitem.add(new Egg(1,2));
              else if(itemName.equals("fiber"))
                  warehouseitem.add(new Fiber(1,2));





          }
      }
    }

}
