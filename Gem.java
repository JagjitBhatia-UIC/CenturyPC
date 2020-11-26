public class Gem {
  	private int val;
  	
    public Gem() {
    	this.val = 0;
    }
    
  	public Gem(int val) {
    	if(val >= 0 && val < 4) this.val = val;
        else this.val = 0;
    }
    
    public String color() {
    	switch(val) {
        	case 0: return "Yellow";
          case 1: return "Green";
          case 2: return "Blue";
          case 3: return "Purple";
          default: return "null";
        }
    }
    
    public Gem next() {
    	if(this.val < 3) return new Gem(this.val + 1);
        
        return new Gem(3); 
    }
    
    public void upgrade() {
    	if(this.val < 3) this.val += 1;
    }

    public int getVal() {
      return val;
    }
  }