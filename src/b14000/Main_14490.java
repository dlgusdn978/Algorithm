package b14000;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_14490 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String[] arr = str.split(":");
		
		int left = Integer.parseInt(arr[0]);
		int right = Integer.parseInt(arr[1]);
		
		int gcd = getGCD(left, right);
		System.out.println(left/gcd+":"+right/gcd);
	}

	static int getGCD(int left, int right) {
		
		while(right!=0) {
			int temp = left;
			left = right;
			right = temp%right;
//			System.out.println(left+" "+right);
		}
		
		return left;
	}
}
