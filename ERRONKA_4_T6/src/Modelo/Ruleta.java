package Modelo;

import java.util.Objects;

public class Ruleta{
	
	protected int apustu_kopuru_max;
	protected int apustua;

	public Ruleta(int apustu_kopuru_max, int apustua) {
		this.apustu_kopuru_max = apustu_kopuru_max;
		this.apustua = apustua;
	}
	
	public int getApustu_kopuru_max() {
		return apustu_kopuru_max;
	}
	public void setApustu_kopuru_max(int apustu_kopuru_max) {
		this.apustu_kopuru_max = apustu_kopuru_max;
	}
	public int getApustua() {
		return apustua;
	}
	public void setApustua(int apustua) {
		this.apustua = apustua;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apustu_kopuru_max, apustua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ruleta other = (Ruleta) obj;
		return apustu_kopuru_max == other.apustu_kopuru_max && apustua == other.apustua;
	}

	@Override
	public String toString() {
		return "Ruleta apustu_kopuru_max=" + apustu_kopuru_max + "/n apustua=" + apustua + "";
	}
}

