package no.hvl.dat102.datakontakt;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks = -1;

	public Medlem() {
		this.navn = "";
		this.hobbyer = new TabellMengde<Hobby>();	}

	public Medlem(String navn) {
		this.navn = navn;
		this.hobbyer = new TabellMengde<Hobby>();
	}

	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int i) {
		statusIndeks = i;
	}

	public boolean passerTil(Medlem medlem2) {		
		if (this.getHobbyer().equals(medlem2.getHobbyer())) {
			return true;
		}

		return false;
	}
}
