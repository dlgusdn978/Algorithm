package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1106 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] info = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			info[i][0] = cost;
			info[i][1] = people;
		}
		
		int[] dp = new int[1101];
		
		for(int i=0; i<n; i++) {
			// 동일 비용 대비 고효율 뽑기
			if(dp[info[i][1]]==0) dp[info[i][1]] = info[i][0];
			else dp[info[i][1]] = Math.min(dp[info[i][1]], info[i][0]); 
		}
		for(int i=1; i<c; i++) {
			if(dp[i]==0) continue;
			for(int j=0; j<info.length; j++) {
				if(dp[i+info[j][1]]==0) dp[i+info[j][1]] = dp[i]+info[j][0];
				else dp[i+info[j][1]] = Math.min(dp[i+info[j][1]], dp[i]+info[j][0]);
			}
		}
		int res = Integer.MAX_VALUE;
		for(int i=c; i<dp.length; i++) {
			if(dp[i]==0) continue;
			res = Math.min(res, dp[i]);
		}
		System.out.println(res);
	}

}
