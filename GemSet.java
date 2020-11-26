public class GemSet {
    public int yellow;
    public int green;
    public int blue;
    public int purple;

    public GemSet(int yellow, int green, int blue, int purple) {
        this.yellow = yellow;
        this.green = green;
        this.blue = blue;
        this.purple = purple;
    }

    public Gem[] build() {
        Gem[] set = new Gem[size()];
        int ptr = 0;

        for(int i = 0; i < yellow; i++) {
            set[ptr] = new Gem(0);
            ptr++;
        }

        for(int j = 0; j < green; j++) {
            set[ptr] = new Gem(1);
            ptr++;
        }

        for(int k = 0; k < blue; k++) {
            set[ptr] = new Gem(2);
            ptr++;
        }

        for(int l = 0; l < purple; l++) {
            set[ptr] = new Gem(3);
            ptr++;
        }

        return set;
    }

    public int size() {
        return yellow + green + blue + purple;
    }
}