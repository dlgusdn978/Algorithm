package b10000;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main_10610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();

//		System.out.println(str);
		
		char[] arr = str.toCharArray();
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
		}
		sb.reverse();
		
		System.out.println(new BigInteger(sb.toString()).mod(new BigInteger("30")).equals(new BigInteger("0")) ? sb.toString() : -1);
	}
	
	
}
