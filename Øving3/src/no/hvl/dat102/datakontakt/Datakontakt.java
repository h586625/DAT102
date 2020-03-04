package no.hvl.dat102.datakontakt;

import java.util.Iterator;

import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {
	private TabellMengde<Medlem> medlemstabell;
	private int antallPar = 0;

	public Datakontakt() {
		medlemstabell = new TabellMengde<Medlem>();
	}

	public Datakontakt(int start) {
		medlemstabell = new TabellMengde<Medlem>(start);
	}

	public void leggTilMedlem(Medlem person) {
		medlemstabell.leggTil(person);
	}

	public void slettMedlem(Medlem person) {
		if (medlemstabell.fjern(person) != null) {
			if (person.getStatusIndeks() != -1) {
				antallPar--;
			}
		}
	}

	public TabellMengde<Medlem> getMedlemstabell() {
		return medlemstabell;
	}

	public int getAntall() {
		return medlemstabell.antall();
	}

	public int getAntallPar() {
		return antallPar;
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
		Iterator<Medlem> teller = medlemstabell.oppramser();
		Medlem element;

		while (teller.hasNext()) {
			element = teller.next();
			if (element.getNavn().equals(medlemsnavn)) {
				return element;
			}
		}

		return null;
	}

	public Medlem hentMedlemFraIndeks(int i) {
		return medlemstabell.hentElementFraIndeks(i);
	}

	public int finnPartnerFor(String medlemsnavn) {
		int funnet = -1;
		int m1indeks = finnMedlemsIndeks(medlemsnavn);

		// did we find the member?
		if (m1indeks != -1) {
			Iterator<Medlem> teller = medlemstabell.oppramser();
			int pos = 0;
			Medlem m1 = hentMedlem(medlemsnavn);
			// is the member available/single?
			if (m1.getStatusIndeks() == -1) {
				while (teller.hasNext() && funnet == -1) {
					Medlem m2 = teller.next();

					// if m1 and m2 are compatible and
					// m2 is not matched with another and
					// m1 isn't matching him/herself
					if (m1.passerTil(m2) &&
							m2.getStatusIndeks() == -1 &&
							m2.getNavn() != medlemsnavn
							) {
						funnet = pos;
						antallPar++;
						m1.setStatusIndeks(pos);
						m2.setStatusIndeks(m1indeks);
					} else {
						pos++;
					}
				}
				// return the current partner's index
			} else {
				funnet = m1.getStatusIndeks();
			}
		}

		return funnet;
	}

	public void tilbakestillStatusIndeks(String medlemsnavn) {
		Medlem medlem = hentMedlem(medlemsnavn);
		if (medlem != null) {
			antallPar--;
			medlem.setStatusIndeks(-1);
		}
	}
}
