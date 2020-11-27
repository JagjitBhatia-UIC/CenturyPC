import java.util.ArrayList;

// This object holds the player's inventory of gems
public class Caravan {
  private Gem[] inventory;  // Consists of 10 slots, each of which can contain up to 1 gem
  private ArrayList<Gem> excess;  // MUST BE CLEARED BEFORE TURN ENDS
  private int size; // Number of slots filled

  public Caravan() {
    inventory = new Gem[10];
    size = 0;
    excess = new ArrayList<Gem>();
  }

  public Gem[] fetch() {
    return inventory;
  }
  
  // Adds gem to any empty slot 
  public void add(int val) {
    if(size == inventory.length) {
      excess.add(new Gem(val));
    }

    for(int i = 0; i < inventory.length; i++) {
      if(inventory[i] == null) {
        inventory[i] = new Gem(val);
        size++;
        return;
      }
    }
  }

  // Adds set of gems passed via parameter to the Caravan. If slots are full, add to excess
  public void add(GemSet gems) {
      Gem[] gs = gems.build();
      
      for(int i = 0; i<gs.length; i++) {
        this.add(gs[i].getVal());
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
  
  // For debug purposes
  public void printExcess() {
    for(int i = 0; i<this.excess.size(); i++) {
      System.out.println(this.excess.get(i).color());
    }
  }
  
}