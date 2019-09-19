
public class Fichier extends superclass{

	private int taille;
	
	Fichier(String nom, int taille){
		super(nom);
		this.taille=taille;
	}
	
	 public int explore() {
		 return 1;
		 
	 }
	 
	 public int getTaille() {
		 return this.taille;
		 
	 }
	    public boolean verifProblem(superclass d) {
	    		return false;
	    }
	    public boolean recursive (superclass d) {
	    	return false;
	    	
	    }
	
}
