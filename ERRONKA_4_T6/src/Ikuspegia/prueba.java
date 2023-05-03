package Ikuspegia;

import java.util.ArrayList;

import Kontrolatzailea.datuBaseKarga;
import Modelo.Admin;
import Modelo.Erabiltzaile;
import Modelo.Maila;

public class prueba {
private static ArrayList<Erabiltzaile> erabiltzaileak;
private static ArrayList<Admin> langileak;
private static ArrayList<Maila> mailak;

	public static void main(String[] args) {
		
        erabiltzaileak = new ArrayList<>();
        langileak = new ArrayList<>();
        mailak = new ArrayList<>();
        
		datuBaseKarga.karga();
		System.out.println(datuBaseKarga.getErabiltzaileak());
	
    }
}
