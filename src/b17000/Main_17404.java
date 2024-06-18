package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][3];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Integer.MAX_VALUE;
		int[][] dp = new int[n][3];
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(j==i) dp[0][j] = arr[0][j];
				else dp[0][j] = 1001;
			}
			
			for(int j=1; j<n; j++) {
				dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2])+arr[j][0];
				dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2])+arr[j][1];
				dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1])+arr[j][2];
			}
			
			for(int j=0; j<3; j++) {
				if(j != i) {
					min = Math.min(min, dp[n-1][j]);
				}
			}
//			
//			for(int[] a : dp) {
//				for(int b : a) {
//					System.out.print(b+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(min);
		
		
		
	}
	
}
