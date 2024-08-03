package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int[] times = new int[n+1];
		int[] scores = new int[n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			scores[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n+1][t+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=t; j++) {
				if(times[i]>j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(scores[i]+dp[i-1][j-times[i]], dp[i-1][j]);
			}
		}
		int max = 0;
		for(int[] a : dp) {
			for(int b : a) {
//				System.out.print(b+" ");
				max = Math.max(max, b);
			}
//			System.out.println();
		}
		System.out.println(max);
	}

}
