package Model;

public abstract class Wild extends Animal{
    public Wild(int x, int y, String type, boolean ISatcage) {
        super(x, y, type);
        this.ISatcage = ISatcage;
        this.timeincage = timeincage;
    }



    private boolean ISatcage;
    private int timeincage;
    private String type;
    private int timeAppear = 10;
    private boolean isAppear;
    private  final int MAXTIMEAPPEAR = 10;

    public int getMAXTIMEAPPEAR() {
        return MAXTIMEAPPEAR;
    }

    public int getTimeAppear()
    {
        return timeAppear;
    }

    public void setTimeAppear(int timeAppear)
    {
        this.timeAppear = timeAppear;
    }

    public boolean isAppear()
    {
        return isAppear;
    }

    public void setAppear(boolean appear)
    {
        isAppear = appear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTimeincage() {
        return timeincage;
    }

    public void setTimeincage(int timeincage) {
        this.timeincage = timeincage;
    }

    public boolean isISatcage() {
        return ISatcage;
    }

    public void setISatcage(boolean ISatcage) {
        this.ISatcage = ISatcage;
    }
    public abstract void NextTurn(int n , Farm farm , Warehouse warehouse);

}
