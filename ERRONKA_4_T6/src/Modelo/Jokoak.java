package Modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Jokoak extends Kasinoa {

	private int id_jokoak;
	private String jokoIzena;
	private double maxApostu;


	public Jokoak(int id_kasinoa, String izena, String helbidea, int telefonoa, ArrayList<Jokoak> jokoak) {
		super(id_kasinoa, izena, helbidea, telefonoa, jokoak);
	}


	public Jokoak(int id_kasinoa) {
		super(id_kasinoa);
	}


	public int getId_jokoak() {
		return id_jokoak;
	}


	public String getJokoIzena() {
		return jokoIzena;
	}


	public double getMaxApostu() {
		return maxApostu;
	}


	public void setId_jokoak(int id_jokoak) {
		this.id_jokoak = id_jokoak;
	}


	public void setJokoIzena(String jokoIzena) {
		this.jokoIzena = jokoIzena;
	}


	public void setMaxApostu(double maxApostu) {
		this.maxApostu = maxApostu;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id_jokoak, jokoIzena, maxApostu);
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
		Jokoak other = (Jokoak) obj;
		return id_jokoak == other.id_jokoak && Objects.equals(jokoIzena, other.jokoIzena)
				&& Double.doubleToLongBits(maxApostu) == Double.doubleToLongBits(other.maxApostu);
	}


	@Override
	public String toString() {
		return "Jokoak [id_jokoak=" + id_jokoak + ", jokoIzena=" + jokoIzena + ", maxApostu=" + maxApostu
				+ ", id_kasinoa=" + id_kasinoa + "]";
	}
	
}
