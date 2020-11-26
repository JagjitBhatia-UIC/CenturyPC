public class CrystalCard extends Card {
    public GemSet gems;

    public CrystalCard() {
        this.gems = new GemSet(2, 0, 0, 0);
    }

    public CrystalCard(GemSet gems) {
        this.gems = gems;
    }

    public CrystalCard(int yellow, int green, int blue, int purple) {
        this.gems = new GemSet(yellow, green, blue, purple);
    }

   public GemSet getGems() {
       return gems;
   }
}