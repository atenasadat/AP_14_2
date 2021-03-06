package Model;

import java.util.ArrayList;

public abstract class Domestic extends Animal
{
    protected boolean ishungry;
    protected boolean goToGrass;
    protected boolean death;
    protected int produceTime;
    protected int hungrytime;
    protected int deathTime;
    private int randomCount=0;
    int random = FindRandom();


    public abstract void NextTurn(int n, Farm farm, Warehouse warehouse,ArrayList<Grass> grass) ;
    public Domestic(int x, int y, String type) {
        super(x, y, type);
    }


        public void Move(int WIDTH,int HEIGHT)
        {

            if(randomCount==10)
            {
                random = FindRandom();
                randomCount=0;
            }


           if (random == 0)
           {
                if (Y + 10 <= HEIGHT)
                    Y = Y + 10;
                else
                    Y= Y - 10;

            }
           else if (random == 1)
            {
                if (X + 10 <= WIDTH)
                    X += 10;
                else
                    X -= 10;
            }
           else if (random == 2)
            {
                if (Y - 10 >= 220)
                    Y-=10;
                else
                    Y+=10;

            }
           else if (random == 3) {
                if (X - 10 >= 220)
                    X -= 10;
                else
                    X+=10;
           }
           randomCount++;

        }

    public void MoveTograss(int[] X_Y)
    {
        int x=X_Y[0];
        int y=X_Y[1];
        if (X == x && y < Y)
        {
            Y--;
        }
        if (X == x && y > Y)
        {
            Y++;
        }
        if (Y==y && x<X)
        {
            X--;
        }
        if (Y==y && x>X)
        {
            X++;
        }
        if (x> X && y>Y)
        {
            X++;
            Y++;
        }
        if (x> X && y<Y)
        {
            X++;
            Y--;
        }
        if (x< X && y<Y)
        {
            X--;
            Y--;
        }
        if (x<X && y>Y)
        {
            X--;
            Y++;
        }
    }

    public int[] minDistanceToGrass(ArrayList<Grass> grass)
    {

        double min=2500;
        int[] X_Ymin=new int[2];
        X_Ymin[0] =-1; //-1=null
        X_Ymin[1]=-1; //-1=null
        if(grass.isEmpty()==false)
        {
            for (int i = grass.size() - 1; i >= 0; i--) {

                double distance = Math.pow(X - grass.get(i).getX(), 2) + Math.pow(Y - grass.get(i).getY(), 2);
                if (distance < min) {
                    min = distance;
                    X_Ymin[0] = grass.get(i).getX();
                    X_Ymin[1] = grass.get(i).getY();
                }

            }
            return X_Ymin;
        }

        return X_Ymin;


    }

    public boolean Eat(ArrayList<Grass> grass)
    {

        for (int i = grass.size()-1; i >= 0; i--)
        {

            if (X == grass.get(i).getX() && Y == grass.get(i).getY())
            {
                grass.remove(i);
                return true;

            }

        }
        return false;
    }


}
