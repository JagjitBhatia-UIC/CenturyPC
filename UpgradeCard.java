public class UpgradeCard extends Card {
    public int quantity;

    public UpgradeCard() {
        super("Upgrade");
    }

    public UpgradeCard(int quantity) {
        super("Upgrade");
        this.quantity = quantity;
    }
}