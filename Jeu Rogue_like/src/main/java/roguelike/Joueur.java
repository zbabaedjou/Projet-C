package roguelike;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Joueur extends Vivant{

	public Joueur(int x, int y) {

		this.setX(x);
		this.setY(y);
	}	
	
	
	public  String repondre() {
		String s="";
		
		
	      List<String> arrlist = new ArrayList<String>();
	      String parole="A";
	      arrlist.add("A");
		  arrlist.add("B");
		  arrlist.add("C"); 
		  arrlist.add("D"); 
		
		  Collections.shuffle(arrlist);
		  parole=arrlist.get(0);
		  if(parole == "A") {
			  s="y a il eu de l'avancement dans votre quete";
		  }
		  if(parole == "B") {
			  s="j'aime bien les short ca garde mes jambes au frait";
		  }
		  if(parole == "C") {
			  s="ZZZZZZzzzzz.....";
		  }
		  if(parole == "D") {
			  s="cessez donc de me deranger";
		  }
		return s;
}


	
}
