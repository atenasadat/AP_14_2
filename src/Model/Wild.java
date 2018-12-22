package Model;

public class Wild extends Animal{
    public Wild(int x, int y, String type, boolean ISatcage, int timeincage, String type1) {
        super(x, y, type);
        this.ISatcage = ISatcage;
        this.timeincage = timeincage;
        this.type = type1;
    }



    private boolean ISatcage;
    private int timeincage;
    private String type;


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

}
