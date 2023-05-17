
package Testak;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JRadioButton;

import org.junit.jupiter.api.Test;

import Modelo.Apostu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class TestApostu {

	 int id_apustua = 1;
	 int id_joko = 1;
	 String NAN = "12345678A";
	 int apostu_kantitatea = 1000;
	 int apostu_emaitza = 500;
	 
	//KONSTRUKTOREA
		Apostu apustua_test_konstruktorea = new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		

	
	//GETTERS & SETTERS 
	
	@Test //ID_APOSTUA
	void test_getId_apustua() {
		Apostu apustua_test_getId_apustua = new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		int apustua_getid = apustua_test_getId_apustua.getId_apustua();
		assertEquals(apustua_getid, 1);
	}
	@Test //ID_APOSTUA
	void test_setId_apustua() {
		Apostu apustua_test_setId_apustua = new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		int set = 1;
		apustua_test_setId_apustua.setId_apustua(set);
		assertEquals(apustua_test_setId_apustua.getId_apustua(), set);
	}
	
	@Test//ID_JOKO
	void test_getId_joko(){
		Apostu apustua_test_getId_joko= new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		int apustua_getid_joko = apustua_test_getId_joko.getId_joko();
		assertEquals(apustua_getid_joko, 1);
	}
	@Test //ID_JOKO
	void test_setId_joko() {
		Apostu apustua_test_getId_joko = new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		int set = 1;
		apustua_test_getId_joko.setId_joko(set);
		assertEquals(apustua_test_getId_joko.getId_joko(), set);
	}
	
	@Test //NAN
	void test_getNAN() {
		Apostu apustua_test_getNAN= new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		String apustua_getNAN = apustua_test_getNAN.getNAN();
		assertEquals(apustua_getNAN, "12345678A");
	}
	@Test //NAN
	void test_setNAN() {
		Apostu apustua_test_setNAN = new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		String set = "87654321Z";
		apustua_test_setNAN.setNAN(set);
		assertEquals(apustua_test_setNAN.getNAN(), set);
	}
	
	@Test //APOSTU_KANT
	void test_getApostu_kantitatea() {
		Apostu apustua_test_getApostu_kantitatea = new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		int apustua_getApostu_kantitatea = apustua_test_getApostu_kantitatea.getApostu_kantitatea();
		assertEquals(apustua_getApostu_kantitatea, 1000);
	}
	@Test //APOSTU_KANT
	void test_setApostu_kantitatea() {
		Apostu apustua_test_setApostu_kantitatea = new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		int set = 2000;
		apustua_test_setApostu_kantitatea.setApostu_kantitatea(set);;
		assertEquals(apustua_test_setApostu_kantitatea.getApostu_kantitatea(), set);
	}

	@Test //APOSTU_EMAITZA
	void test_getApostu_emaitza() {
		Apostu apustua_test_getApostu_emaitza = new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		int apustua_getid = apustua_test_getApostu_emaitza.getApostu_emaitza();
		assertEquals(apustua_getid, 500);
	}
	@Test //APOSTU_EMAITZA
	void test_setApostu_emaitza() {
		Apostu apustua_test_setApostu_emaitza = new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		int set = 2000;
		apustua_test_setApostu_emaitza.setApostu_emaitza(set);
		assertEquals(apustua_test_setApostu_emaitza.getApostu_emaitza(), set);
	}
	
	
	
	//METODOAK
	
	@Test
	public void testApostuaGuztiak() {
		JRadioButton rdbtnApostu10 = new JRadioButton();
		JRadioButton rdbtnApostu20 = new JRadioButton();
		JRadioButton rdbtnApostu50 = new JRadioButton();
		JRadioButton rdbtnApostu100 = new JRadioButton();
		JRadioButton rdbtnApostu500 = new JRadioButton();
		JRadioButton rdbtnApostu1000 = new JRadioButton();
		JRadioButton rdbtnAllIn= new JRadioButton();
		int[] zbk = {0};

		rdbtnApostu10.setSelected(true);
		int apostuOrain = Apostu.apustua_egin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, rdbtnAllIn, 50, 0, 0, zbk);
		assertEquals(10, apostuOrain);
		assertEquals(10, zbk[0]);

		rdbtnApostu10.setSelected(false);
		rdbtnApostu20.setSelected(true);
		apostuOrain = Apostu.apustua_egin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, rdbtnAllIn, 50, 10, 0, zbk);
		assertEquals(30, apostuOrain);
		assertEquals(30, zbk[0]);

		rdbtnApostu20.setSelected(false);
		rdbtnApostu50.setSelected(true);
		zbk[0] = 0;
		apostuOrain = Apostu.apustua_egin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, rdbtnAllIn, 100, 0, 0, zbk);
		assertEquals(50, apostuOrain);
		assertEquals(50, zbk[0]);

		rdbtnApostu50.setSelected(false);
		rdbtnApostu100.setSelected(true);
		zbk[0] = 0;
		apostuOrain = Apostu.apustua_egin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, rdbtnAllIn, 150, 0, 0, zbk);
		assertEquals(100, apostuOrain);
		assertEquals(100, zbk[0]);

		rdbtnApostu100.setSelected(false);
		rdbtnApostu500.setSelected(true);
		zbk[0] = 0;
		apostuOrain = Apostu.apustua_egin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, rdbtnAllIn, 600, 0, 0, zbk);
		assertEquals(500, apostuOrain);
		assertEquals(500, zbk[0]);

		rdbtnApostu500.setSelected(false);
		rdbtnApostu1000.setSelected(true);
		zbk[0] = 0;
		apostuOrain = Apostu.apustua_egin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, rdbtnAllIn, 2000, 0, 0, zbk);
		assertEquals(1000, apostuOrain);
		assertEquals(1000, zbk[0]);

		rdbtnApostu1000.setSelected(false);
		apostuOrain = Apostu.apustua_egin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, rdbtnAllIn, 2000, 0, 0, zbk);
		assertEquals(0, apostuOrain);
		assertEquals(1000, zbk[0]);

		rdbtnApostu500.setSelected(true);
		apostuOrain = Apostu.apustua_egin(rdbtnApostu10, rdbtnApostu20, rdbtnApostu50, rdbtnApostu100, rdbtnApostu500, rdbtnApostu1000, rdbtnAllIn, 400, 100, 0, zbk);
		assertEquals(100, apostuOrain);
		assertEquals(1000, zbk[0]);
	}
	
	
	//TOSTRING
	@Test 
	void test_apustua_tostring() {
		Apostu apustua_test_apustua_egin = new Apostu(id_apustua, id_joko, NAN, apostu_kantitatea, apostu_emaitza);
		
		String Expected= "Apustuak [id_apustua=" + id_apustua + ", id_joko=" + id_joko + ", NAN=" + NAN + ", apostu_kantitatea="
				+ apostu_kantitatea + ", apostu_emaitza=" + apostu_emaitza + "]";
		assertEquals(Expected, apustua_test_apustua_egin.toString() );
	}
	

	//HASCODE
	@Test 
	void test_Apostu_hascode() {
		
		Apostu apustua_test_hascode1 =  new Apostu(1, 2, "12345678L", 1000, 500);
		Apostu apustua_test_hascode2 =  new Apostu(1, 2, "12345678L", 1000, 500);
		assertEquals(apustua_test_hascode1.hashCode(), apustua_test_hascode2.hashCode());
	}
	
	//EQUALS
	@Test 
	void test_Apostu_EqualsFalse() {
		
		Apostu apustua_test_equals1 = new Apostu(1, 2, "12345678L", 1000, 500);
		Apostu apustua_test_equals2 = new Apostu(2, 1, "87654321Z", 3500, 700);
		assertFalse(apustua_test_equals1.equals(apustua_test_equals2));
	}
	
	@Test 
	void test_Apostu_True() {

		Apostu apustua_test_equals1 = new Apostu(1, 2, "12345678L", 1000, 500);
		Apostu apustua_test_equals2 = new Apostu(1, 2, "12345678L", 1000, 500);
		assertTrue(apustua_test_equals1.equals(apustua_test_equals2));
	}
}