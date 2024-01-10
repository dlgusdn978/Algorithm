package b1000;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_1120 {

	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		
		String b = sc.next();

		int min = Integer.MAX_VALUE;
		for(int i=0; i<=b.length()-a.length(); i++){
			int count = 0;
			for(int j=0; j<a.length(); j++) {
				if(a.charAt(j)!=b.charAt(i+j)) count++;
			}
			min = Math.min(count, min);
		}
		System.out.println(min);
	}
	
	
}
