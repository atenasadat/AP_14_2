package Controller;

import Model.EggToFlour;
import Model.Farm;
import Model.Map;
import Model.Warehouse;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Map map = new Map();

    public Map getMap() {
        return map;
    }

    public boolean addChicken()
    {
        if (map.getFarm().BuyAnimal("chicken"))
        {
            return true;
        }

        return false;
    }

    public void addCow() {

    }

    public void addSheep() {

    }
}
