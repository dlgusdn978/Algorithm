package b12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 물품의 수 n
		int n = Integer.parseInt(st.nextToken());
		// 버틸 수 있는 무게
		int k = Integer.parseInt(st.nextToken());

		int[] weight = new int[n+1];
		int[] value = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				if(weight[i]>j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(value[i]+dp[i-1][j-weight[i]], dp[i-1][j]);
			}
		}
		System.out.println(dp[n][k]);
	}
	
}