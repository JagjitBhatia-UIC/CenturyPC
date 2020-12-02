import java.util.ArrayList;

// Deck object maintains the Deck throughout the game
class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
    }

    public void add(Card c) {
        cards.add(c);
    }

    // Method to add card of type specified by image to Deck
    public void add(String filename) {
        filename = filename.split(".png")[0];
        props = filename.split("_");

        // Crystal card file example: crystal_2_yellow.png
        if(props[0].equals("crystal")) {
            GemSet toAdd = new GemSet(0,0,0,0);
            int quantity;

            for(int i = 1; i < props.length; i += 2) {
                quantity = Integer.parseInt(props[i]);
                toAdd.add(props[i+1], quantity);
            }

            CrystalCard cc = new CrystalCard(toAdd);
            cards.add(cc);
            return;   
        }

        // Trade card file example: trade_2_yellow_to_1_green.png
        if(props[0].equals("trade")) {
            GemSet gs_give = new GemSet(0,0,0,0);
            GemSet gs_recv = new GemSet(0,0,0,0);
  
            boolean isGive = true;

            for(int i = 1; i<set.length; i++) {
                if(props[i].equals("to")) {
                    isGive = false;
                }

                else {
	                int num = Integer.parseInt(props{i]);
                    if(isGive) gs_give.add(props{i+1], num);
                    else gs_recv.add(props{i+1], num);    
      	            i++;
                }
            }

            TradeCard tc = new TradeCard(gs_give, gs_recv);
            cards.add(tc);
            return;
        }

        // Upgrade card file example: upgrade_2.png
        if(props[0].equals("upgrade")) {
            UpgradeCard uc = new UpgradeCard(Integer.parseInt(props[1]));
            cards.add(uc);
            return;
        }
    }
}