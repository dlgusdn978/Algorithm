package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098 {
	
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
		int min = Integer.MAX_VALUE;
		int[][] dp = new int[(1<<n)][n];
		for(int i=0; i<(1<<n); i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		// 출발점 0번 마을로 고정.
		dp[1][0] = 0;
		for(int i=1; i<(1<<n); i++) {
			for(int j=0; j<n; j++) {
				// 2진수로 변환할 수 있는 10진수인지 혹은 dp를 활용해 방문할 수 없는 마을인지 확인.
				if((i & (1<<j))==0 || dp[i][j]==Integer.MAX_VALUE) continue;
				for(int k=0; k<n; k++) {
					// 이미 방문했거나 길이 없는 마을이라면 continue;
					if((i & (1<<k))!=0 || arr[j][k]==0) continue;
					int nextBit = i | (1<<k);
					// dp 최소값 갱신
					dp[nextBit][k] = Math.min(dp[nextBit][k], dp[i][j]+arr[j][k]);
				}
			}
		}
		// dp[1<<n][?]를 순회하며 각 마을에서 시작 마을로 돌아가는 경로값을 더한 뒤, min 값을 계산.
		for (int i = 1; i < n; i++) {
		    if (arr[i][0] == 0 || dp[(1 << n) - 1][i] == Integer.MAX_VALUE) continue;
		    min = Math.min(min, dp[(1 << n) - 1][i] + arr[i][0]);
		}
		System.out.println(min);
		
	}
	
}
