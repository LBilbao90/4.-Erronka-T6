package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Baimena {
	
	private String erabiltzailea;
	private int baimen_mota;
	private Date hasiera_data;
	private Date bukaera_data;
	private ArrayList<Pertsona> pertsona;
	
	//KONSTRUKTOREA
	public Baimena(String erabiltzailea, int baimen_mota, Date hasiera_data, Date bukaera_data, ArrayList<Pertsona> pertsona) {
		this.erabiltzailea = erabiltzailea;
		this.baimen_mota = baimen_mota;
		this.hasiera_data = hasiera_data;
		this.bukaera_data = bukaera_data;
		this.pertsona = pertsona;
	}


	//GETTERS & SETTERS
	public String getErabiltzailea() {
		return erabiltzailea;
	}
	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	public int getBaimen_mota() {
		return baimen_mota;
	}
	
	public void setBaimen_mota(int baimen_mota) {
		this.baimen_mota = baimen_mota;
	}

	public Date getHasiera_data() {
		return hasiera_data;
	}
	
	public void setHasiera_data(Date hasiera_data) {
		this.hasiera_data = hasiera_data;
	}


	public Date getBukaera_data() {
		return bukaera_data;
	}
	public void setBukaera_data(Date bukaera_data) {
		this.bukaera_data = bukaera_data;
	}
	
	public ArrayList<Pertsona> getPertsona() {
		return pertsona;
	}

	public void setPertsona(ArrayList<Pertsona> pertsona) {
		this.pertsona = pertsona;
	}
	

	//TO STRING
	@Override
	public String toString() {
		return "Baimena [erabiltzailea=" + erabiltzailea + ", baimen_mota=" + baimen_mota + ", hasiera_data="
				+ hasiera_data + ", bukaera_data=" + bukaera_data + ", pertsona=" + pertsona + "]";
	}
	
	//HASCHODE
	@Override
	public int hashCode() {
		return Objects.hash(baimen_mota, bukaera_data, erabiltzailea, hasiera_data, pertsona);
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
		Baimena other = (Baimena) obj;
		return Objects.equals(baimen_mota, other.baimen_mota);
	}
}
