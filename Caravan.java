import java.util.ArrayList;

// This object holds the player's inventory of gems
public class Caravan {
  private Gem[] inventory;  // Consists of 10 slots, each of which can contain up to 1 gem
  private ArrayList<Gem> excess;  // MUST BE CLEARED BEFORE TURN ENDS
  private int size; // Number of slots filled

  public Caravan() {
    inventory = new Gem[10];
    size = 0;
  }

  public Gem[] fetch() {
    return inventory;
  }
  
  // Adds gem to any empty slot -- *Note* Should excess be taken care of here?
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

  // Adds set of gems passed via parameter to the Caravan. If slots are full, add to excess
  public void add(GemSet gems) {
      int to_add = gems.size();
      int excess = 0;

      if((size + to_add) > inventory.length) {
          excess = inventory.length - size - to_add;
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

  // Removes gem in specified slot
  public void remove(int slot) {
    inventory[slot] = null;
    size--;
  }

  // Upgrades gem in specified slot
  public void upgrade(int slot) {
    inventory[slot].upgrade();
  }
  
}