import java.util.ArrayList;

public class Caravan {
  private Gem[] inventory;
  private ArrayList<Gem> excess;  // Must be cleared by end of turn
  private int size;

  public Caravan() {
    inventory = new Gem[10];
    size = 0;
  }

  public Gem[] fetch() {
    return inventory;
  }
  
  public void add(int val) {
    for(int i = 0; i < inventory.length; i++) {
      if(inventory[i] == null) {
        inventory[i] = new Gem(val);
        size++;
        return;
      }
    }
  }

  public void addExcess(int val) {
    excess.add(new Gem(val));
  }

  public void add(GemSet gems) {
      int to_add = gems.size();
      int excess = 0;

      if((size + to_add) > 10) {
          excess = 10 - size - to_add;
          to_add -= excess;
      }

      Gem[] buf = gems.build();
      int ptr = 0;

      while(to_add > 0 || excess > 0) {
        if(to_add > 0) {
          this.add(buf[ptr].getVal());
          to_add--;
        }

        else {
          addExcess(buf[ptr].getVal());
          excess--;
        }

        ptr++;
      }    
  }

  public void remove(int slot) {
    inventory[slot] = null;
    size--;
  }

  public void upgrade(int slot) {
    inventory[slot].upgrade();
  }
  
}