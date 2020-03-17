package no.hvl.dat102;

import java.time.Duration;
import java.time.Instant;

public class KlientHanoi {

	public static void main(String[] args) {

		Hanoi t�rn = new Hanoi(28);

		Instant start = Instant.now();

		t�rn.spill();

		Instant finish = Instant.now();
		System.out.println(Duration.between(start, finish).toMillis());


	}

}