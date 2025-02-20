package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13302 {
	static boolean[] visited;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 여름방학 일수
		int n = Integer.parseInt(st.nextToken());
		// 리조트에 갈 수 없는 날으 ㅣ수
		int m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		Arrays.fill(visited, true);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			visited[Integer.parseInt(st.nextToken())] = false;
		}

		dp = new int[n+1][n+1];
		for(int i=0; i<=n; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		System.out.println(solve(1, 0, n));
	}

	static int solve(int days, int coupons, int n) {
		if(days>n) return 0;
		if(dp[days][coupons]!=Integer.MAX_VALUE) return dp[days][coupons];
		
		int res = Integer.MAX_VALUE;
		
		if(!visited[days]) {
			res = solve(days+1, coupons, n);
		}else {
			res = Math.min(res, solve(days+1, coupons, n)+10000);
			
			res = Math.min(res, solve(days+3, coupons+1, n)+25000);
			
			res = Math.min(res, solve(days+5, coupons+2, n)+37000);
			
			if(coupons>=3) {
				res = Math.min(res, solve(days+1, coupons-3, n));
			}
		}
		
		return dp[days][coupons] = res;
	}

}
