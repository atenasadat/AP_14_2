package Model;

import java.util.ArrayList;

public abstract class Transportaion
{
    protected int MAXCAPACITY=50;
    private int timeTravel=5;
    protected int currentCapacity=0;


    public abstract void Travel( ArrayList<Wild> cageanimal,ArrayList<Item> warehousearrayList,int Count,String itemname);

    }
