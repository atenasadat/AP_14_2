package Controller;

import Model.EggToFlour;
import Model.Farm;
import Model.Map;
import Model.Warehouse;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller
{
    Map map=new Map(new Farm(),new Warehouse());
    public void CommandAnalyzer(String input[])
    {
        if(input[0].equals("buy")){

            map.getFarm().BuyAnimal(input[1]);
        }
        else if(input[0].equals("pickup"))
        {
            ArrayList<String> temptype=map.getFarm().PickUp(input[1], input[2]);
            map.getWarehouse().AddItem(temptype);

        }
        else if(input[0].equals("cage")){
            map.getFarm().Cage(input[1], input[2]);
        }
        else if (input[0].equals("well")){

            map.DecreaseMoney(map.getWell().getWATERINGCOST());
            map.getWell().Fill();
        }

        else if( input[0].equals("start"))
        {
            map.startworkshop(input[1]);

        }
        else if (input[0].equals("plant")){
            map.Plant(input[1], input[2]);
        }
        else if(input[0].equals("upgrade"))
        {
            if (input[1].equals("eggtoflour")){
             map.getEggToFlour().Upgrade(map.getEggToFlour().getLevel());
            }
            else if (input[1].equals("flourfobread"))
            {
                map.getEggToFlour().Upgrade(map.getEggToFlour().getLevel());
            }
            else if (input[1].equals("bakecake"))
            {
                map.getBakeCake().Upgrade(map.getBakeCake().getLevel());
            }
            else if (input[1].equals("fibertocloth"))
            {
                map.getFiberToCloth().Upgrade(map.getFiberToCloth().getLevel());
            }
            else if (input[1].equals("clothtodress"))
            {
                map.getClothToDress().Upgrade(map.getClothToDress().getLevel());
            }
            else if (input[1].equals("cottontofiber"))
            {
                map.getCottonToFiber().Upgrade(map.getCottonToFiber().getLevel());
            }
            else if (input[1].equals("warehouse"))
            {
                map.getWarehouse().Upgrade();
            }
            else if (input[1].equals("cat"))
            {
                map.getFarm().CatUpgrade();
            }
            else if (input[1].equals("well"))
            {
                map. WellUpgrade();
            }
            else if (input[1].equals("truck")){
                map.getTruck().Upgrade();
            }
            else if (input[1].equals("helicopter")){
                map.getHelicopter().Upgrade();
            }
        }
        else if(input[0].equals("turn"))
        {
            map.NextTurn(input[1]);


        }


        else if (input[1].equals("clear") && input[0].equals("truck")){
            map.TruckClear();
        }
        else if (input[1].equals("clear") && input[0].equals("helicopter")){
            map.HelicopterClear();
        }


        else if (input[1].equals("add") && input[0].equals("truck"))
        {
            map.TruckAdd(input[2],input[3]);
        }
        else if (input[1].equals("add") && input[0].equals("helicopter"))
        {
            map.HElicopterAdd(input[2],input[3]);
        }


        else if (input[1].equals("go") && input[0].equals("helicopter")){
            map.getHelicopter().Go();
        }
        else if (input[1].equals("go") && input[0].equals("truck")){
            map.getTruck().Go();
        }
    }
}
