package projet;
/**
 * @author NIANG Ndeye Fatou 
 * @author ELMCHICHI Maryem 
 * @author Ziadath BABAEDJOU
 * 
 */
public class Supprimer implements Command{

	Fonctionnalite fonction;
	  public Supprimer(Fonctionnalite fonction){
	    this.fonction = fonction;
	  }
	  public void execute(String mot){
	    this.fonction.delete(mot); ;
	  }

}
