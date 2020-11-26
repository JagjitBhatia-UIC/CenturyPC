public class CrystalCard extends Card {
    public GemSet gems;

    public CrystalCard() {
        super("Crystal");
        this.gems = new GemSet(2, 0, 0, 0);
    }

    public CrystalCard(GemSet gems) {
        super("Crystal");
        this.gems = gems;
    }

    public CrystalCard(int yellow, int green, int blue, int purple) {
        super("Crystal");
        this.gems = new GemSet(yellow, green, blue, purple);
    }

   public GemSet getGems() {
       return gems;
   }
}