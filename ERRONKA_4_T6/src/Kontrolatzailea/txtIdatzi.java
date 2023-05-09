package Kontrolatzailea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Modelo.Fitxategiak;

public class txtIdatzi implements Fitxategiak{
	
	/**
	 * 'src/LOG.txt' barruan, apostuen LOG-ak gehitzeko metodoa.
	 * @param testua | 'LOG.txt' barruan sartuko den testua. (String)
	 * @author 6.Taldea
	 */
	@Override
	public void idatzi(String testua) {
		// Fitxategiaren kokalekua
 		File txt = new File("src/LOG.txt");
 		try {
 			// 'testua' 'txt'-barruan idazten du.
 			BufferedWriter bw = new BufferedWriter(new FileWriter(txt, true));
 			bw.write("\n" + testua);
 			bw.close();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}		
	}

}
