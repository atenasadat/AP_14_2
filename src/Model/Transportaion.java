package Model;

import java.util.ArrayList;

public abstract class Transportaion
{
    protected int MAXCAPACITY;
    protected int timeTravel;
    protected int currentCapacity;
    protected boolean isTravelling;
    protected int UpgradeMoney;
    User user=User.getUser();


    public abstract void Travel( ArrayList<Wild> cageanimal,ArrayList<Item> warehousearrayList,int Count,String itemname);
    public abstract void nextturn(int n);

}
