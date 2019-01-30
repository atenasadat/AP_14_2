package Controller;

import Model.EggToFlour;
import Model.Farm;
import Model.Map;
import Model.Warehouse;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller
{
    Map map = new Map();

    public Map getMap() {
        return map;
    }

    public boolean addChicken()
    {
        if(map.getFarm().BuyAnimal("chicken"))
        {
            return true;
        }

          return false;
    }

    public boolean addCow()
    {
        if(map.getFarm().BuyAnimal("cow"))
        {
            return true;
        }
             return false;
    }

    public boolean addSheep()
    {
        if(map.getFarm().BuyAnimal("sheep"))
        {
            return true;
        }
        return false;
    }


    public boolean FillWell()
    {
        if (map.getWell().Fill()){
            return true;
        }
        return false;
    }

///newly added

    public  boolean addworkshop(String name)
    {
        if(map.addworkshop(name))
            return true;
        return false;
    }

}
