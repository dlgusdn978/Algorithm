package b2000;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_2407 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger big = BigInteger.ONE;
		if(n/2<m) m = m-2*(m-n/2);
		for(int i=1; i<=m; i++) {
			big = big.multiply(new BigInteger(String.valueOf(n-i+1)));
			big = big.divide(new BigInteger(String.valueOf(i)));
		}
		System.out.println(big.toString());

	}

}
