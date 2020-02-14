package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.adt.FilmarkivADT;

/**
 * @author Ole Olsen
 * 
 */
/* Ref: Mughal: Java som første programmeringsspråk
 * 
 * En tekstfil består av tekstlinjer. En tekstlinje består av en sekvens av 
 * tegn avsluttet med en linejavslutt-streng. Linjeavslutt-strengen er plattformavhengig.
 * 
 * Vi bruker en tegnstrøm koblet til en bytestøm. Bytes blir lest fra byte-innstrømmen
 * og oversatt til Unicode-tegn av tegn-strømmen. Motsatt, Unicode-tegn blir oversatt 
 * til bytes av tegn-utstrømmen og blir skrevet ut av bytestømmen.
 *  
 */
public class Fil {
/*  
 * OBS! I Menyen der f.eks. lesFrafil brukes, må det være try og catch-blokk.
 * 
 */
	private static final String SKILLE = "#";

	/**
	 * @param filnavn
	 * @return Referansen til Film-arkivet
	 * @throws java.io.IOException
	 */
	public static KjedetFilmarkiv lesFraFil(String filnavn)  {
		KjedetFilmarkiv filmarkiv = null;
			try {
			/*  1 - FileReader
			 *      Klassen FileReader sørger for at byte-innstrømmen blir opprettet,
			 *      sørger videre for at bytes fra filen blir tolket riktig som tegn 
			 *      i flg. tegnkodingsformatet for plattformen.
			*/    
			 FileReader ansFil = new FileReader(filnavn);
			 			 
            
			/*  2 - BufferedReader
			 *      Definerer et BufferReader-objekt som kobles til FileReader-objektet
			 *      Da når vi metoden readLine() som leser en linje.		  
			 * 			 
			 */
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den første posten som er antall info-poster
			       
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);
			filmarkiv = new KjedetFilmarkiv();

			// 4 - Les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				String sjStr = felt[4];
				Sjanger sj = Sjanger.finnSjanger(sjStr);
				String selskap = felt[5];

				Film film = new Film(nr, produsent, tittel, aar, sj, selskap);

				filmarkiv.leggTilFilm(film);
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (FileNotFoundException unntak) {// arver fra IOE.. må stå først
			                                    // hvis ikke vil unntaket for IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
		
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			
		}
      
	return filmarkiv;
       
	}// metode
	
		
	
	/**
	 * If the file does not exist, a new file will be created
	 * @throws IOException if file can't be opened
	 */
	public static void skrivTilFil(FilmarkivADT filmer, String filnavn)  {
		try {
			/* 1 - FileWriter
			 *     Definerer et FileWriter-objekt som åpner filen.
			 *     Byte-strøm blir opprettet for skriving av bytes til filen.
			 *     Tegn blir lagret i standard tegnkodingsformat for plattformen.
			 *     Hvis utvid er true, vil filen utvides ved  skriving på slutten
			 *     av filen. Hvis utvid er false, vil skrivingen starte i begynnnelsen 
			 *     av filen.			 *     
			 *     Dersom filen ikke eksisterer, vil den bli opprettet. 
			 *     Dersom filen ikke kan åpnes, vil metoden kaste et unntak av typen IOException.
			 * 
			 */
			FileWriter ansFil = new FileWriter(filnavn, false);

			/* 2 - PrintWriter
			 *     Definerer et PrintWriter-objekt som kobles til FileWriter-objektet.
			 *     PrintWriter-objektet leverer tegn til FileWriter-objektet.
			 *     FileWriter vil gi riktig koding av tegn i bytes  og lagring på fil.
			 *      
			 * 
			 */
			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = filmer.antall();
			// 3 - Skriver foerst ut antall filmer på første linje
			utfil.println(antall);
			Film[] tabell = filmer.hentFilmTabell();
			for (int i = 0; i < antall; i++) {
				// 3 - Skriver postene, felt for felt
				utfil.print(tabell[i].getFilmnr());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getProdusent());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getLanseringsAar());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getSjanger());
				utfil.print(SKILLE);
				utfil.println(tabell[i].getFilmselskap());
			} // for
				// 4 - Lukk filen
			utfil.close();
		} // try
		catch (IOException e) {
			System.out.println("Feil på skriving til fil : " + e);
		
		}

	}// metode

}// class
