package Testak;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Kontrolatzailea.metodoak;
import Kontrolatzailea.txtIdatzi;

public class TestTxtIdatzi {
	
    @Test
    public void testTxtIdatzi() {
    	String testTestua = "Test";
    	File testTxt = new File("src/LOG.txt");
    	
    	txtIdatzi txtIdatzi = new txtIdatzi();
		txtIdatzi.idatzi(testTestua);
    	
    	assertTrue(testTxt.exists());
    	
    	List<String> lerroak = new ArrayList<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(testTxt))) {
    		String line;
    		while ((line = br.readLine()) != null) {
    			lerroak.add(line);
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}