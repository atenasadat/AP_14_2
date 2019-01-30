package Model;

import java.util.ArrayList;

public class Farm {
    ArrayList<Animal> animalArrayList = new ArrayList<>();
    ArrayList<Item> itemArrayList = new ArrayList<>();
    ArrayList<Wild> cageanimal=new ArrayList<>();
    ArrayList<Grass> grassArrayList=new ArrayList<>();
    User user=User.getUser();
    Animal animal;
    Item item;
    Wild wild;
    private  int WIDTH=20;
    private int HEIGHT=20;

    public ArrayList<Animal> getAnimalArrayList() {
        return animalArrayList;
    }

    public void setAnimalArrayList(ArrayList<Animal> animalArrayList) {
        this.animalArrayList = animalArrayList;
    }



    public int getWIDTH() {
        return WIDTH;
    }
    public int getHEIGHT() {
        return HEIGHT;
    }

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


    public boolean BuyAnimal(String Type)
    {
        if (Type.equals("chicken"))
        {
//            for (int i = 0; i < animalArrayList.size() ; i++)
//            {
//                System.out.println("arraylist elements" + animalArrayList.get(i));
//
//            }

            if(user.DecreaseMoney(new Chicken(500,500,"chicken").getCOST()))
            {
                animalArrayList.add(new Chicken(500, 500, "chicken"));

                System.out.println("chiiickeen---animalaraylist.size is:"+animalArrayList.size());
                return true;
            }
        }

        else if (Type.equals("sheep"))
        {
            if(user.DecreaseMoney(new Sheep(500,500,"sheep").getCOST())) {
                animalArrayList.add(new Sheep(500, 500, "sheep"));
                return true;
            }
        }
        else if (Type.equals("cow"))
        {

            if(user.DecreaseMoney(new Cow(500,500,"cow").getCOST()))
            {
                animalArrayList.add(new Cow(500, 500, "cow"));

                System.out.println("cowwww-------animalaraylist.size="+animalArrayList.size());
                System.out.println("add cow");

                return true;
            }
        }

////*&*&*&*&*&*&(*&*&*&TEST


        return false;
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
        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);
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
        grassArrayList.add(new Grass(X,Y));
    }
    public void CatUpgrade()
    {
        for (int i = 0; i < animalArrayList.size(); i++) {
            if (animalArrayList.get(i) instanceof Cat)
            {
                Cat cat=(Cat)animalArrayList.get(i);
               if(user.DecreaseMoney(cat.getUpgradeMoney()));
                cat.Upgrade();
            }
        }
    }

    public void wildNextTurn(int n)
    {
        int rand =(int) Math.random() % 2;

        int temp = n/wild.getTimeAppear();
       if(n >= wild.getTimeAppear())
       {
           for (int i = 0; i <temp ; i++)
           {
               int x_rand = (int) Math.random() % 10 + 10 ;
               int y_rand = (int) Math.random() % 10 + 10;
               if(rand == 0)
               {
                   animalArrayList.add(new Lion(x_rand , y_rand , "lion"));
               }

               if(rand == 1)
               {
                   animalArrayList.add(new Bear(x_rand, y_rand, "bear"));
               }
               n -= wild.getTimeAppear();

           }
       }
       if(n < wild.getTimeAppear())
       {
           wild.setTimeAppear(wild.getTimeAppear() - n);
       }
       if( wild.getTimeAppear() == 0)
           wild.setTimeAppear(wild.getMAXTIMEAPPEAR());




    }




    public boolean hasItem()
    {
        return (!itemArrayList.isEmpty());
    }
}