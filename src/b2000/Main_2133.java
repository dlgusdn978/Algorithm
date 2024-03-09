package b2000;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2133 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] dp = new long[n+1];
		
		// n이 2라면 3개
		// n이 4라면 3*3+2개
		// n이 6이라면 (3*3+2)*(3*3+2)개
		// ....
		// n이 i라면 (i-2)*(i-2)개. i가 4로 나누어 떨어지면 +2
 		if(n%2!=0) {
 			System.out.println(0);
 			return;
 		}
		dp[2] = 3;
		
		for(int i=4; i<=n; i++) {
			if(i%2!=0) continue;
			
			int num = 0;
			num += dp[i-2]*dp[2];
			for(int j=i-4; j>=2; j--) {
				num+=dp[j]*2;
			}
			num+=2;
//			System.out.println(num);
			dp[i] = num;
		}
		System.out.println(dp[n]);

	}

}
