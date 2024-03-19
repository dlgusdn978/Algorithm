package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11049 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			arr[i] = row;
			if(i==n-1) arr[i+1] = col;
			
		}
		int count = 0;
		int[][] dp = new int[n+1][n+1];
		
		// 앞에서부터 연산 1회
		// 뒤에서부터 연산 1회
		
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=n-i+1; j++) {
				int end = j+i-1;
				dp[j][end] = Integer.MAX_VALUE;
				for(int k=j; k<end; k++) {
					int cost = dp[j][k] + dp[k+1][end] + arr[j-1]*arr[k]*arr[end];
					dp[j][end] = Math.min(dp[j][end], cost);
//					print(dp);
				}
			}
		}
		System.out.println(dp[1][n]);
	}

	static void print(int[][] dp) {
		for(int[] a : dp) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
