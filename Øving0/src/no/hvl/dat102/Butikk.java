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
		if(!erLedigPlass() && finnVare(varenr) != -1) {
			System.out.println("Enten er lageret fullt eller så eksisterer varen allerede.");
		} else {
			// EXAMPLE OF ALGORITHM (ascending varenr):
			// ========================================
			// varer[0:null, 1:null, 2:null, 3:null, 4:null, 5:null]
			// 0:1204, 1:2234, 2:3450, 3:4509, 4:null, 5:null antallVarer: 3
			// leggInnNyVare(1234); i:1
			// 0:1204, 1:1234, 2:2234, 3:3450, 4:4509, 5:null, antallVarer: 4
			
			// i dictates where the element will be placed
			int i = 0;
			while(i < antallVarer && varenr > varer[i].getVarenr()) {
				i++;
			}
			
			// shift every element after "i" one slot/index to the right
			// unless "i" is already farthest to the right
			int j = antallVarer;
			while(j > i) {
				varer[j] = varer[j-1];
				j--;
			}
			
			// Add element and increase our counter
			varer[i] = new Vare(varenr);
			antallVarer++;
		}
	}
	
	// k)
	public void slettVare(int varenr) {
		if(finnVare(varenr) == -1) {
			System.out.println("Varen fins ikke.");
		} else {
			antallVarer--;
			int i = finnVare(varenr);
			while(i < antallVarer) {
				varer[i] = varer[i+1];
				i++;
			}
			varer[antallVarer] = null;
		}
	}
	
	// l)
	public void detaljSalg(int varenr) {
		int indeks = finnVare(varenr);
		if(indeks != -1) {
			int antall = varer[indeks].getAntall();
			if(antall == 0) {
				System.out.println("Det er 0 stk. igjen av denne varen.");
			} else {
				varer[indeks].setAntall(antall-1);
			}
		} else {
			System.out.println("Varen er ikke registrert.");
		}
	}
	
	// m)
	public void grossInnkjop(int varenr, int ant) {
		int indeks = finnVare(varenr);
		if(indeks != -1) {
			int antall = varer[indeks].getAntall();
			if(antall < 0) {
				System.out.println("Antall varer av denne typen er negativ.");
			} else {
				varer[indeks].setAntall(antall+ant);
			}
		} else {
			System.out.println("Varen fins ikke.");
		}
	}
	
	// n)
	public double salgsVerdi() {
		double totalSalgsVerdi = 0.0;
		for(int i = 0; i < antallVarer; i++) {
			totalSalgsVerdi += varer[i].getPris();
		}
		return totalSalgsVerdi;
	}
	
	// o)
	public String skrivUt() {
		String varerStr = "";
		for(int i = 0; i < antallVarer; i++) {
			varerStr += varer[i].toString() + "\n\n";
		}
		return varerStr;
	}
	
	// p)
	public static void main(String[] args) {
		Butikk butikk = new Butikk("Kiwi", 100);
		butikk.leggInnNyVare(2234);
		butikk.leggInnNyVare(1234);
		butikk.leggInnNyVare(6234);
		butikk.leggInnNyVare(1934);
		butikk.leggInnNyVare(1233);
		System.out.println("Vare 6234 er på indeks: " + butikk.finnVare(6234));
		System.out.println("Ledig plass: " + butikk.erLedigPlass());
		butikk.slettVare(1934);
		butikk.grossInnkjop(2234, 5);
		butikk.detaljSalg(2234);
		System.out.println("Total salgsverdi: " + butikk.salgsVerdi());
		System.out.println("\n" + butikk.skrivUt());
	}

}
