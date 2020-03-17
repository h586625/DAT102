package no.hvl.dat102;

public class Oppgave1ab {

	// a)
	public static int aritmetiskSum(int s1, int n) {
		// Base case
		if (n == s1) {
			return s1;
		}

		return (aritmetiskSum(s1, n-1) + n);
	}

	// b)
	public static int a(int n) {
		int an = n;

		// Base case
		if (n == 0) {
			an = 2;
		}

		// Base case
		if (n == 1) {
			an = 5;
		}

		if (n > 1) {
			an = ( -(6*(a(n-2))) + 5*(a(n-1)) + 2);
			return an;
		}

		return an;
	}

	public static void skrivUtLeddFraB(int n) {
		System.out.print("b) {");
		for (int i = 0; i < n; i++) {
			if (i <= n && i > 0) {
				System.out.print(", ");
			}
			System.out.print(a(i));
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
		System.out.println("a) " + aritmetiskSum(4, 6));
		skrivUtLeddFraB(10);
	}

}
