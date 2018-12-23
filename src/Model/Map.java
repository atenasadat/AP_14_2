package Model;

import java.util.ArrayList;

public class Map {
    private Farm farm;
    private Warehouse warehouse;
    private EggToFlour eggToFlour=new EggToFlour(0);
    private FlourToBread flourToBread=new FlourToBread(0);
    private BakeCake bakeCake=new BakeCake(0);
    private CottonToFiber cottonToFiber=new CottonToFiber(0);
    private FiberToCloth fiberToCloth=new FiberToCloth(0);
    private ClothToDress clothToDress = new ClothToDress(0);
    private Well well=new Well(5);
    private User user=User.getUser();
    private Helicopter helicopter=new Helicopter();
    private Truck truck=new Truck();

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

    public Map(Farm farm, Warehouse warehouse) {
        this.farm = farm;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public void DecreaseMoney(int cost)
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


    public void startworkshop(String workshop_name)
    {
        if(workshop_name.equals("ٍEggytoFlour"))
            eggToFlour.produce(warehouse.getWarehouseItems() , farm.getItemArrayList());
        if(workshop_name.equals("FlourToBread"))
            eggToFlour.produce(warehouse.getWarehouseItems() , farm.getItemArrayList());

      //TODO others...





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
            well.Upgrade();
            DecreaseMoney(50);
        }
        else
            System.out.println("not possible");
    }
    public void TruckClear(){
        truck.CLear(getWarehouse().getWarehouseItems());
    }
    public void HelicopterClear(){

        helicopter.Clear((farm.getItemArrayList()));
    }
    public void NextTurn(String n)
    {
        int nexttime = Integer.parseInt(n);

        eggToFlour.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());
        flourToBread.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());
//        bakeCake.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());
//        cottonToFiber.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());
//        fiberToCloth.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());
//        clothToDress.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());
//        farm.NextTurn(nexttime,warehouse.getWarehouseItems(),farm.getItemArrayList());
    }
}
