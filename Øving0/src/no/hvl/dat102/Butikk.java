package no.hvl.dat102;

public class Butikk {
	// f)
	private String navn;
	private Vare[] varer;
	private int antallVarer;

	// g)
	public Butikk(String navn, int maksVarer) {
		this.navn = navn;
		antallVarer = 0;
		varer = new Vare[maksVarer];
	}
	
	// h)
	public int finnVare(int varenr) {
		for(int i = 0; i < antallVarer; i++) {
			if(varenr == varer[i].getVarenr()) {
				return i;
			}
		}
		return -1;
	}
	
	// i)
	public boolean erLedigPlass() {
		if(antallVarer < varer.length) {
			return true;
		}
		return false;
	}
	
	// j)
	public void leggInnNyVare(int varenr) {
		if(erLedigPlass() && finnVare(varenr) == -1) {
			varer[antallVarer] = new Vare(varenr);
			antallVarer++;
		}
		
		// ascending varenr
		// e.g. [1204, 1304, 1109, 5091]
		Vare[] sorterteVarer = new Vare[antallVarer];
		Vare tmp = varer[0];
		boolean sortertPar = false;
		
		for(int i = 0; i < antallVarer; i++) {
			for(int j = i+1; j < antallVarer-1; j++) {
				if(varer[i].getVarenr() > varer[j].getVarenr()) {
					sorterteVarer[i] = varer[j];
				} else {
					sorterteVarer[i] = varer[i];
				}
			}
		}
		
	}
	
	@Override
	public String toString() {
		String varerStr = "" + antallVarer;
		for(int i = 0; i < antallVarer; i++) {
			varerStr += varer[i].toString() + "\n\n";
		}
		return varerStr;
	}
	
	// k)
	

	public static void main(String[] args) {
		Butikk butikk = new Butikk("Kiwi", 5);
		butikk.leggInnNyVare(2234);
		butikk.leggInnNyVare(1234);
		butikk.leggInnNyVare(6234);
		butikk.leggInnNyVare(1934);
		butikk.leggInnNyVare(1233);
		System.out.println(butikk.toString());
	}

}
