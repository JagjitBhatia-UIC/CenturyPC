import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
   Caravan c = new Caravan();
   
   ArrayList<Card> deck = new ArrayList<Card>();
   deck.add(new CrystalCard());
   c.add(((CrystalCard) deck.get(0)).gems);
    for(Gem g : c.fetch()) {
      if(g != null) System.out.println(g.color());
    }
  
  String as = "crystal_2_blue_3_green.png";
  String s = "trade_2_blue_3_green_to_3_blue_2_green.png";


  String filename = s.split(".png")[0];

  System.out.println(filename);

  String[] set = filename.split("_");
  
  Gem[] result;

  if(set[0].equals("crystal")) {
    GemSet gsb = new GemSet(0,0,0,0);
  for(int i = 1; i<set.length; i+=2) {
    int num = Integer.parseInt(set[i]);
    gsb.add(set[i+1], num);
  }

  result = gsb.build();
}

else if(set[0].equals("trade")) {
  GemSet gs_give = new GemSet(0,0,0,0);
  GemSet gs_recv = new GemSet(0,0,0,0);
  
  boolean isGive = true;

  for(int i = 1; i<set.length; i++) {
    if(set[i].equals("to")) {
      isGive = false;
    }

    else {
	      int num = Integer.parseInt(set[i]);
        if(isGive) gs_give.add(set[i+1], num);
        else gs_recv.add(set[i+1], num);    
      	i++;
    }
  }
  System.out.println("GIVE: ");
  Gem[] give = gs_give.build();
  Gem[] recv = gs_recv.build();

  for(int i = 0; i<give.length; i++) {
    System.out.println(give[i].color());
  }
  System.out.println("RECEIVE: ");

  for(int i = 0; i<recv.length; i++) {
    System.out.println(recv[i].color());
  }

  //result = curr.build();
  result = new GemSet(0,0,0,0).build();
}

else result = new GemSet(0,0,0,0).build();

System.out.println("RESULT GEM SET: ");
for(int i = 0; i<result.length; i++) {
  System.out.println(result[i].color());
}
  System.out.println("Done.");
  }
}