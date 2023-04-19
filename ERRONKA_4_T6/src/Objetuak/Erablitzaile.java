package Objetuak;

public class Erablitzaile extends Pertsona{
	private String erabiltzaile_izena;
	private double diru_kopuru_historikoa;
	private double diru_kopuru_momentukoa;
	
	public Erablitzaile(String erabiltzaile_izena, double diru_kopuru_historikoa, double diru_kopuru_momentukoa) {
		super();
		this.erabiltzaile_izena = erabiltzaile_izena;
		this.diru_kopuru_historikoa = diru_kopuru_historikoa;
		this.diru_kopuru_momentukoa = diru_kopuru_momentukoa;
	}
	
	public String getErabiltzaile_izena() {
		return erabiltzaile_izena;
	}
	public void setErabiltzaile_izena(String erabiltzaile_izena) {
		this.erabiltzaile_izena = erabiltzaile_izena;
	}
	public double getDiru_kopuru_historikoa() {
		return diru_kopuru_historikoa;
	}
	public void setDiru_kopuru_historikoa(double diru_kopuru_historikoa) {
		this.diru_kopuru_historikoa = diru_kopuru_historikoa;
	}
	public double getDiru_kopuru_momentukoa() {
		return diru_kopuru_momentukoa;
	}
	public void setDiru_kopuru_momentukoa(double diru_kopuru_momentukoa) {
		this.diru_kopuru_momentukoa = diru_kopuru_momentukoa;
	}
	public void erakutsi() {
		System.out.println("Datuak: "/*super. (pertsonen datuak hemen erakusten ditugu ere)*/
			+erabiltzaile_izena+", diru kopuru historikoa:"+diru_kopuru_historikoa
				+", diru kopuru momentukoa:"+diru_kopuru_momentukoa);
	}
}
