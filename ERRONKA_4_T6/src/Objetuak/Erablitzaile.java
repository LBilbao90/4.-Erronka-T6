package Objetuak;

import java.util.Date;
import java.util.Objects;

public class Erablitzaile extends Pertsona{
	private String erabiltzaile_izena;
	private double diru_kopuru_historikoa;
	private double diru_kopuru_momentukoa;
	
	public Erablitzaile(String nAN, String izena, String abizena, Date jaioteguna, String herrialdea,
			String autonomia_erkidegoa, String probintzia, String herria, String postaKodea, String posta_elektronikoa,
			String pasahitza, String tlf_zenabkia, String erabiltzaile_izena, double diru_kopuru_historikoa,
			double diru_kopuru_momentukoa) {
		super(nAN, izena, abizena, jaioteguna, herrialdea, autonomia_erkidegoa, probintzia, herria, postaKodea,
				posta_elektronikoa, pasahitza, tlf_zenabkia);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diru_kopuru_historikoa, diru_kopuru_momentukoa, erabiltzaile_izena);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Erablitzaile other = (Erablitzaile) obj;
		return Double.doubleToLongBits(diru_kopuru_historikoa) == Double.doubleToLongBits(other.diru_kopuru_historikoa)
				&& Double.doubleToLongBits(diru_kopuru_momentukoa) == Double
						.doubleToLongBits(other.diru_kopuru_momentukoa)
				&& Objects.equals(erabiltzaile_izena, other.erabiltzaile_izena);
	}

	@Override
	public String toString() {
		return "Erablitzaile [erabiltzaile_izena=" + erabiltzaile_izena + "\ndiru_kopuru_historikoa="
				+ diru_kopuru_historikoa + "\ndiru_kopuru_momentukoa=" + diru_kopuru_momentukoa + "\nNAN=" + NAN
				+ "\nizena=" + izena + "\nabizena=" + abizena + "\njaioteguna=" + jaioteguna + "\nherrialdea="
				+ herrialdea + "\nautonomia_erkidegoa=" + autonomia_erkidegoa + "\nprobintzia=" + probintzia
				+ "\nherria=" + herria + "\npostaKodea=" + postaKodea + "\nposta_elektronikoa=" + posta_elektronikoa
				+ "\npasahitza=" + pasahitza + "\ntlf_zenabkia=" + tlf_zenabkia + "]";
	}
	
	
}
