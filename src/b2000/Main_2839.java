package b2000;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3Å³·Î ºÀÁö, 5Å³·Î ºÀÁö
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[5001];
		arr[3] = 1;
		arr[5] = 1;
		
		for(int i=6; i<=n; i++) {
			if(arr[i-5]!=0) arr[i] = arr[i-5]+1;
			else if(arr[i-3]!=0) arr[i] = arr[i-3]+1;
		}
		System.out.println(arr[n]==0 ? -1 : arr[n]);
	}

}
