package Objetuak;

import java.util.Date;
import java.util.Objects;

public class Baimena {
	
	private String erabiltzailea;
	private int baimen_mota;
	private Date hasiera_data;
	private Date bukaera_data;
	
	private Pertsona pertsona;
	
	//CONSTRUCTOR
	public Baimena(String erabiltzailea, int baimen_mota, Date hasiera_data, Date bukaera_data, Pertsona pertsona) {
		super();
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


	public Pertsona getPertsona() {
		return pertsona;
	}
	public void setPertsona(Pertsona pertsona) {
		this.pertsona = pertsona;
	}

	
	//METODOAK
	public int baimena_artu(int nahai_duen_baimena) {
		
		if( this.baimen_mota == nahai_duen_baimena) {
			return baimen_mota;
		}else{
			return -1;
		}
		
		
	}
	
	
	public void baimena_kanporatu(int baimena_kanp, String erabiltzailea) {
		
		if(this.baimen_mota == baimena_kanp && this.erabiltzailea.equalsIgnoreCase(erabiltzailea)) {
			
		}else {}
	
	}
	
	
	public boolean balidatu_erabiltzailea_baimenarako() {
		
		return false;
	}
	

	//TOESTRING
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
		return baimen_mota == other.baimen_mota && Objects.equals(bukaera_data, other.bukaera_data)
				&& Objects.equals(erabiltzailea, other.erabiltzailea)
				&& Objects.equals(hasiera_data, other.hasiera_data) && Objects.equals(pertsona, other.pertsona);
	}
	

}
