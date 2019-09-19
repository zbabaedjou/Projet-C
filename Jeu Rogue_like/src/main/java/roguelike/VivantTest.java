package roguelike;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class VivantTest {
	private GenerUnivers u;
	PJ j;
	@Before
	public void setUp() throws Exception {
		
		u= new GenerUnivers(7,5);
		j= new PJ(1,1);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		for (int x = 0; x < 7; x++) {
			for (int y = 0; y < 5; y++) {
				u.get_elements()[x][y] =  Objet.MUR;
			}
		}
		
		assertEquals(" c'est un MUR : ", j.Interagir((Objet)u.get_elements()[1][1]) );
		
	}

}
