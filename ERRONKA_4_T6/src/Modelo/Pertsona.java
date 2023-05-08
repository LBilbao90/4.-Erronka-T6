package Modelo;

import java.util.Date;
import java.util.Objects;

public abstract class Pertsona extends Maila{

	protected String NAN;
	protected String izena;
	protected static String abizena;
	protected Date jaioteguna;
	protected String herrialdea;
	//protected String autonomia_erkidegoa;
	protected String probintzia;
	protected String herria;
	protected String postaKodea;
	//protected String posta_elektronikoa;
	protected String pasahitza;
	protected String tlf_zenabkia;
	
	public Pertsona(String nAN, String izena, String abizena, Date string, String herrialdea, String probintzia, String herria, String postaKodea,String pasahitza, String tlf_zenabkia, int id_maila) {
		super(id_maila);
		this.NAN = nAN;
		this.izena = izena;
		this.abizena = abizena;
		this.jaioteguna = string;
		this.herrialdea = herrialdea;
		//this.autonomia_erkidegoa = autonomia_erkidegoa;
		this.probintzia = probintzia;
		this.herria = herria;
		this.postaKodea = postaKodea;
		//this.posta_elektronikoa = posta_elektronikoa;
		this.pasahitza = pasahitza;
		this.tlf_zenabkia = tlf_zenabkia;
	}
	
	

	public Pertsona() {
		super();
	}

	public String getNAN() {
		return NAN;
	}

	public String getIzena() {
		return izena;
	}

	public static String getAbizena() {
		return abizena;
	}

	public Date getJaioteguna() {
		return jaioteguna;
	}

	public String getHerrialdea() {
		return herrialdea;
	}

//	public String getAutonomia_erkidegoa() {
//		return autonomia_erkidegoa;
//	}

	public String getProbintzia() {
		return probintzia;
	}

	public String getHerria() {
		return herria;
	}

	public String getPostaKodea() {
		return postaKodea;
	}

//	public String getPosta_elektronikoa() {
//		return posta_elektronikoa;
//	}

	public String getPasahitza() {
		return pasahitza;
	}

	public String getTlf_zenabkia() {
		return tlf_zenabkia;
	}

	public void setNAN(String nAN) {
		NAN = nAN;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public void setJaioteguna(Date string) {
		this.jaioteguna = string;
	}

	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}

//	public void setAutonomia_erkidegoa(String autonomia_erkidegoa) {
//		this.autonomia_erkidegoa = autonomia_erkidegoa;
//	}

	public void setProbintzia(String probintzia) {
		this.probintzia = probintzia;
	}

	public void setHerria(String herria) {
		this.herria = herria;
	}

	public void setPostaKodea(String postaKodea) {
		this.postaKodea = postaKodea;
	}

//	public void setPosta_elektronikoa(String posta_elektronikoa) {
//		this.posta_elektronikoa = posta_elektronikoa;
//	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public void setTlf_zenabkia(String tlf_zenabkia) {
		this.tlf_zenabkia = tlf_zenabkia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(NAN, abizena, herria, herrialdea, izena, jaioteguna, pasahitza,
				postaKodea, probintzia, tlf_zenabkia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pertsona other = (Pertsona) obj;
		return Objects.equals(NAN, other.NAN);
	}



	@Override
	public String toString() {
		return "Pertsona [NAN=" + NAN + ", izena=" + izena + ", abizena=" + abizena + ", jaioteguna=" + jaioteguna
				+ ", herrialdea=" + herrialdea + ", probintzia=" + probintzia + ", herria=" + herria + ", postaKodea="
				+ postaKodea + ", pasahitza=" + pasahitza + ", tlf_zenabkia=" + tlf_zenabkia + "]";
	}
	
//	@Override
//	public String toString() {
//		return "Pertsona [NAN=" + NAN + "\nizena=" + izena + "\nabizena=" + abizena + "\njaioteguna=" + jaioteguna
//				+ "\nherrialdea=" + herrialdea + "\nautonomia_erkidegoa=" + autonomia_erkidegoa + "\nprobintzia="
//				+ probintzia + "\nherria=" + herria + "\npostaKodea=" + postaKodea + "\nposta_elektronikoa="
//				+ posta_elektronikoa + "\npasahitza=" + pasahitza + "\ntlf_zenabkia=" + tlf_zenabkia + "]";
//	}

	
	
	
	
	
}

