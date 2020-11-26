import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
   Caravan c = new Caravan();
   
   ArrayList<Card> deck = new ArrayList<Card>();
   deck.add(new CrystalCard());
   c.add(((CrystalCard) deck.get(0)).gems);
    for(Gem g : c.fetch()) {
      if(g != null) System.out.println(g.color());
    }
  
  System.out.println("Done.");
  }
}