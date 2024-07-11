package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1937 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], 1);
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				max = Math.max(max, dfs(arr, dp, i, j));
			}
		}
		int res = 0;
		for(int[] a : dp) {
			for(int b : a) {
				res = Math.max(res, b);
//				System.out.print(b+" ");
			}
//			System.out.println();
		}
		System.out.println(res);
	}
	static int dfs(int[][] arr, int[][] dp, int r, int c) {
		// 현 위치에서 dfs 탐색.
		if(dp[r][c]>1) {
			return dp[r][c];
		}
		dp[r][c] = 1;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<arr.length && nc>=0 && nc<arr.length && arr[nr][nc]>arr[r][c]) {
				dp[r][c] = Math.max(dp[r][c], 1+dfs(arr, dp, nr,nc));
			}
		}
		return dp[r][c];
	}

}
