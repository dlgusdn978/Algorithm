package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1516 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1차원 dp 배열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// 건물 수 n
		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		int[] inDegree = new int[n+1];
		int[] time = new int[n+1];
		int[] result = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int prev = Integer.parseInt(st.nextToken());
				if(prev==-1) break;
				graph.get(prev).add(i);
				inDegree[i]++;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=n; i++) {
			if(inDegree[i]==0) {
				q.add(i);
				result[i] = time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next: graph.get(cur)) {
				result[next] = Math.max(result[next], result[cur]+time[next]);
				inDegree[next]--;
				if(inDegree[next]==0) {
					q.add(next);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
