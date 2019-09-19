package calculatrice_RPN;

public class ExceptionNombreNonValide extends Exception{
	
	
	public ExceptionNombreNonValide() {}  
	
	public ExceptionNombreNonValide(String message) {  
		super(message); 
	}  
	
	public ExceptionNombreNonValide(Throwable cause) {  
		super(cause); 
	}  
	
	public ExceptionNombreNonValide(String message, Throwable cause) {  
		super(message, cause); 
	} 

}
