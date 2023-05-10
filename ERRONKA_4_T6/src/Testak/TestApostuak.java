package Testak;

import static org.junit.Assert.assertEquals;

import javax.swing.JRadioButton;

import org.junit.Test;

import Kontrolatzailea.apostuak;

public class TestApostuak {

	@Test
	public void testApostuaGuztiak() {
		JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		int[] zbk = {0};

		rdbtnApostu10.setSelected(true);
		int apostuOrain = apostuak.apostuaGehitu(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 50, 0, 0, zbk);
		assertEquals(10, apostuOrain);
		assertEquals(10, zbk[0]);

		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		apostuOrain = apostuak.apostuaGehitu(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 50, 10, 0, zbk);
		assertEquals(30, apostuOrain);
		assertEquals(30, zbk[0]);

		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		zbk[0] = 0;
		apostuOrain = apostuak.apostuaGehitu(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 100, 0, 0, zbk);
		assertEquals(50, apostuOrain);
		assertEquals(50, zbk[0]);

		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		zbk[0] = 0;
		apostuOrain = apostuak.apostuaGehitu(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 150, 0, 0, zbk);
		assertEquals(100, apostuOrain);
		assertEquals(100, zbk[0]);

		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		zbk[0] = 0;
		apostuOrain = apostuak.apostuaGehitu(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 600, 0, 0, zbk);
		assertEquals(500, apostuOrain);
		assertEquals(500, zbk[0]);

		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		zbk[0] = 0;
		apostuOrain = apostuak.apostuaGehitu(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, zbk);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, zbk[0]);

		rdbtnApostu1000.setSelected(false);
		apostuOrain = apostuak.apostuaGehitu(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 2000, 0, 0, zbk);
		assertEquals(0, apostuOrain);
		assertEquals(1000, zbk[0]);

		rdbtnApostu500.setSelected(true);
		apostuOrain = apostuak.apostuaGehitu(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, 400, 100, 0, zbk);
		assertEquals(100, apostuOrain);
		assertEquals(1000, zbk[0]);
	}
}
