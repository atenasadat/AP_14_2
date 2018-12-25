package Model;

import java.util.ArrayList;

public class Dog extends Animal
{

    private boolean isdead;

    public boolean isIsdead() {
        return isdead;
    }

    public void setIsdead(boolean isdead) {
        this.isdead = isdead;
    }

    public Dog(int x, int y, String type) {
        super(x, y, type);
    }



    public void NextTurn(int n, Farm farm,Warehouse warehouse)
    {
        for (int i = 0; i < n ; i++)
        {
        if(!findWildAnimal(farm.animalArrayList))
        {
            Move(farm.getWIDTH(), farm.getHEIGHT());

        }
        else
            {
            SmartMove(farm , farm.getWIDTH() , farm.getHEIGHT());

            AttackWild(farm);


        }
        }
     }

        public void AttackWild(Farm farm)
        {
            for (int i = farm.animalArrayList.size() ; i >= 0 ; i--)
            {
                if( X == farm.animalArrayList.get(i).getX() && Y == farm.animalArrayList.get(i).getY())
                {
                    farm.animalArrayList.remove(i);
                    setIsdead(true);
                }

            }

        }

    public void SmartMove(Farm farm ,int WIDTH , int HEIGHT)
    {
        findminpath(farm);
    }

    public void Move(int WIDTH,int HEIGHT) {
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
                Y -= 1;
            else
                Y++;

        } else if (random == 3)
        {
            if(X-1>= 0)
                X -= 1;
            else
                X++;
        }
    }

    public boolean findWildAnimal(ArrayList<Animal> farmAnimal)
    {

        for(int i=farmAnimal.size()-1;i>=0;i--)
        {
            if(farmAnimal.get(i) instanceof Wild)
            {
                    return true;
            }
        }
            return false;
    }

    public int[] findminpath(Farm farm)
    {
        double min=2500;
        int[] X_Ymin=new int[2];
        for(int i=farm.animalArrayList.size()-1;i>=0;i--)
        {
            if(farm.animalArrayList.get(i) instanceof Wild)
            {
                double distance=Math.pow(X-farm.animalArrayList.get(i).getX(),2)+Math.pow(Y-farm.animalArrayList.get(i).getY(),2);
                if(distance<min)
                {
                    min=distance;
                    X_Ymin[0]=farm.animalArrayList.get(i).getX();
                    X_Ymin[1]=farm.animalArrayList.get(i).getY();
                }
            }
        }
        return X_Ymin;
    }
}
