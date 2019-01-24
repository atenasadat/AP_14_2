package Model;

import java.util.ArrayList;

public class Map {

    private Farm farm=new Farm();
    private Warehouse warehouse=new Warehouse();
    private EggToFlour eggToFlour=new EggToFlour(0);
    private FlourToBread flourToBread=new FlourToBread(0);
    private BakeCake bakeCake=new BakeCake(0);
    private CottonToFiber cottonToFiber=new CottonToFiber(0);
    private FiberToCloth fiberToCloth=new FiberToCloth(0);
    private ClothToDress clothToDress = new ClothToDress(0);
    private Well well=new Well(0);
    private User user=User.getUser();
    private Helicopter helicopter=new Helicopter();
    private Truck truck=new Truck();
    private int WIDTH=30;
    private int HEIGHT=30;

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public FlourToBread getFlourToBread() {
        return flourToBread;
    }

    public void setFlourToBread(FlourToBread flourToBread) {
        this.flourToBread = flourToBread;
    }

    public BakeCake getBakeCake() {
        return bakeCake;
    }

    public void setBakeCake(BakeCake bakeCake) {
        this.bakeCake = bakeCake;
    }

    public CottonToFiber getCottonToFiber() {
        return cottonToFiber;
    }

    public void setCottonToFiber(CottonToFiber cottonToFiber) {
        this.cottonToFiber = cottonToFiber;
    }

    public FiberToCloth getFiberToCloth() {
        return fiberToCloth;
    }

    public void setFiberToCloth(FiberToCloth fiberToCloth) {
        this.fiberToCloth = fiberToCloth;
    }

    public ClothToDress getClothToDress() {
        return clothToDress;
    }

    public void setClothToDress(ClothToDress clothToDress) {
        this.clothToDress = clothToDress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Helicopter getHelicopter() {
        return helicopter;
    }

    public void setHelicopter(Helicopter helicopter) {
        this.helicopter = helicopter;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public EggToFlour getEggToFlour() {
        return eggToFlour;
    }

    public void setEggToFlour(EggToFlour eggToFlour) {
        this.eggToFlour = eggToFlour;
    }

    public Well getWell() {
        return well;
    }

    public void setWell(Well well) {
        this.well = well;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }


    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }


    public void startworkshop(String workshop_name)
    {
        if(workshop_name.equals("ٍEggyToFlour"))
            eggToFlour.produce(warehouse.getWarehouseItems() , farm.getItemArrayList());
        if(workshop_name.equals("FlourToBread"))
            flourToBread.produce(warehouse.getWarehouseItems() , farm.getItemArrayList());
        if(workshop_name.equals("CottonToFiber"))
           cottonToFiber.produce(warehouse.getWarehouseItems() , farm.getItemArrayList());
        if(workshop_name.equals("ClothToDress"))
            clothToDress.produce(warehouse.getWarehouseItems() , farm.getItemArrayList());
        if(workshop_name.equals("FiberToClothes"))
            fiberToCloth.produce(warehouse.getWarehouseItems() , farm.getItemArrayList());
        if(workshop_name.equals("BakeCake"))
            bakeCake.produce(warehouse.getWarehouseItems() , farm.getItemArrayList());

    }
    public void Plant(String x,String y){

        if (well.getCapacity()>0){
            well.setCapacity(well.getCapacity()-1);
            farm.Plant(x,y);
        }
    }
    public void TruckAdd(String itemname,String count){
        int Count=Integer.parseInt(count);
        truck.Travel(farm.getCageanimal() ,warehouse.getWarehouseItems(),Count,itemname);

    }
    public void HElicopterAdd(String itemname,String count){
        int Count=Integer.parseInt(count);
        helicopter.Travel(farm.getCageanimal(), warehouse.getWarehouseItems(),Count,itemname);

    }
    public void WellUpgrade()
    {
        if (well.getMAXCAPACITY()<8)
        {

            if(user.DecreaseMoney(well.getUpgradeCost()))
            well.Upgrade();

        }
        else
            System.out.println("not possible");
    }
    public void TruckClear(){
        truck.Clear(getWarehouse().getWarehouseItems());
    }
    public void HelicopterClear(){

        helicopter.Clear((farm.getItemArrayList()));
    }
    public void NextTurn(String n)
    {
        int nexttime = Integer.parseInt(n);

        eggToFlour.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());

        flourToBread.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());

        bakeCake.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());

        cottonToFiber.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());

        fiberToCloth.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());

        clothToDress.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());

        farm.wildNextTurn(nexttime);

        for (int i = getFarm().animalArrayList.size()-1; i >=0  ; i--)
        {
            if (getFarm().animalArrayList.get(i) instanceof  Domestic)
            {
                Domestic domestic=(Domestic)getFarm().animalArrayList.get(i);
                domestic.NextTurn( nexttime, farm,  warehouse,farm.grassArrayList) ;
            }


            if (getFarm().animalArrayList.get(i) instanceof  Chicken)
            {
                Chicken chicken=(Chicken)getFarm().animalArrayList.get(i);

                if (chicken.death)
                    getFarm().animalArrayList.remove(i);
            }

            if (getFarm().animalArrayList.get(i) instanceof  Sheep)
            {
                Sheep sheep=(Sheep)getFarm().animalArrayList.get(i);

                if (sheep.death)
                    getFarm().animalArrayList.remove(i);
            }


            if (getFarm().animalArrayList.get(i) instanceof  Wild)
            {
                Wild wild=(Wild)getFarm().animalArrayList.get(i);
                wild.NextTurn(nexttime,farm);
            }



            if (getFarm().animalArrayList.get(i) instanceof  Dog)
            {
                Dog dog=(Dog)getFarm().animalArrayList.get(i);

                if (dog.isIsdead())
                    getFarm().animalArrayList.remove(i);
            }

            if (getFarm().animalArrayList.get(i) instanceof  Cat)
            {
                Cat cat=(Cat)getFarm().animalArrayList.get(i);
                cat.NextTurn(nexttime,farm,warehouse);
            }
            if (getFarm().animalArrayList.get(i) instanceof  Dog)
            {
                Dog dog=(Dog)getFarm().animalArrayList.get(i);
                dog.NextTurn(nexttime,farm,warehouse);

            }
        }
   }


}
