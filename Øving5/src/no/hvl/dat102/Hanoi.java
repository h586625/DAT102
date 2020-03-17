package no.hvl.dat102;

public class Hanoi {

	private int antallRinger;
	private int antallFlyttinger;

	public Hanoi(int startRinger) {
		antallRinger = startRinger;
	}

	public void spill() {
		flyttRinger(antallRinger, 1, 3, 2);
		System.out.println(antallFlyttinger);
	}

	public void flyttRinger(int antRinger, int start, int slutt, int temp) {
		if (antRinger == 1) {
			flyttEnRing();
		} else {
			flyttRinger(antRinger - 1, start, temp, slutt);
			flyttEnRing();
			flyttRinger(antRinger - 1, temp, slutt, start);

		}
	}

	public void flyttEnRing() {
		antallFlyttinger++;
	}
}