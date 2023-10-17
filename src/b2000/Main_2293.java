package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main_2293 {

	static int n, k;
	static int[] arr, dp;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 동전의 종류 n
		n = Integer.parseInt(st.nextToken());
		// 동전 가치의 합 k
		k = Integer.parseInt(st.nextToken());

		
		arr = new int[n+1];
		dp = new int[k+1];
		dp[0] = 1;
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j=arr[i]; j<=k; j++) {
				dp[j] += dp[j-arr[i]];
			}
		}
		System.out.println(dp[k]);
		for(int i=1; i<=n; i++) {
			
		}

	}

}
