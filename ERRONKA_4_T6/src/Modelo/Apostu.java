package Modelo;

import java.util.Objects;

public class Apostu {
	
	private int id_apustua;
	private int id_joko;
	private String NAN;
	private int apostu_kantitatea;
	private int apostu_emaitza;
	
	//KONSTRUKTOREA
	public Apostu(int id_apustua, int id_joko, String nAN, int apostu_kantitatea, int apostu_emaitza) {
		this.id_apustua = id_apustua;
		this.id_joko = id_joko;
		NAN = nAN;
		this.apostu_kantitatea = apostu_kantitatea;
		this.apostu_emaitza = apostu_emaitza;
	}
	
	//GETTERS & SETTERS
	public int getId_apustua() {
		return id_apustua;
	}
	
	public void setId_apustua(int id_apustua) {
		this.id_apustua = id_apustua;
	}
	public int getId_joko() {
		return id_joko;
	}
	public void setId_joko(int id_joko) {
		this.id_joko = id_joko;
	}
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nAN) {
		NAN = nAN;
	}

	public int getApostu_kantitatea() {
		return apostu_kantitatea;
	}
	public void setApostu_kantitatea(int apostu_kantitatea) {
		this.apostu_kantitatea = apostu_kantitatea;
	}
	public int getApostu_emaitza() {
		return apostu_emaitza;
	}
	public void setApostu_emaitza(int apostu_emaitza) {
		this.apostu_emaitza = apostu_emaitza;
	}
	
	
	//METODOAK
	
	public void apustua_egin() {
		
	}

	//TOESTRING
	
	@Override
	public String toString() {
		return "Apustuak [id_apustua=" + id_apustua + ", id_joko=" + id_joko + ", NAN=" + NAN + ", apostu_kantitatea="
				+ apostu_kantitatea + ", apostu_emaitza=" + apostu_emaitza + "]";
	}
	
	//HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(apostu_emaitza, apostu_emaitza, NAN, apostu_emaitza, apostu_emaitza);
	}

	//EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apostu other = (Apostu) obj;
		return Objects.equals(id_apustua, other.id_apustua);
	}

}
