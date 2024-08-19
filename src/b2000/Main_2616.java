package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2616 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		
		int[] sum = new int[n+1];
		for(int i=1; i<=n; i++) {
			sum[i] = sum[i-1]+arr[i];
		}
//		System.out.println(Arrays.toString(sum));

		int[][] dp = new int[n+1][4];
		
		for(int i=1; i<=n; i++) {
			if(i>=m) dp[i][1] = Math.max(dp[i-1][1], sum[i]-sum[i-m]);
			else dp[i][1] = dp[i-1][1] + arr[i];
		}
//		for(int[] a : dp) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		
		for(int i=2; i<=3; i++) {
			for(int j=i; j<=n; j++) {
				if(j>=m+i) dp[j][i] = Math.max(dp[j-1][i], sum[j]-sum[j-m]+dp[j-m][i-1]);
				else dp[j][i] = Math.max(dp[j-1][i], dp[j-1][i-1])+arr[j];
			}
		}
		System.out.println(dp[n][3]);
	}

}
