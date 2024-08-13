package b12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12869 {

	static int[][][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] hps = new int[3];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			hps[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[61][61][61];
		for(int i=0; i<=60; i++) {
			for(int j=0; j<=60; j++) {
				for(int k=0; k<=60; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		System.out.println(solve(hps[0], hps[1], hps[2]));
	}

	static int solve(int a, int b, int c) {
		if(a<0) return solve(0, b, c);
		if(b<0) return solve(a, 0, c);
		if(c<0) return solve(a, b, 0);
		
		if(a==0 && b==0 && c==0) return 0;
		
		
		if(dp[a][b][c] != -1) return dp[a][b][c];
		dp[a][b][c] = Integer.MAX_VALUE;
		
		dp[a][b][c] = Math.min(dp[a][b][c], 1+solve(a-9, b-3, c-1));
		dp[a][b][c] = Math.min(dp[a][b][c], 1+solve(a-9, b-1, c-3));
		dp[a][b][c] = Math.min(dp[a][b][c], 1+solve(a-3, b-9, c-1));
		dp[a][b][c] = Math.min(dp[a][b][c], 1+solve(a-3, b-1, c-9));
		dp[a][b][c] = Math.min(dp[a][b][c], 1+solve(a-1, b-3, c-9));
		dp[a][b][c] = Math.min(dp[a][b][c], 1+solve(a-1, b-9, c-3));
		
		return dp[a][b][c];
	}
}
