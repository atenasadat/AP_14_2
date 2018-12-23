package Model;

import java.util.ArrayList;

public class Farm {
    ArrayList<Animal> animalArrayList = new ArrayList<>();

   private ArrayList<Item> itemArrayList = new ArrayList<>();

    ArrayList<Wild> cageanimal=new ArrayList<>();

    ArrayList<Grass> grassArrayList=new ArrayList<>();

    User user=User.getUser();

    Animal animal;

    Item item;

    public void setCageanimal(ArrayList<Wild> cageanimal) {
        this.cageanimal = cageanimal;
    }

    public ArrayList<Wild> getCageanimal() {
        return cageanimal;
    }

    ArrayList<String> temptype = new ArrayList<>();

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    public void BuyAnimal(String Type) {
        if (Type.equals("chicken")) {

            AnimallDecreaseMoney(new Chicken(5,5,"chicken").getCOST());
            animalArrayList.add(new Chicken(5,5,"chicken"));
        }
        else if (Type.equals("sheep")) {
            AnimallDecreaseMoney(new Sheep(5,5,"sheep").getCOST());
            animalArrayList.add(new Sheep(5,5,"sheep"));
        }
        else if (Type.equals("cow")) {
            AnimallDecreaseMoney(new Cow(5,5,"sheep").getCOST());
            animalArrayList.add(new Cow(5,5,"sheep"));
        }
    }

    public ArrayList<String> PickUp(String x, String y) {
        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);
        for (int i = itemArrayList.size()-1; i >= 0; i--)
        {
            if (itemArrayList.get(i).getX() == X && itemArrayList.get(i).getY() == Y) {
                temptype.add(itemArrayList.get(i).getType());
                itemArrayList.remove(i);
            }
        }
        for (int i = cageanimal.size()-1; i >=0 ; i--) {
            temptype.add(cageanimal.get(i).getType());
            cageanimal.remove(i);
        }
        return temptype;
    }
    public void Cage(String x,String y){
        int X=Integer.parseInt(x);
        int Y=Integer.parseInt(y);
        for (int i = animalArrayList.size()-1; i >=0; i--) {
            if (animalArrayList.get(i) instanceof Lion || animalArrayList.get(i) instanceof Bear) {
                if (animalArrayList.get(i).getX() == X && animalArrayList.get(i).getY() == Y) {
                    cageanimal.add((Wild)animalArrayList.get(i));
                    animalArrayList.remove(i);
                }
            }
        }
    }
    public void AnimallDecreaseMoney(int cost)
    {
        if(user.getMoney()>=cost)
        {
            user.setMoney(user.getMoney()-cost);

        }
        else
        {
            //System.out.printLn("no enough Money");
        }
    }
    public void Plant(String x,String y){
        int X=Integer.parseInt(x);
        int Y=Integer.parseInt(y);
        grassArrayList.add(new Grass(5));
    }
    public void CatUpgrade(){
        for (int i = 0; i < animalArrayList.size(); i++) {
            if (animalArrayList.get(i) instanceof Cat)
            {
                Cat cat=(Cat)animalArrayList.get(i);
                cat.Upgrade();
            }
        }
    }
    public void NextTurn(int nexttime)
   {

    }
}