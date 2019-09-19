package calculatrice_RPN;


// il manque extends element 
public abstract class Operation extends element {// enum =Class avec un nombre d'instances limité
	// déclaration des constantes
	final char PLUS='+';
	final char MOINS='-';
	final char MULT='*';
	final char DIV='/';
	
	public char symbole;
	
	
	/*private Operation() {	
		this.symbole =null;	
	}
	*/
	protected Operation(char s) {
		
		this.symbole =s;
		
	}
	
	abstract double eval(double a, double b);
	
}
