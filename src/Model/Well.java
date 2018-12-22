package Model;

public class Well {
    private int Capacity;
    private  int MAXCAPACITY;
    private final int WATERINGCOST=190;
    private int Currenttime;

    public Well(int capacity) {
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

    public void Fill(){
        Capacity=MAXCAPACITY;
    }
    public void Upgrade()
    {
        MAXCAPACITY+=1;
    }



}
