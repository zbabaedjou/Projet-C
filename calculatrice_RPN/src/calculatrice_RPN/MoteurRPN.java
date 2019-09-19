package calculatrice_RPN;

import java.util.Stack;

public class MoteurRPN extends Operation{
	
	final double MAX_VALUE=Double.MAX_VALUE;
	final double MIN_VALUE=Double.MIN_VALUE;

	
	public Stack<Double> pile;
	
	//Pile pile = new Pile(); 

	//Object pile1=1; 
/*	try
	{ 
	  if (isPileVide()) 
	  	{
            System.out.println("Impossible de faire une operation car la pile est vide");
           System.exit(-1); 
        }
	} 

catch (ExceptionPileVide v)
	{ 
		System.out.println("La pile est vide"+v); 
	} 

*/
	
	public MoteurRPN() {
		super(' ');
		this.pile = new Stack<Double>();
		
	}// push(E)  pop()   peek() 
	
	public void empiler_chiffre(double c) {
		 
			this.pile.push(c);
		
	}

	
	public double eval (double a1,double a2) {
		
		if (this.symbole==this.PLUS) return a1 + a2;
		if (this.symbole==this.MOINS) return a1 - a2;
		if (this.symbole==this.MULT) return a1 * a2;
		if (this.symbole==this.DIV) return a1 / a2;
		return 0;
	}

	public void afficher_Operandes(){
		System.out.println("Opérandes Stockées: " + this.pile);
		
	}


	
}
