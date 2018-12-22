package Model;

public class Cat extends Animal {
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Cat(int x, int y, String type) {
        super(x, y, type);

    }
    public void Upgrade(){
        if (level==1)
            System.out.println("not possible");
        else
            level=1;
    }

}
