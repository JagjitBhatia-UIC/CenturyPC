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

    // Method to print deck - solely for debugging purposes
    public void printDeck() {
        for(int i = 0; i < cards.size(); i++) {
            if(cards.get(i).type.equals("Crystal")) {
                CrystalCard cc = (CrystalCard) cards.get(i);
                System.out.print("CRYSTAL: ");
                Gem[] crystals = cc.gems.build();
                for(int j = 0; j<crystals.length; j++) {
                    System.out.print(crystals[j].color() + " ");
                }
                System.out.println("");
            }

            if(cards.get(i).type.equals("Trade")) {
                TradeCard tc = (TradeCard) cards.get(i);
                System.out.print("TRADE: ");
                Gem[] gives = tc.give.build();
                Gem[] recvs = tc.receive.build();

                System.out.print("GIVE: ");
                for(int j = 0; j<gives.length; j++) {
                    System.out.print(gives[j].color() + " ");
                }

                System.out.print("RECEIVE: ");
                for(int j = 0; j<recvs.length; j++) {
                    System.out.print(recvs[j].color() + " ");
                }
                System.out.println("");
            }

            if(cards.get(i).type.equals("Upgrade")) {
                UpgradeCard uc = (UpgradeCard) cards.get(i);
                System.out.println("UPGRADE: " + uc.quantity);
            }
        }
    }

    // Method to add card of type specified by image to Deck
    public void add(String filename) {
        filename = filename.split(".png")[0];
        String[] props = filename.split("_");

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

            for(int i = 1; i<props.length; i++) {
                if(props[i].equals("to")) {
                    isGive = false;
                }

                else {
	                int num = Integer.parseInt(props[i]);
                    if(isGive) gs_give.add(props[i+1], num);
                    else gs_recv.add(props[i+1], num);    
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