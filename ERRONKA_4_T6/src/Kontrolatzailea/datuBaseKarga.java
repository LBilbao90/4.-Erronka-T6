package Kontrolatzailea;

import java.sql.Connection;

public class datuBaseKarga {
	
	
	final String url = "jdbc:mysql://localhost:3306/kasinoa";
	final String erabiltzaileKontsulta = "NAN, id_maila, diru_kopuru_momentutakoa, erabiltzaile_izena pasahitza";
	final String langileKontsulta = "id_Langile, NAN, izena, kargu";
	final String mailaKontsulta = "id_maila, izena, apostua_max";

	Connection connection = null;
	
}
