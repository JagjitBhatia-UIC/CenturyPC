import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    // Test Deck class; Should output Crystal(Blue, 2), Trade((Purple, 2), ((Yellow, 2), (Green, 3))), Upgrade(3)
    Deck d = new Deck();
    d.add("crystal_2_blue.png");
    d.add("trade_2_purple_to_3_green_2_yellow");
    d.add("upgrade_3");
    d.printDeck();
  }
}