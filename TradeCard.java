public class TradeCard extends Card {
    public GemSet give;
    public GemSet receive;

    public TradeCard() {
        super("Trade");
    }

    public TradeCard(GemSet give, GemSet receive) {
        super("Trade");
        this.give = give;
        this.receive = receive;
    }
}