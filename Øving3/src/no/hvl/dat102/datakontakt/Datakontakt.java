package no.hvl.dat102.datakontakt;

import java.util.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {
	private static TabellMengde<Medlem> medlemstabell;
	private int antallMedlemmer = medlemstabell.antall();

	public Datakontakt() {
		medlemstabell = new TabellMengde<Medlem>();
	}

	public Datakontakt(int start) {
		medlemstabell = new TabellMengde<Medlem>(start);
	}

	public static void leggTilMedlem(Medlem person) {
		medlemstabell.leggTil(person);
	}
	
	public int getAntall() {
		return this.antallMedlemmer;
	}

	public static int finnMedlemsIndeks(String medlemsnavn) {
		int funnet = -1;
		Iterator<Medlem> teller = medlemstabell.oppramser();
		int pos = 0;
		
		while (teller.hasNext() && funnet == -1) {
			if (teller.next().getNavn().equals(medlemsnavn)) {
				funnet = pos;
			} else {
				pos++;
			}
		}
		
		return funnet;
	}

	public static int finnPartnerFor(String medlemsnavn) {
		int funnet = -1;
		int m1indeks = finnMedlemsIndeks(medlemsnavn);
		Iterator<Medlem> teller = medlemstabell.oppramser();
		int pos = 0;

		if (m1indeks != -1) {
			Medlem m1 = medlemstabell.getTab()[m1indeks];

			while (teller.hasNext() && funnet == -1) {
				Medlem m2 = teller.next();

				if (m1.passerTil(m2)) {
					funnet = pos;
					m1.setStatusIndeks(pos);
					m2.setStatusIndeks(m1indeks);
				} else {
					pos++;
				}
			}
		}

		return funnet;
	}

	public static void tilbakestillStatusIndeks(String medlemsnavn) {
		
	}
}
