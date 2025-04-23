package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_17845 {

	public static void main(String[] args) throws IOException {
		// 각 정보를 1차원 배열에 저장.
		// 현재 배열에서 이전 시간과의 차이 + 과목 중요도, 현재 시간의 과목 중요도를 비교하여 max 값을 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 최대 공부시간 n
		int n = Integer.parseInt(st.nextToken());
		// 과목 수 k
		int k = Integer.parseInt(st.nextToken());
		
		int[][] info = new int[k+1][2];
		// score, time 입력
		for(int i=1; i<=k; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(info, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
			}
			
		});
		
		int[][] dp = new int[k+1][n+1];
		// 과목 순서대로 순회
		// dp[i-1][j] 값과 dp[i-1][j-time]+score;
		for(int i=1; i<=k; i++) {
			int score = info[i][0];
			int time = info[i][1];
			for(int j=1; j<=n; j++) {
				if(j<time) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(score + dp[i-1][j-time], dp[i-1][j]);
			}
		}
//		for(int[] a : dp) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[k][n]);
	}

}
