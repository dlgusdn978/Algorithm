package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2056 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int preCount = Integer.parseInt(st.nextToken());
			if(preCount==0) {
				dp[i] = time;
				continue;
			}
			int max = 0;
			for(int j=0; j<preCount; j++) {
				int pre = Integer.parseInt(st.nextToken());
				max = Math.max(max, dp[pre]);
			}
			dp[i] = max+time;
		}
//		System.out.println(Arrays.toString(dp));
		int res = 0;
		for(int a : dp) {
			res = Math.max(res, a);
		}
		System.out.println(res);
	}

}
