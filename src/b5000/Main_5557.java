package b5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557 {

	static int n;
	static long total;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long[][] dp = new long[n][21];
		
		dp[0][arr[0]] = 1;
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<21; j++) {
				if(dp[i][j]!=0) {
					if(j+arr[i+1]<=20) dp[i+1][j+arr[i+1]] += dp[i][j];
					if(j-arr[i+1]>=0) dp[i+1][j-arr[i+1]] += dp[i][j];
				}
			}
		}

		System.out.println(dp[n-2][arr[n-1]]);
	}

	
}
