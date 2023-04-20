package Objetuak;

import java.util.Objects;

public class Kasinoa {
	protected int id_kasinoa;
	protected String izena;
	protected String helbidea;
	protected int telefonoa;

	public Kasinoa(int id_kasinoa, String izena, String helbidea, int telefonoa) {
		super();
		this.id_kasinoa = id_kasinoa;
		this.izena = izena;
		this.helbidea = helbidea;
		this.telefonoa = telefonoa;
	}
	
	public int getId_kasinoa() {
		return id_kasinoa;
	}
	public void setId_kasinoa(int id_kasinoa) {
		this.id_kasinoa = id_kasinoa;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getHelbidea() {
		return helbidea;
	}
	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}
	public int getTelefonoa() {
		return telefonoa;
	}
	public void setTelefonoa(int telefonoa) {
		this.telefonoa = telefonoa;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(helbidea, id_kasinoa, izena, telefonoa);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kasinoa other = (Kasinoa) obj;
		return Objects.equals(helbidea, other.helbidea) && id_kasinoa == other.id_kasinoa
				&& Objects.equals(izena, other.izena) && telefonoa == other.telefonoa;
	}
	
	@Override
	public String toString() {
		return "Kasinoa: id_kasinoa=" + id_kasinoa+ "/n izena=" + izena + "/n helbidea=" + helbidea + "/n telefonoa="
				+ telefonoa + ""; 
	}
}
