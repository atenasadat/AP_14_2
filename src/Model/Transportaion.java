package Model;

import java.util.ArrayList;

public abstract class Transportaion
{
    protected int MAXCAPACITY;
    protected int timeTravel;
    protected int currentCapacity;
    protected boolean isTravelling;
    protected int UpgradeMoney;
    protected boolean doneTraveling;
    User user=User.getUser();


    public abstract boolean Travel( ArrayList<Wild> cageanimal,ArrayList<Item> warehousearrayList,String itemname);
    public abstract void Nextturn(int n);



}
