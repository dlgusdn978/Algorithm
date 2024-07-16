package b4000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4811 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = 0;
		
		long[][] dp = new long[31][31];
		
		for(int i=0; i<=30; i++) {
			dp[i][0] = 1;
		}
		for(int i=1; i<=30; i++) {
			for(int j=1; j<=i; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		while((n = Integer.parseInt(br.readLine()))!=0) {
			sb.append(dp[n][n]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
