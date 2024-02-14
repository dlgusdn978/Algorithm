package b15000;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_15740 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		BigInteger b1 = new BigInteger(str1);
		BigInteger b2 = new BigInteger(str2);
		
		System.out.println(b1.add(b2));

	}

}
