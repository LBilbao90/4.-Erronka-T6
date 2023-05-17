package Testak;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Kontrolatzailea.metodoak;

public class TestMetodoak {
	
	  	 	
  	@Test
  	public void testRuletakoZbkKalkulatu() {
  		int ZbkKalkulatu = metodoak.ruletakoZbkKalkulatu(Math.toRadians(-45));
		assertEquals(4, ZbkKalkulatu);
	}
  
    @Test
    public void testGehituApostuak() {
    	int[] apostua1 = {};
        int[] apostua2 = {5};
        int[] apostua3 = {2, 4, 6, 8, 10};
        
        int emaiza1 = metodoak.gehituApostuak(apostua1);
        int emaitza2 = metodoak.gehituApostuak(apostua2);
        int emaitza3 = metodoak.gehituApostuak(apostua3);
        
        assertEquals(0, emaiza1);
        assertEquals(5, emaitza2);
        assertEquals(30, emaitza3);
    }
}