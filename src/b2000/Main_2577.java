package b2000;

import java.util.Scanner;

public class Main_2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		String res = String.valueOf(a*b*c);
		int[] arr = new int[10];
//		System.out.println('1'-48);
		for(int i=0; i<res.length(); i++) {
			arr[res.charAt(i)-48] += 1;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
