package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1949 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		List<Integer>[] list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		int[] people = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			people[i+1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
//			System.out.println(start+""+end);
		}
		int[][] dp = new int[n+1][2];
		// 방문체크
		boolean[] visited = new boolean[n+1];
		dfs(visited, list, people, dp, 1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	
	static void dfs(boolean[] visited, List<Integer>[] list, int[] people, int[][] dp, int num) {
		visited[num] = true;
		dp[num][0] = 0;
		dp[num][1] = people[num];
		
		for(int a : list[num]) {
			if(visited[a]) continue;
			dfs(visited, list, people, dp, a);
			dp[num][0] += Math.max(dp[a][0], dp[a][1]);
			dp[num][1] += dp[a][0];
		}
	}
	
}
