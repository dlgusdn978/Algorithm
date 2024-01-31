package b9000;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_9663 {

	static int n;
	static int count;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1];
		
		dfs(1);
		System.out.println(count);
	}

	static void dfs(int c) {
		if(!check(c-1)) return;
		if(c>n) {
			count++;
			return;
		}
		for(int i=1; i<=n; i++) {
			arr[c] = i;
			dfs(c+1);
		}
	}
	static boolean check(int c) {
		for(int i=1; i<c; i++) {
			if(arr[c]==arr[i] || Math.abs(c-i)==Math.abs(arr[c]-arr[i])) return false;
		}
		return true;
	}
	
}
