package b7000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_7579 {

	public static void main(String[] args) throws IOException {
		// 10
		// 1  1  1  1  1   10
		// 10 10 10 10 10  10
		// 투포인터 형식?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정수 개수 n
		int n = Integer.parseInt(st.nextToken());
		// 메모리 수 m
		int m = Integer.parseInt(st.nextToken());
		// 앱 별 메모리 사용량, 재활성 비용
		int[][] arr = new int[n][2];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		int max = 10000 * n;
		int[] dp = new int[max+1];
		
		for(int i=0; i<n; i++) {
			for(int j=max; j>=arr[i][1]; j--) {
				dp[j] = Math.max(dp[j], dp[j-arr[i][1]]+arr[i][0]);
			}
		}
		
		int res = Integer.MAX_VALUE;
		
		for(int i=0; i<=max; i++) {
			if(dp[i]>=m) {
				res = Math.min(res, i);
			}
		}
		System.out.println(res);
		
	}

}
