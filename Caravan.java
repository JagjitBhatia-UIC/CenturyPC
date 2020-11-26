public class Caravan {
  private Gem[] inventory;

  public Caravan() {
    inventory = new Gem[10];
  }

  public Gem[] fetch() {
    return inventory;
  }
  
  public void add(int val) {
    for(int i = 0; i < inventory.length; i++) {
      if(inventory[i] == null) {
        inventory[i] = new Gem(val);
        return;
      }
    }
  }

  public void remove(int slot) {
    inventory[slot] = null;
  }

  public void upgrade(int slot) {
    inventory[slot].upgrade();
  }



  

  
  
}