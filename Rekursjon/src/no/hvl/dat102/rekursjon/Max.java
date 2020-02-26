package no.hvl.dat102.rekursjon;

public class Max {
	public static int max(int[] tab, int start, int slutt) {
		if (start == slutt) {
			return tab[start];
		} else {
			// Split the array in two
			int midten = (start + slutt) / 2;
			
			// Recursive calls
			int mV = max(tab, start, midten);
			int mH = max(tab, midten+1, slutt);
			
			System.out.println("mV: " + mV + " mH: " + mH);
			
			// Combining the sub-solutions
			System.out.println((mV >= mH) ? mV : mH);
			return (mV >= mH) ? mV : mH;
		}
	}
	
	public static void main(String[] args) {
		int[] tab = { 11, 8, 4, 10, 2, 5, 7, 0, 61 };
		
		int maksVerdi = max(tab, 0, tab.length-1);
		System.out.println("Maks: " + maksVerdi);
	}
}
