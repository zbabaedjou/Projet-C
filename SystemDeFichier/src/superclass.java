
public abstract class superclass {
	String nom;	
		
	public superclass(String nom) {
		this.nom=nom;
	}
	public abstract int explore();
	
	public abstract int getTaille();
	public abstract boolean verifProblem(superclass s);
	public abstract boolean recursive (superclass d) ;
	
}
