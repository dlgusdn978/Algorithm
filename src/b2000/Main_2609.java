package b2000;

import java.util.Scanner;

public class Main_2609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));

	}

	static int gcd(int a, int b) {
		while(b!=0) {
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	static int lcm(int a, int b) {
		return a*(b/gcd(a, b));
	}
}
