
package Testak;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import Objetuak.Maila;

class TestMaila {
	String maila_izena = "Bronce";
	double biderkatzailea = 2;
	int kopurua = 4;
	String NAN = "48987755P";
	int id_maila = 1;
	Maila maila = new Maila(maila_izena, biderkatzailea, kopurua, NAN, id_maila);
	Maila maila1 = new Maila(maila_izena, biderkatzailea, kopurua, NAN, id_maila);
	@Test
	void testGettesSetters() {
		maila.setNAN(NAN);
		maila.setMaila_izena(maila_izena);
		maila.setBiderkatzailea(biderkatzailea);
		maila.setKopurua(kopurua);
		maila.setId_maila(id_maila);
		assertEquals(maila.getNAN(),NAN);
		assertEquals(maila.getBiderkatzailea(),biderkatzailea);
		assertEquals(maila.getId_maila(),id_maila);
		assertEquals(maila.getMaila_izena(),maila_izena);
		assertEquals(maila.getKopurua(),kopurua);
	}
	@Test
	void testToString() {
		String expected = "Maila [maila_izena=" + maila_izena + "\nbiderkatzailea=" + biderkatzailea + "\nkopurua=" + kopurua
				+ "\nNAN=" + NAN + "\nid_maila=" + id_maila + "]";
		assertEquals(expected,maila.toString());
	}
	@Test
	void testHashcode() {
	      int hashCode = maila.hashCode();
	      assertEquals(1876707674, hashCode);
	}
	@Test
	void testEqualsTrue() {
		Maila maila = new Maila(maila_izena, biderkatzailea, kopurua, NAN, id_maila);
	    Maila maila1 = new Maila(maila_izena, biderkatzailea, kopurua, NAN, id_maila);
	    assertTrue(maila.equals(maila1));
	}
	@Test
	void testEqualsFalse() {
		Maila maila = new Maila(maila_izena, biderkatzailea, kopurua, NAN, id_maila);
        Maila maila1 = new Maila("k", 3, 6, "48987766V", 9);
        assertFalse(maila.equals(maila1));
	}
}