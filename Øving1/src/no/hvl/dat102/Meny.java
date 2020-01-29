package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmer;
	
	public Meny(FilmarkivADT filmer) {
		tekstgr = new Tekstgrensesnitt();
		this.filmer = filmer;
	}
	
	public void start() {
		tekstgr.lesFilm();
	};
	
}
