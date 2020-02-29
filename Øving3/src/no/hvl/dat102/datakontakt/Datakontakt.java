package no.hvl.dat102.datakontakt;

import java.util.Iterator;

import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {
	private TabellMengde<Medlem> medlemstabell;
	private int antallMedlemmer = medlemstabell.antall();

	public Datakontakt() {
		medlemstabell = new TabellMengde<Medlem>();
	}

	public Datakontakt(int start) {
		medlemstabell = new TabellMengde<Medlem>(start);
	}

	public void leggTilMedlem(Medlem person) {
		medlemstabell.leggTil(person);
	}

	public TabellMengde<Medlem> getMedlemstabell() {
		return medlemstabell;
	}

	public int getAntall() {
		return antallMedlemmer;
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
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

	public Medlem hentMedlem(String medlemsnavn) {
		int m1indeks = finnMedlemsIndeks(medlemsnavn);
		return (m1indeks == -1) ? null : medlemstabell.getTab()[m1indeks];
	}

	public int finnPartnerFor(String medlemsnavn) {
		int funnet = -1;
		int m1indeks = finnMedlemsIndeks(medlemsnavn);
		Iterator<Medlem> teller = medlemstabell.oppramser();
		int pos = 0;

		if (m1indeks != -1) {
			Medlem m1 = medlemstabell.getTab()[m1indeks];
			if (m1.getStatusIndeks() != -1) {
				while (teller.hasNext() && funnet == -1) {
					Medlem m2 = teller.next();
	
					if (m1.passerTil(m2) && m2.getStatusIndeks() != -1) {
						funnet = pos;
						m1.setStatusIndeks(pos);
						m2.setStatusIndeks(m1indeks);
					} else {
						pos++;
					}
				}
			}
		}

		return funnet;
	}

	public void tilbakestillStatusIndeks(String medlemsnavn) {
		Medlem medlem = hentMedlem(medlemsnavn);
		if (medlem != null) {
			medlem.setStatusIndeks(-1);
		}
	}
}
