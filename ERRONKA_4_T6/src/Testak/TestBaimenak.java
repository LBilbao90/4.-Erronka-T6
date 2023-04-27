package Testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Baimena;
import Modelo.Erabiltzaile;
import Modelo.Pertsona;

class TestBaimenak {


	String erabiltzailea = "Pedro";
	 int baimen_mota = 1;
	 Date hasiera_data = null;
	 Date bukaera_data = null;
	
	 Pertsona pertsona;
	 
	//KONSTRUKTOREA
		Baimena baimena_test_konstruktorea = new Baimena(erabiltzailea, baimen_mota, bukaera_data, bukaera_data, pertsona);
		

	
	//GETTERS & SETTERS 
	@Test 
	void test_getters_setters() {
		
	  //setters
		baimena_test_konstruktorea.setErabiltzailea(erabiltzailea);
		baimena_test_konstruktorea.setBaimen_mota(baimen_mota);
		baimena_test_konstruktorea.setHasiera_data(hasiera_data);
		baimena_test_konstruktorea.setBukaera_data(bukaera_data);
		
		baimena_test_konstruktorea.setPertsona(pertsona);
		
	  //getters
		assertEquals(baimena_test_konstruktorea.getErabiltzailea() , erabiltzailea);
		assertEquals(baimena_test_konstruktorea.getBaimen_mota() , baimen_mota);
		assertEquals(baimena_test_konstruktorea.getHasiera_data() , hasiera_data);
		assertEquals(baimena_test_konstruktorea.getBukaera_data() , bukaera_data);
		
		assertEquals(baimena_test_konstruktorea.getPertsona() , pertsona);
	}
	
	
	
	//METODOAK
	
	@Test //baimena_artu
	void test_baimena_artu() {

	}
	
	@Test //baimena_artu
	void baimena_kanporatu() {

	}
	
	@Test //baimena_artu
	void balidatu_erabiltzailea_baimenarako() {

	}
	
	
	
	//TOSTRING
	@Test 
	void test_baimenak_tostring() {
		
		String Expected= "Baimena [erabiltzailea=" + erabiltzailea + ", baimen_mota=" + baimen_mota + ", hasiera_data="
				+ hasiera_data + ", bukaera_data=" + bukaera_data + ", pertsona=" + pertsona + "]";
		assertEquals(Expected, baimena_test_konstruktorea.toString() );
	}
	
	
	//HASCODE
	@Test 
	void test_baimenak_hascode() {
		Date data = new Date();
		Pertsona p1 = new Erabiltzaile("12345678L", "pedro", "pascal", data, "bilbo", "San Sebastian", "aragon", "bilbao la vieja", "4444", "si@gmail.com", "123macarron", "123456789", "macarroncito", 44,55);
		Baimena baimena_test_hascode1 = new Baimena("pedro", 1, data, data, p1);
		Baimena baimena_test_hascode2 = new Baimena("pedro", 1, data, data, p1);
		assertEquals(baimena_test_hascode1, baimena_test_hascode2);
	}
	
	//EQUALS
	@Test 
	void test_baimenak_EqualsFalse() {
		Date data = new Date();
		Pertsona p1 = new Erabiltzaile("12345678L", "pedro", "pascal", data, "bilbo", "San Sebastian", "aragon", "bilbao la vieja", "4444", "si@gmail.com", "123macarron", "123456789", "macarroncito", 44,55);
		Baimena baimena_test_hascode1 = new Baimena("pedro", 1, data, data, p1);
		Baimena baimena_test_hascode2 = new Baimena("unax", 1, data, data, p1);
		assertFalse(baimena_test_hascode1.equals(baimena_test_hascode2));
	}
	
	@Test 
	void test_baimenak_True() { 
		Date data = new Date();
		Pertsona p1 = new Erabiltzaile("12345678L", "pedro", "pascal", data, "bilbo", "San Sebastian", "aragon", "bilbao la vieja", "4444", "si@gmail.com", "123macarron", "123456789", "macarroncito", 44,55);
		Baimena baimena_test_equals1 = new Baimena("pedro", 1, data, data, p1);
		Baimena baimena_test_equals2 = new Baimena("pedro", 1, data, data, p1);
		assertTrue(baimena_test_equals1.equals(baimena_test_equals2));
	}

}
