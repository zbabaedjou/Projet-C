package calculatrice_RPN_TEST;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculatrice_RPN.ExceptionNombreNonValide;
import calculatrice_RPN.SaisieRPN;

public class SaisieRPNTest {
	SaisieRPN test;
	String a;
	String B;
	@Before
	public void setUp() throws Exception {
		test= new SaisieRPN();
		 
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRun() {
		
		System.out.println(test.isDouble(a));
		
		System.out.println(test.isDouble(B));
	}
	
	@Test (expected=NullPointerException.class)
	public void pile_vide() {
		test.moteur.pile.push((double) 5);
		test.calcul('+'); 
	}
	
	@Test (expected = ExceptionNombreNonValide.class) //classe à créer
	public void testEmpiler_chiffre_Nombre_MINMAX() throws ExceptionNombreNonValide{
		test.ajouter_operande((double)500);
	}
}
