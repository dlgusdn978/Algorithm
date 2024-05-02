package b11000;

import java.util.Scanner;

public class Main_11729 {

	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		hanoi(n, 1, 2, 3);
		System.out.println(count);
		System.out.println(sb.toString());
	}
	
	static void hanoi(int n, int left, int mid, int right) {
		if(n==0) return;
		count++;
		hanoi(n-1, left, right, mid);
		sb.append(left+" "+right).append("\n");
		hanoi(n-1, mid, left, right);
		
	}

}
