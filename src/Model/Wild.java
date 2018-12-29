package Model;

import java.util.ArrayList;

public abstract class Wild extends Animal{
    public Wild(int x, int y, String type ) {
        super(x, y, type);
        this.ISatcage = false;
        this.timeincage = 5;
        this.timeAppear=10;

    }



    protected boolean ISatcage;
    private int timeincage;
    private int timeAppear ;
    private boolean isAppear;
    private  final int MAXTIMEAPPEAR = 10;
    protected int cageSize;

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
    public abstract void NextTurn(int n ,Farm farm);


    public void Move(int WIDTH,int HEIGHT)
    {
        //TODO LIKE MOD
        int random = FindRandom();
        if (random == 0) {
            if (Y + 1 <= HEIGHT)
                Y++;
            else
                Y--;

        } else if (random == 1) {
            if (X + 1 <= WIDTH)
                X += 1;
            else
                X--;
        } else if (random == 2) {
            if (Y - 1 >= 0)
                Y--;
            else
                Y++;

        } else if (random == 3) {
            if (X - 1 >= 0)
                X -= 1;
            else
                X++;
        }

    }


    public boolean kildDomestic(ArrayList<Animal> animalArrayList)
    {

        for (int i = animalArrayList.size()-1; i >= 0; i--)
        {

            if (X == animalArrayList.get(i).getX() && Y == animalArrayList.get(i).getY())
            {
                animalArrayList.remove(i);
                return true;

            }

        }
        return false;
    }












}
