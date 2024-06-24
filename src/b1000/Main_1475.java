package b1000;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int[] arr = new int[10];
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i)-48] += 1;
		}
		
		int max = 0;
		int revCnt = 0;
		for(int i=0; i<10; i++) {
			if(i!=6 && i!=9) max = Math.max(max, arr[i]);
			else revCnt += arr[i];
		}
		System.out.println(revCnt>max*2 ? (revCnt%2==0 ? revCnt/2 : revCnt/2+1) : max);
	}

}
