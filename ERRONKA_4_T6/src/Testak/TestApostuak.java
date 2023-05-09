package Testak;

import static org.junit.Assert.assertEquals;

import javax.swing.JRadioButton;

import org.junit.Test;

import Kontrolatzailea.apostuak;

public class TestApostuak {

	@Test
	public void testApostuaZBK() {
		JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] zbk = {0};

		rdbtnApostu10.setSelected(true);
		int apostuOrain = apostuak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 50, 0, 0, zbk);
		assertEquals(10, apostuOrain);
		assertEquals(10, zbk[0]);

		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		apostuOrain = apostuak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 50, 10, 0, zbk);
		assertEquals(30, apostuOrain);
		assertEquals(30, zbk[0]);

		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		zbk[0] = 0;
		apostuOrain = apostuak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, zbk);
		assertEquals(50, apostuOrain);
		assertEquals(50, zbk[0]);

		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		zbk[0] = 0;
		apostuOrain = apostuak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 150, 0, 0, zbk);
		assertEquals(100, apostuOrain);
		assertEquals(100, zbk[0]);

		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		zbk[0] = 0;
		apostuOrain = apostuak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 600, 0, 0, zbk);
		assertEquals(500, apostuOrain);
		assertEquals(500, zbk[0]);

		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		zbk[0] = 0;
		apostuOrain = apostuak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, zbk);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, zbk[0]);

		rdbtnApostu1000.setSelected(false);
		apostuOrain = apostuak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, zbk);
		assertEquals(0, apostuOrain);
		assertEquals(1000, zbk[0]);

		rdbtnApostu500.setSelected(true);
		apostuOrain = apostuak.apostuaZBK(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 400, 100, 0, zbk);
		assertEquals(100, apostuOrain);
		assertEquals(1000, zbk[0]);
	}


	
	@Test
	public void testApostuaEskerEskuin() {
		JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] dozenakEskerrEskuin = new int[10];

		rdbtnApostu10.setSelected(true);
		int apostuOrain = apostuak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenakEskerrEskuin);
		assertEquals(10, apostuOrain);
		assertEquals(10, dozenakEskerrEskuin[0]);

		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = apostuak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenakEskerrEskuin);
		assertEquals(20, apostuOrain);
		assertEquals(20, dozenakEskerrEskuin[0]);

		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = apostuak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenakEskerrEskuin);
		assertEquals(50, apostuOrain);
		assertEquals(50, dozenakEskerrEskuin[0]);

		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = apostuak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 200, 0, 0, dozenakEskerrEskuin);
		assertEquals(100, apostuOrain);
		assertEquals(100, dozenakEskerrEskuin[0]);

		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = apostuak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, dozenakEskerrEskuin);
		assertEquals(500, apostuOrain);
		assertEquals(500, dozenakEskerrEskuin[0]);

		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = apostuak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, dozenakEskerrEskuin);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, dozenakEskerrEskuin[0]);

		rdbtnApostu1000.setSelected(false);
		apostuOrain = apostuak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, dozenakEskerrEskuin);
		assertEquals(0, apostuOrain);
		assertEquals(1000, dozenakEskerrEskuin[0]);

		rdbtnApostu1000.setSelected(true);
		dozenakEskerrEskuin[0] = 0;
		apostuOrain = apostuak.apostuaEskerEskuin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 500, 0, 0, dozenakEskerrEskuin);
		assertEquals(0, apostuOrain);
		assertEquals(0, dozenakEskerrEskuin[0]);

	}
		
	@Test
	public void testApostuaDozena() {
		JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] dozenak = new int[3];

		rdbtnApostu10.setSelected(true);
		int apostuOrain = apostuak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenak);
		assertEquals(10, apostuOrain);
		assertEquals(10, dozenak[0]);

		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		dozenak[0] = 0;
		apostuOrain = apostuak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenak);
		assertEquals(20, apostuOrain);
		assertEquals(20, dozenak[0]);

		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		dozenak[0] = 0;
		apostuOrain = apostuak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, dozenak);
		assertEquals(50, apostuOrain);
		assertEquals(50, dozenak[0]);

		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		dozenak[0] = 0;
		apostuOrain = apostuak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 200, 0, 0, dozenak);
		assertEquals(100, apostuOrain);
		assertEquals(100, dozenak[0]);

		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		dozenak[0] = 0;
		apostuOrain = apostuak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, dozenak);
		assertEquals(500, apostuOrain);
		assertEquals(500, dozenak[0]);

		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		dozenak[0] = 0;
		apostuOrain = apostuak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, dozenak);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, dozenak[0]);

		rdbtnApostu1000.setSelected(false);
		int apostuOrainAntes = apostuOrain;
		apostuOrain = apostuak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, apostuOrain, 0, dozenak);
		assertEquals(apostuOrainAntes, apostuOrain);

		rdbtnApostu1000.setSelected(true);
		apostuOrainAntes = apostuOrain;
		apostuOrain = apostuak.apostuaDozena(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 500, apostuOrain, 0, dozenak);
		assertEquals(apostuOrainAntes, apostuOrain);

	}

	  @Test
	  public void testApostuErdia() {
		JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] taulaErdia = new int[1];
	
		rdbtnApostu10.setSelected(true);
		int apostuOrain = apostuak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, taulaErdia);
		assertEquals(10, apostuOrain);
		assertEquals(10, taulaErdia[0]);
	
		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = apostuak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, taulaErdia);
		assertEquals(20, apostuOrain);
		assertEquals(20, taulaErdia[0]);
	
		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = apostuak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, taulaErdia);
		assertEquals(50, apostuOrain);
		assertEquals(50, taulaErdia[0]);
	
		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = apostuak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, taulaErdia);
		assertEquals(100, apostuOrain);
		assertEquals(100, taulaErdia[0]);
		
		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = apostuak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, taulaErdia);
		assertEquals(500, apostuOrain);
		assertEquals(500, taulaErdia[0]);
		
		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = apostuak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, taulaErdia);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, taulaErdia[0]);
		
		rdbtnApostu1000.setSelected(false);
		taulaErdia[0] = 0;
		apostuOrain = apostuak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, taulaErdia);
		assertEquals(0, apostuOrain);
		assertEquals(0, taulaErdia[0]);
		
		rdbtnApostu1000.setSelected(true);
		taulaErdia[0] = 0;
		apostuOrain = apostuak.apostuErdia(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 500, 0, 0, taulaErdia);
		assertEquals(0, apostuOrain);
		assertEquals(0, taulaErdia[0]);
	}
	  
	  @Test
	  public void testApostuBakoitiBikoiti() {
		  JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] bakoitiBikoiti = new int[2];
		
		rdbtnApostu10.setSelected(true);
		int apostuOrain = apostuak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(10, apostuOrain);
		assertEquals(10, bakoitiBikoiti[0]);
		
		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		bakoitiBikoiti[0] = 0;
		apostuOrain = apostuak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(20, apostuOrain);
		assertEquals(20, bakoitiBikoiti[0]);
		
		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		bakoitiBikoiti[0] = 0;
		apostuOrain = apostuak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(50, apostuOrain);
		assertEquals(50, bakoitiBikoiti[0]);
		
		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		bakoitiBikoiti[0] = 0;
		apostuOrain = apostuak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(100, apostuOrain);
		assertEquals(100, bakoitiBikoiti[0]);
		
		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		bakoitiBikoiti[0] = 0;
		apostuOrain = apostuak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(500, apostuOrain);
		assertEquals(500, bakoitiBikoiti[0]);
			
		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		bakoitiBikoiti[0] = 0;
		apostuOrain = apostuak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, bakoitiBikoiti[0]);
			
		rdbtnApostu1000.setSelected(false);
		apostuOrain = apostuak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, bakoitiBikoiti);
		assertEquals(0, apostuOrain);
		
		rdbtnApostu10.setSelected(true);
		apostuOrain = apostuak.apostuBakoitiBikoiti(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 5, 0, 0, bakoitiBikoiti);
		assertEquals(0, apostuOrain);
	}
  	
	  @Test
	  public void testApostuKolorea() {
		  JRadioButton rdbtnApostu10 = new JRadioButton();
		  JRadioButton rdbtnApostu20 = new JRadioButton();
		  JRadioButton rdbtnApostu50 = new JRadioButton();
		  JRadioButton rdbtnApostu100 = new JRadioButton();
		  JRadioButton rdbtnApostu500 = new JRadioButton();
		  JRadioButton rdbtnApostu1000 = new JRadioButton();
		  int[] kolorea = new int[1];
		
		  rdbtnApostu10.setSelected(true);
		  int apostuOrain = apostuak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, kolorea);
		  assertEquals(10, apostuOrain);
		  assertEquals(10, kolorea[0]);
		
		  rdbtnApostu10.setSelected(false);
		  rdbtnApostu20.setSelected(true);
		  apostuOrain = apostuak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, kolorea);
		  assertEquals(20, apostuOrain);
		  assertEquals(30, kolorea[0]);
		
		  rdbtnApostu20.setSelected(false);
		  rdbtnApostu50.setSelected(true);
		  apostuOrain = apostuak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, kolorea);
		  assertEquals(50, apostuOrain);
		  assertEquals(80, kolorea[0]);
		
		  rdbtnApostu50.setSelected(false);
	      rdbtnApostu100.setSelected(true);
	      apostuOrain = apostuak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, kolorea);
	      assertEquals(100, apostuOrain);
	      assertEquals(180, kolorea[0]);
	
	      rdbtnApostu100.setSelected(false);
	      rdbtnApostu500.setSelected(true);
	      apostuOrain = apostuak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 0, 0, kolorea);
	      assertEquals(500, apostuOrain);
	      assertEquals(680, kolorea[0]);
	
	      rdbtnApostu500.setSelected(false);
	      rdbtnApostu1000.setSelected(true);
	      apostuOrain = apostuak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, kolorea);
	      assertEquals(1000, apostuOrain);
	      assertEquals(1680, kolorea[0]);
	
	      rdbtnApostu1000.setSelected(false);
	      apostuOrain = apostuak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 300, 0, kolorea);
	      assertEquals(300, apostuOrain);
	
	      rdbtnApostu1000.setSelected(true);
	      apostuOrain = apostuak.apostuKolorea(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 1000, 900, 0, kolorea);
	      assertEquals(900, apostuOrain);
	
	  	}

}
