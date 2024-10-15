package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2169 {
	
	// 왼쪽 오른쪽 아래
	static int[] dr = {0, 0};
	static int[] dc = {1, -1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		int[][] dp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 초기값
		dp[0][0] = arr[0][0];
		for(int i=1; i<m; i++) {
			dp[0][i] = dp[0][i-1]+arr[0][i];
		}
	
		for(int i=1; i<n; i++) {
			int[] left = new int[m];
			int[] right = new int[m];
			
			left[0] = dp[i-1][0]+arr[i][0];
			for(int j=1; j<m; j++) {
				left[j] = Math.max(left[j-1], dp[i-1][j])+arr[i][j];
			}
			
			right[m-1] = dp[i-1][m-1] + arr[i][m-1];
			for(int j=m-2; j>=0; j--) {
				right[j] = Math.max(right[j+1], dp[i-1][j])+arr[i][j];
			}
			
			for(int j=0; j<m; j++) {
				dp[i][j] = Math.max(left[j], right[j]);
			}
		}
//		for(int[] a : dp) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[n-1][m-1]);
	}

}
