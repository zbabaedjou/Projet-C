package calculatrice_RPN;

public class Chiffre_reel extends element{
	
	private float val;
	private static Chiffre_reel  max =new Chiffre_reel(Float.MAX_VALUE);
	private static Chiffre_reel  min =new Chiffre_reel(Float.MIN_VALUE);
	
	
	public Chiffre_reel() {
		this.val=0;
		
		
	}
	
	public Chiffre_reel(float a) {
		this.val=a;
		
		
	}
	
	
}
