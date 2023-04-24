package Modelo;

import java.util.Date;
import java.util.Objects;

public class Admin extends Pertsona {
	
	private String kargua;
	private Double soldata;
	private int id_langile;
	private int id_kasino;
	
	public Admin(String nAN, String izena, String abizena, Date jaioteguna, String herrialdea,
			String autonomia_erkidegoa, String probintzia, String herria, String postaKodea, String posta_elektronikoa,
			String pasahitza, String tlf_zenabkia, String kargua, Double soldata, int id_langile, int id_kasino) {
		super(nAN, izena, abizena, jaioteguna, herrialdea, autonomia_erkidegoa, probintzia, herria, postaKodea,
				posta_elektronikoa, pasahitza, tlf_zenabkia);
		this.kargua = kargua;
		this.soldata = soldata;
		this.id_langile = id_langile;
		this.id_kasino = id_kasino;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id_kasino, id_langile, kargua, soldata);
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
				&& Objects.equals(soldata, other.soldata);
	}

	@Override
	public String toString() {
		return "Admin [kargua=" + kargua + "\nsoldata=" + soldata + "\nid_langile=" + id_langile + "\nid_kasino="
				+ id_kasino + "\nNAN=" + NAN + "\nizena=" + izena + "\nabizena=" + abizena + "\njaioteguna="
				+ jaioteguna + "\nherrialdea=" + herrialdea + "\nautonomia_erkidegoa=" + autonomia_erkidegoa
				+ "\nprobintzia=" + probintzia + "\nherria=" + herria + "\npostaKodea=" + postaKodea
				+ "\nposta_elektronikoa=" + posta_elektronikoa + "\npasahitza=" + pasahitza + "\ntlf_zenabkia="
				+ tlf_zenabkia + "]";
	}
}
