package b15000;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15989 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        
	        int T = sc.nextInt();
	        int[] testCases = new int[T];
	        int maxN = 0;

	        for (int i = 0; i < T; i++) {
	            testCases[i] = sc.nextInt();
	            if (testCases[i] > maxN) {
	                maxN = testCases[i];
	            }
	        }

	        int[] dp = new int[maxN + 1];
	        dp[0] = 1; // 0을 만들기 위해 필요한 방법의 수는 1 (아무것도 선택하지 않는 경우)

	        for (int i = 1; i <= 3; i++) {
	            for (int j = i; j <= maxN; j++) {
	                dp[j] += dp[j - i];
	            }
	        }

	        for (int i = 0; i < T; i++) {
	            System.out.println(dp[testCases[i]]);
	        }

	}

}
