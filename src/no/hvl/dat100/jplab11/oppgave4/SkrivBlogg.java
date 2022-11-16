package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		try {
		String tekst = samling.toString();
		String[] sep = tekst.split("\n");
		PrintWriter skriver = new PrintWriter(filnavn);
	
		

		for(int i = 0; i < sep.length;i++) {
			skriver.println(sep[i]);
	
		}
		
		skriver.close();
		
		}
		catch(FileNotFoundException e) {
			System.out.println("Ugyldig filnavn");
			return false;
		}
		finally {
			return true;
		}
		
		
		
	}
}
