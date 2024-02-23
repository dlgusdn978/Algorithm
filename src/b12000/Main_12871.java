package b12000;

import java.util.Scanner;

public class Main_12871 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		String b = sc.nextLine();

		// a 와 b 가 공통인 부분을 찾고, 공통인 부분으로만 구성했을 때 a와 b를 만들 수 있는가?
		
		int small = a.length()>=b.length() ? b.length() : a.length();
		
		System.out.println(checker(a,b)? 1 : 0);
		
	}

	static boolean checker(String a, String b) {
		int lcm = lcm(a.length(), b.length());
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for(int i=0; i<lcm/a.length(); i++) {
			sb1.append(a);
		}
		for(int i=0; i<lcm/b.length(); i++) {
			sb2.append(b);
		}
		
		return sb1.toString().equals(sb2.toString());
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
		return a*(b/gcd(a,b));
	}
}
