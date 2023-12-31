package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520 {

	static int m, n;
	static int[][] arr;
	static int[][] dp;
	static boolean[][] visit;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		
		arr = new int[m][n];
		dp = new int[m][n];
		visit = new boolean[m][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
//		for(int[] a : dp) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
	}

	
	static int dfs(int r, int c) {
		if(r == m-1 && c == n-1) {
			return 1;
		}
		if(dp[r][c]!=-1) {
			return dp[r][c];
		}
		dp[r][c] = 0;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<m && nc>=0 && nc<n) {
				if(arr[r][c]>arr[nr][nc]) {
					dp[r][c] += dfs(nr, nc);
				}
			}
		}
		return dp[r][c];
	}
}
