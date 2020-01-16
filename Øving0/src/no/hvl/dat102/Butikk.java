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
	
	@Override
	public String toString() {
		String varerStr = "";
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
