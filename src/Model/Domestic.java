package Model;

public abstract class Domestic extends Animal
{
    public abstract void NextTurn(int n, Farm farm, Warehouse warehouse) ;
    public Domestic(int x, int y, String type) {
        super(x, y, type);
    }
}
