package Modelo;

import java.util.Objects;

public class KasinoErabiltzaile {

	private int Id_Kasino;
	private String NAN;
	
	public KasinoErabiltzaile(int id_Kasino, String nAN) {
		super();
		Id_Kasino = id_Kasino;
		NAN = nAN;
	}
	
	public KasinoErabiltzaile() {
	}
	
	public int getId_Kasino() {
		return Id_Kasino;
	}
	public void setId_Kasino(int id_Kasino) {
		Id_Kasino = id_Kasino;
	}
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nAN) {
		NAN = nAN;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_Kasino, NAN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KasinoErabiltzaile other = (KasinoErabiltzaile) obj;
		return Id_Kasino == other.Id_Kasino && NAN == other.NAN;
	}

	@Override
	public String toString() {
		return "KasinoErabiltzaile [Id_Kasino=" + Id_Kasino + ", NAN=" + NAN + "]";
	}
	
}