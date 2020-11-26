class Main {  
  public static void main(String args[]) { 
    Caravan c = new Caravan();

    c.add(0);
    c.add(1);
    c.add(2);
    c.add(0);
    c.upgrade(0);

    for(Gem g : c.fetch()) {
      if(g != null) System.out.println(g.color());
    }

  } 
}