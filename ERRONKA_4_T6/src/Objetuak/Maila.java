package Objetuak;

public class Maila {
	private String maila_izena;
	private double biderkatzailea;
	private int kopurua;
	private String NAN;
	private int id_maila;
	
	
	public Maila(String maila_izena, double biderkatzailea, int kopurua, String nan, int id_maila) {
		this.maila_izena = maila_izena;
		this.biderkatzailea = biderkatzailea;
		this.kopurua = kopurua;
		this.NAN = nan;
		this.id_maila = id_maila;
	}
	
	public String getMaila_izena() {
		return maila_izena;
	}
	public void setMaila_izena(String maila_izena) {
		this.maila_izena = maila_izena;
	}
	public double getBiderkatzailea() {
		return biderkatzailea;
	}
	public void setBiderkatzailea(double biderkatzailea) {
		this.biderkatzailea = biderkatzailea;
	}
	public int getKopurua() {
		return kopurua;
	}
	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nan) {
		NAN = nan;
	}
	public int getId_maila() {
		return id_maila;
	}
	public void setId_maila(int id_maila) {
		this.id_maila = id_maila;
	}
}
	