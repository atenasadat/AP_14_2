package Model;

import java.util.ArrayList;

public abstract class Workshop
{

      private int x;
      private int y;
      private int level;
      private final int MAXLEVEL = 3;

      public int getX() {
            return x;
      }

      public void setX(int x) {
            this.x = x;
      }

      public int getY() {
            return y;
      }

      public void setY(int y) {
            this.y = y;
      }

      public int getLevel() {
            return level;
      }

      public void setLevel(int level) {
            this.level = level;
      }

      public int getMAXLEVEL() {
            return MAXLEVEL;
      }

      public User getUser() {
            return user;
      }

      public void setUser(User user) {
            this.user = user;
      }

      public int getLevel0upgrade() {
            return level0upgrade;
      }

      public int getLevel1Upgrade() {
            return level1Upgrade;
      }

      public int getLevel2Upgrade() {
            return level2Upgrade;
      }

      public int getLevel3Upgrade() {
            return level3Upgrade;
      }

      User user=User.getUser();
      protected final int level0upgrade = 0;
      protected final int level1Upgrade = 100;
      protected final int level2Upgrade = 500;
      protected final int level3Upgrade = 5000;



      public abstract void produce(ArrayList<Item> warehouseitems , ArrayList<Item> farmitem);
      public  abstract void Upgrade(int level);
      public abstract boolean canproduce(ArrayList<Item> warehouseitems);

}
