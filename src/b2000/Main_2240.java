package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2240 {

	static class Node{
		int score;
		int cnt;
		public Node(int score, int cnt) {
			this.score = score;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 갱신 방법?
		// 1. 남은 변경횟수가 많은 노드 선택후 갱신 => 마지막까지 변경하지 않고 진행하는 경우 최대값이 될 수 없음.
		// 2. 현재까지 점수가 높은 노드 선택후 갱신 => 현재 선택까지는 최대값이 될 수 있으나, 이후에는 최대값이 될 수 없는 경우도 존재.
		// 3. dfs+dp? 현재 시점에서 변경o 와 변경x의 값을 비교하여 더 큰 값을 기준으로 갱신?
		// 4. 3차원 dp 활용해서, 각 time마다 값 저장.
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// m 은 이동 가능 횟수, n은 초
		int[][][] dp = new int[m+1][n+1][2];
		
		for(int j=m; j>=0; j--) {
			for(int i=1; i<=n; i++) {
			
				// 자두를 받을 수 있는 위치
				int cor = arr[i];
				// 위치 유지하는 경우
				dp[j][i][0] = Math.max(dp[j][i][0], dp[j][i-1][0]+(cor==1 ? 1 : 0));
				if(j!=m) dp[j][i][1] = Math.max(dp[j][i][1], dp[j][i-1][1]+(cor==2 ? 1 : 0));
				// 위치 변경하는 경우
				if(j-1>=0) dp[j-1][i][0] = Math.max(dp[j-1][i][0], dp[j][i-1][1]+(cor==1 ? 1 : 0));
				if(j-1>=0) dp[j-1][i][1] = Math.max(dp[j-1][i][1], dp[j][i-1][0]+(cor==2 ? 1 : 0));
			}
		}
		
		System.out.println(Math.max(dp[0][n][0], dp[0][n][1]));
	}

}
