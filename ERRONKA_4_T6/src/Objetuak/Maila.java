package Objetuak;

import java.util.Objects;

public class Maila {
	private String maila_izena;
	private double biderkatzailea;
	private int kopurua;
	private String NAN;
	private int id_maila;
	
	public Maila(String maila_izena, double biderkatzailea, int kopurua, String nAN, int id_maila) {
		this.maila_izena = maila_izena;
		this.biderkatzailea = biderkatzailea;
		this.kopurua = kopurua;
		this.NAN = nAN;
		this.id_maila = id_maila;
	}

	public String getMaila_izena() {
		return maila_izena;
	}

	public double getBiderkatzailea() {
		return biderkatzailea;
	}

	public int getKopurua() {
		return kopurua;
	}

	public String getNAN() {
		return NAN;
	}

	public int getId_maila() {
		return id_maila;
	}

	public void setMaila_izena(String maila_izena) {
		this.maila_izena = maila_izena;
	}

	public void setBiderkatzailea(double biderkatzailea) {
		this.biderkatzailea = biderkatzailea;
	}

	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}

	public void setNAN(String nAN) {
		this.NAN = nAN;
	}

	public void setId_maila(int id_maila) {
		this.id_maila = id_maila;
	}

	@Override
	public int hashCode() {
		return Objects.hash(NAN, biderkatzailea, id_maila, kopurua, maila_izena);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maila other = (Maila) obj;
		return Objects.equals(NAN, other.NAN)
				&& Double.doubleToLongBits(biderkatzailea) == Double.doubleToLongBits(other.biderkatzailea)
				&& id_maila == other.id_maila && kopurua == other.kopurua
				&& Objects.equals(maila_izena, other.maila_izena);
	}

	@Override
	public String toString() {
		return "Maila [maila_izena=" + maila_izena + "\nbiderkatzailea=" + biderkatzailea + "\nkopurua=" + kopurua
				+ "\nNAN=" + NAN + "\nid_maila=" + id_maila + "]";
	}
	
	
}
	