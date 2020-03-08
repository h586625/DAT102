package no.hvl.dat102.datakontakt;

import java.util.Iterator;

import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {
	private TabellMengde<Medlem> medlemstabell;

	public Datakontakt() {
		medlemstabell = new TabellMengde<Medlem>();
	}

	public Datakontakt(int start) {
		medlemstabell = new TabellMengde<Medlem>(start);
	}

	public void leggTilMedlem(Medlem person) {
		medlemstabell.leggTil(person);
	}

	public Medlem slettMedlem(Medlem person) {
		if (person.getStatusIndeks() != -1) {
			tilbakestillStatusIndeks(hentMedlemFraIndeks(person.getStatusIndeks()).getNavn());
		}
		return medlemstabell.fjern(person);
	}

	public TabellMengde<Medlem> getMedlemstabell() {
		return medlemstabell;
	}

	public TabellMengde<Medlem> getMedlemIPar() {
		Iterator<Medlem> teller = oppramser(medlemstabell);
		TabellMengde<Medlem> medlemmerMedPar = new TabellMengde<Medlem>();
		Medlem medlem;
		while (teller.hasNext()) {
			medlem = teller.next();
			if (medlem.getStatusIndeks() != -1) {
				medlemmerMedPar.leggTil(medlem);
			}
		}

		return medlemmerMedPar;
	}

	public int getAntall() {
		return medlemstabell.antall();
	}

	public int getAntallPar() {
		Iterator<Medlem> teller = oppramser(medlemstabell);
		Medlem medlem;
		int antallPar = 0;
		while (teller.hasNext()) {
			medlem = teller.next();
			if (medlem.getStatusIndeks() != -1) {
				antallPar++;
			}
		}

		return antallPar / 2;
	}

	public int[] skrivUtMedlemPar() {
		int[] usedIndexes = new int[getAntallPar()*2];
		int pos = 0;
		int medlemIndeks;
		Iterator<Medlem> teller = oppramser(medlemstabell);
		Medlem medlem;
		while (teller.hasNext()) {
			medlem = teller.next();
			medlemIndeks = finnMedlemsIndeks(medlem.getNavn());
			System.out.println("MEDLEM: " + medlemIndeks);
			int statusIndeks = medlem.getStatusIndeks();
			boolean duplicate = false;
			for (int i = 0; i < usedIndexes.length; i++) {
				int alleredeLagtTil = usedIndexes[i];
				// always whitelist index 0 due to Java initializing ints in arrays to 0
				if (statusIndeks != 0) {
					// if current member or his/her partner is already added
					if (alleredeLagtTil == medlemIndeks || alleredeLagtTil == statusIndeks) {
						System.out.println("statusIndeks: " + statusIndeks);
						System.out.println("i: " + i + " parI: " + usedIndexes[i]);
						System.out.println();
						duplicate = true;
					}
				}
			}
			if (statusIndeks != -1 && !duplicate) {
				usedIndexes[pos] = statusIndeks;
				pos++;
				System.out.println(medlem.getNavn() + " og " +
						hentMedlemFraIndeks(medlem.getStatusIndeks()).getNavn() +
						" " + medlem.getHobbyer()
						);
			}
		}
		return usedIndexes;
	}

	public Iterator<Medlem> oppramser(TabellMengde<Medlem> tab) {
		return tab.oppramser();
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
		int funnet = -1;
		Iterator<Medlem> teller = oppramser(medlemstabell);
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
		Iterator<Medlem> teller = oppramser(medlemstabell);
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
			Iterator<Medlem> teller = oppramser(medlemstabell);
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
			medlem.setStatusIndeks(-1);
		}
	}
}
