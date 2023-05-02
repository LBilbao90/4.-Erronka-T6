package Modelo;

import java.util.Date;
import java.util.Objects;

public class Erabiltzaile extends Pertsona{
	private double diru_kopuru_historikoa;
	private double diru_kopuru_momentukoa;
	
	public Erabiltzaile(String nAN, String izena, String abizena, String jaioteguna, String herrialdea, String probintzia, String herria, String postaKodea,
			String pasahitza, String tlf_zenabkia, int id_maila, double diru_kopuru_historikoa,
			double diru_kopuru_momentukoa) {
		super(nAN, izena, abizena, jaioteguna, herrialdea, probintzia, herria, postaKodea, pasahitza, tlf_zenabkia, id_maila);
		this.diru_kopuru_historikoa = diru_kopuru_historikoa;
		this.diru_kopuru_momentukoa = diru_kopuru_momentukoa;
	}

	public Erabiltzaile() {
		super();
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

	public String erakutsi() {
		return "Datuak:\n" +"\ndiru kopuru historikoa:"+diru_kopuru_historikoa
				+"\ndiru kopuru momentukoa:"+diru_kopuru_momentukoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diru_kopuru_historikoa, diru_kopuru_momentukoa);
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
		Erabiltzaile other = (Erabiltzaile) obj;
		return Double.doubleToLongBits(diru_kopuru_historikoa) == Double.doubleToLongBits(other.diru_kopuru_historikoa)
				&& Double.doubleToLongBits(diru_kopuru_momentukoa) == Double
						.doubleToLongBits(other.diru_kopuru_momentukoa);
	}

	@Override
	public String toString() {
		return "Erabiltzaile [NAN=" + NAN + ", izena=" + izena + ", abizena=" + abizena + ", jaioteguna=" + jaioteguna
				+ ", herrialdea=" + herrialdea + ", probintzia=" + probintzia + ", herria=" + herria + ", postaKodea="
				+ postaKodea + ", pasahitza=" + pasahitza + ", tlf_zenabkia=" + tlf_zenabkia + ", diru_kopuru_historikoa=" + diru_kopuru_historikoa + ", diru_kopuru_momentukoa="
				+ diru_kopuru_momentukoa + "]";
	}
}