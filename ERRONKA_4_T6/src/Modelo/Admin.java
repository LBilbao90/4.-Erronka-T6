package Modelo;

import java.util.Date;
import java.util.Objects;

public class Admin extends Pertsona {
	
	private String kargua;
	private Double soldata;
	private int id_langile;
	private int id_kasino;
	private String postaElektronikoa;
	
	public Admin(String nAN, 
			String izena, 
			String abizena, 
			Date jaioteguna, 
			String herrialdea,
			String probintzia, 
			String herria, 
			String postaKodea,
			String pasahitza, 
			String tlf_zenabkia, 
			int id_maila, 
			String kargua, 
			Double soldata, 
			int id_langile, 
			int id_kasino,
			String postaElString) {
		super(nAN, izena, abizena, jaioteguna, herrialdea, probintzia, herria, postaKodea, pasahitza, tlf_zenabkia, id_maila);
		this.kargua = kargua;
		this.soldata = soldata;
		this.id_langile = id_langile;
		this.id_kasino = id_kasino;
		this.postaElektronikoa= postaElString;
	}
	
	public Admin() {
		super();
	}

	public String getKargua() {
		return kargua;
	}

	public Double getSoldata() {
		return soldata;
	}

	public int getId_langile() {
		return id_langile;
	}

	public int getId_kasino() {
		return id_kasino;
	}

	public void setKargua(String kargua) {
		this.kargua = kargua;
	}

	public void setSoldata(Double soldata) {
		this.soldata = soldata;
	}

	public void setId_langile(int id_langile) {
		this.id_langile = id_langile;
	}

	public void setId_kasino(int id_kasino) {
		this.id_kasino = id_kasino;
	}

	public String getPostaElektronikoa() {
		return postaElektronikoa;
	}

	public void setPostaElektronikoa(String postaElektronikoa) {
		this.postaElektronikoa = postaElektronikoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id_kasino, id_langile, kargua, postaElektronikoa, soldata);
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
		Admin other = (Admin) obj;
		return id_kasino == other.id_kasino && id_langile == other.id_langile && Objects.equals(kargua, other.kargua)
				&& Objects.equals(postaElektronikoa, other.postaElektronikoa) && Objects.equals(soldata, other.soldata);
	}

	@Override
	public String toString() {
		return "Admin [kargua=" + kargua + ", soldata=" + soldata + ", id_langile=" + id_langile + ", id_kasino="
				+ id_kasino + ", NAN=" + NAN +  ", izena=" + izena + ", abizena=" + abizena + ", jaioteguna=" + jaioteguna
						+  ", herrialdea=" + herrialdea + ", probintzia=" + probintzia + ", herria=" + herria + ", postaKodea="
						+ postaKodea + ", pasahitza=" + pasahitza + ", tlf_zenabkia=" + tlf_zenabkia + ", postaElektronikoa=" + postaElektronikoa + "]";
	}


}
