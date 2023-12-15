package b1000;

import java.util.Scanner;

public class Main_1563 {

	public static void main(String[] args) {
		// 결과적으로 L은 한번씩만 넣을 수 있다.
		// L을 제외한 모든 경우의 수를 구하고, L을 끼워넣는 방식
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int mod = 1000000;
		// N=4 일 때, L이 들어가는 경우의 수 30개. 들어가지 않는 경우의 수 13개
		
		int[][][] dp = new int[n+1][3][2];
		
		dp[1][0][0] = 1;
		dp[1][1][0] = 1;
		dp[1][0][1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][2][0])%mod;
			dp[i][0][1] = (dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][2][0] + dp[i-1][0][1] + dp[i-1][1][1] + dp[i-1][2][1])%mod;
			dp[i][1][0] = (dp[i-1][0][0])%mod;
			dp[i][1][1] = (dp[i-1][0][1])%mod;
			dp[i][2][0] = (dp[i-1][1][0])%mod;
			dp[i][2][1] = (dp[i-1][1][1])%mod;
		}
		int count = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				count += dp[n][i][j]%mod;
			}
		}
		System.out.println(count%mod);
	}
 
}
