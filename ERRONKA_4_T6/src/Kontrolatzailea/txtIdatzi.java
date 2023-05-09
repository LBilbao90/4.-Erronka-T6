package Kontrolatzailea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Modelo.Fitxategiak;

public class txtIdatzi implements Fitxategiak{
	
	@Override
	public void idatzi(String testua) {
 		File txt = new File("src/LOG.txt");
 		try {
 			BufferedWriter bw = new BufferedWriter(new FileWriter(txt, true));
 			bw.write("\n" + testua);
 			bw.close();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}		
	}

}
