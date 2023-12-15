package b5000;

import java.util.Scanner;


public class Main_5639 {

	static int[] arr;
	public static void main(String[] args) {
		// 5 24 28 30 45 50 52 60 98
		// 1 3 2 5 4 8 7 9
		Scanner sc = new Scanner(System.in);
		
		arr = new int[10000];
		int count = 0;
		while(sc.hasNextInt()) {
			arr[count++] = sc.nextInt();
		}
		postOrder(0, count-1);
		
	}

	static void postOrder(int n, int end) {
		if(n>end) {
			return;
		}
		int mid = n+1;
		while(mid<=end && arr[mid]<arr[n]) {
			mid++;
		}
		postOrder(n+1, mid-1);
		postOrder(mid, end);
		System.out.println(arr[n]);
	}
}
