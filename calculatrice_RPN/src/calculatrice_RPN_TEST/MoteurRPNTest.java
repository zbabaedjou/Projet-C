package calculatrice_RPN_TEST;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculatrice_RPN.ExceptionNombreNonValide;
import calculatrice_RPN.MoteurRPN;

public class MoteurRPNTest {
	MoteurRPN cal;
	
	@Before
	public void setUp() throws Exception {
		cal= new MoteurRPN();
		cal.empiler_chiffre(3);
		cal.empiler_chiffre(5);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testMoteurRPNAddition() {
		double res=5+3;
		cal.symbole='+';
		
		assertEquals(res,cal.eval(cal.pile.pop(), cal.pile.pop()),0);

	}
	
	@Test
	public void testMoteurRPNMoins() {
		double res=5-3;
		cal.symbole='-';
		
		assertEquals(res,cal.eval(cal.pile.pop(), cal.pile.pop()),0);

	}
	
	@Test
	public void testMoteurRPNMultiplication() {
		double res=5*3;
		cal.symbole='*';
		
		assertEquals(res,cal.eval(cal.pile.pop(), cal.pile.pop()),0);

	}
	
	@Test
	public void testMoteurRPNDivision() {
		double res=5/3;
		cal.symbole='/';
		
		assertEquals(res,cal.eval(cal.pile.pop(), cal.pile.pop()),1);

	}
	
//https://www.baeldung.com/junit-assert-exception
	@Test (expected = ArithmeticException.class)
	public void testEvalDivise_0()  {
		
		cal.empiler_chiffre(0);
		cal.empiler_chiffre(5);	
		cal.symbole='/';
		System.out.println(cal.eval(cal.pile.pop(), cal.pile.pop()));
		cal.eval(cal.pile.pop(), cal.pile.pop());
	}

	/*@Test
	public void testMoteurRPN() {
		fail("Not yet implemented");
	}*/

	

	@Test
	public void testAfficher_Operandes() {
		cal.afficher_Operandes();
	}

}
