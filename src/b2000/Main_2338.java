package b2000;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_2338 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger n = new BigInteger(sc.next());
		BigInteger m = new BigInteger(sc.next());
		
		System.out.println(n.add(m));
		System.out.println(n.subtract(m));
		System.out.println(n.multiply(m));
	}

}
