package projet;
/**
 * @author NIANG Ndeye Fatou 
 * @author ELMCHICHI Maryem 
 * @author Ziadath BABAEDJOU
 * 
 */
public class View implements Command{
	
	Fonctionnalite fonction;
	  public View(Fonctionnalite fonction){
	    this.fonction = fonction;
	  }
	  public void execute(String mot){
	    this.fonction.apercu(mot);
	  }

	

}
