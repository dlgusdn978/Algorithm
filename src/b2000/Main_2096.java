package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[3];
		int[] dp2 = new int[3];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());

			int left = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			
			if(i==0) {
				dp[0] = dp2[0] = left;
				dp[1] = dp2[1] = mid;
				dp[2] = dp2[2] = right;
				
			}else {
				int preLeft = dp[0];
				int preRight = dp[2];
				
				dp[0] = Math.max(dp[0], dp[1])+left;
				dp[2] = Math.max(dp[1], dp[2])+right;
				dp[1] = Math.max(Math.max(preLeft, dp[1]), preRight)+mid;
				
				int preLeft2 = dp2[0];
				int preRight2 = dp2[2];
				
				dp2[0] = Math.min(dp2[0], dp2[1])+left;
				dp2[2] = Math.min(dp2[2], dp2[1])+right;
				dp2[1] = Math.min(Math.min(preLeft2, dp2[1]), preRight2)+mid;
			}
		}
		System.out.print(Math.max(dp[0], Math.max(dp[1], dp[2]))+" "+Math.min(dp2[0], Math.min(dp2[1], dp2[2])));
	}

	

}
