package Model;

public class Well {
    private int Capacity;
    private  int MAXCAPACITY;
    private final int WATERINGCOST=190;
    private final int UpgradeCost=50;


    public User getUser()
    {
        return user;
    }


    User user=User.getUser();

    public int getUpgradeCost() {
        return UpgradeCost;
    }

    private int Currenttime;

    public Well(int capacity)
    {

        Capacity = capacity;
        MAXCAPACITY=5;
    }

    public int getMAXCAPACITY() {
        return MAXCAPACITY;
    }

    public int getWATERINGCOST() {
        return WATERINGCOST;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getCurrenttime() {
        return Currenttime;
    }

    public void setCurrenttime(int currenttime) {
        Currenttime = currenttime;
    }

    public boolean Fill()
    {

        if(Capacity<MAXCAPACITY && user.DecreaseMoney(WATERINGCOST))
        {

            Capacity=MAXCAPACITY;
            System.out.println("capacity:"+Capacity);
            return true;
        }

        return false;

    }

    public void Upgrade()
    {
        MAXCAPACITY+=1;
    }



}
