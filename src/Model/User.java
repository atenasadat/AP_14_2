package Model;

public class User
{
    private int Money;
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
        if(user.getMoney()>=cost)
        {
            user.setMoney(user.getMoney()-cost);
            return true;

        }
        else
        {
            System.out.println("no enough Money");
            return false;
        }

    }


}
