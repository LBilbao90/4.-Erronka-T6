
package Testak;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Modelo.Erabiltzaile;
import Modelo.Maila;

class TestMaila {
	String maila_izena = "Bronce";
	double biderkatzailea = 2;
	int kopurua = 4;
	String NAN = "48987755P";
	int id_maila = 1;
	ArrayList<Erabiltzaile> erabiltzaile = new ArrayList<Erabiltzaile>();
	Maila maila = new Maila(maila_izena, biderkatzailea, kopurua, NAN, id_maila, erabiltzaile);
	Maila maila1 = new Maila(maila_izena, biderkatzailea, kopurua, NAN, id_maila, erabiltzaile);
	@Test
	void testGettesSetters() {
		maila.setNAN(NAN);
		maila.setMaila_izena(maila_izena);
		maila.setBiderkatzailea(biderkatzailea);
		maila.setKopurua(kopurua);
		maila.setId_maila(id_maila);
		maila.setErabiltzaile(erabiltzaile);
		assertEquals(maila.getNAN(),NAN);
		assertEquals(maila.getBiderkatzailea(),biderkatzailea);
		assertEquals(maila.getId_maila(),id_maila);
		assertEquals(maila.getMaila_izena(),maila_izena);
		assertEquals(maila.getKopurua(),kopurua);
		assertEquals(maila.getErabiltzaile(),erabiltzaile);
	}
	@Test
	void testToString() {
		String expected = "Maila [maila_izena=" + maila_izena + "\nbiderkatzailea=" + biderkatzailea + "\nkopurua=" + kopurua
				+ "\nNAN=" + NAN + "\nid_maila=" + id_maila + ""+erabiltzaile+"]";
		assertEquals(expected,maila.toString());
	}
	@Test
	void testHashcode() {
	      int hashCode = maila.hashCode();
	      assertEquals(-1951604249, hashCode);
	}
	@Test
	void testEqualsTrue() {
		Maila maila = new Maila(maila_izena, biderkatzailea, kopurua, NAN, id_maila, erabiltzaile);
	    Maila maila1 = new Maila(maila_izena, biderkatzailea, kopurua, NAN, id_maila, erabiltzaile);
	    assertTrue(maila.equals(maila1));
	}
	@Test
	void testEqualsFalse() {
		Maila maila = new Maila(maila_izena, biderkatzailea, kopurua, NAN, id_maila, erabiltzaile);
        Maila maila1 = new Maila("k", 3, 6, "48987766V", 9, erabiltzaile );
        assertFalse(maila.equals(maila1));
	}
}