package Model;

public class User
{
    private int Money= 600;
    private static User user=new User();
    public static  User getUser()
    {
        return user;
    }
    public int getMoney()
    {
        return Money;
    }
    public void setMoney(int money)
    {
        Money = money;
    }
    public boolean DecreaseMoney(int cost)
    {
        if(Money >= cost)
        {
            Money = Money-cost;
            System.out.println("cost functipon");
            return true;

        }
        else
        {
            System.out.println("no enough Money");
            return false;
        }

    }

    public void IncreaseMoney(int cost)
    {

        Money=Money+cost;
    }


}
