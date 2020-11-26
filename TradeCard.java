public class TradeCard extends Card {
    public GemSet give;
    public GemSet receive;

    public TradeCard(GemSet give, GemSet receive) {
        this.give = give;
        this.receive = receive;
    }
}