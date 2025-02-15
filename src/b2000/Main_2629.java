package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2629 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// 추의 개수
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			sum+=num;
		}
		// 확인할 추의 개수
		int m = Integer.parseInt(br.readLine());
		int[] res = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			res[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n+1][sum+1];
		dp[0][0] = 1;
		for(int i=1; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				if(dp[i-1][j]==0) continue;
				// 더하거나
				dp[i][j+arr[i-1]] = 1;
				// 그냥 두거나
				dp[i][j] = 1;
				// 빼거나
				dp[i][Math.abs(j-arr[i-1])] = 1;
			}
		}
//		for(int[] a : dp) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		for(int i=0; i<res.length; i++) {
			sb.append(res[i]>sum || dp[n][res[i]]==0 ? "N ": "Y ");
		}
		System.out.println(sb.toString());
	}

}
