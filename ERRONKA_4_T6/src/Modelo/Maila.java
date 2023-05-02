package Modelo;

import java.util.Objects;

public class Maila {
	private String maila_izena;
	private double apostu_max;
	protected int id_maila;

	public Maila(String maila_izena, double apostu_max, int id_maila) {
		super();
		this.maila_izena = maila_izena;
		this.apostu_max = apostu_max;
		this.id_maila = id_maila;
	}

	public Maila(int id_maila) {
		super();
		this.id_maila = id_maila;
	}

	public Maila() {
	}

	public String getMaila_izena() {
		return maila_izena;
	}


	public double getApostu_max() {
		return apostu_max;
	}

	public void setApostu_max(double apostu_max) {
		this.apostu_max = apostu_max;
	}

	public int getId_maila() {
		return id_maila;
	}

	public void setMaila_izena(String maila_izena) {
		this.maila_izena = maila_izena;
	}



	public void setId_maila(int id_maila) {
		this.id_maila = id_maila;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id_maila, apostu_max, maila_izena);
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
		return Objects.equals(id_maila, other.id_maila);
	}

	@Override
	public String toString() {
		return "Maila [maila_izena=" + maila_izena + "\napostu_max=" + apostu_max
				 + "\nid_maila=" + id_maila +"]";
	}
	
	
}

