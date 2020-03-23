package no.hvl.dat102;

import java.time.Duration;
import java.time.Instant;

public class KlientHanoi {

	public static void main(String[] args) {

		Hanoi tårn = new Hanoi(28);
		Hanoi tårn2 = new Hanoi(29);
		Hanoi tårn3 = new Hanoi(30);

		Instant start = Instant.now();

		tårn.spill();

		Instant finish = Instant.now();
		System.out.println(Duration.between(start, finish).toMillis());

		Instant start2 = Instant.now();

		tårn2.spill();

		Instant finish2 = Instant.now();
		System.out.println(Duration.between(start2, finish2).toMillis());

		Instant start3 = Instant.now();

		tårn3.spill();

		Instant finish3 = Instant.now();
		System.out.println(Duration.between(start3, finish3).toMillis());

		System.out.println();

		double ringer28 = Math.pow(2, 28)-1;
		double ringer29 = Math.pow(2, 29)-1;
		double ringer30 = Math.pow(2, 30)-1;

		System.out.println(ringer28);
		System.out.println(ringer29);
		System.out.println(ringer30);

		System.out.println();

		System.out.println(ringer30/ringer28);
		System.out.println(931.0/372.0);

	} // main

} // class
