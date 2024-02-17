package b15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15591 {

	static int n, m, count;
	static List<Node>[] list;
	static boolean[] visit;
	static class Node{
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 동영상 수 n
		n = Integer.parseInt(st.nextToken());
		// 질문 갯수 m
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		
		for(int i=0; i<m; i++) {
			count = 0;
			visit = new boolean[n+1];
			st = new StringTokenizer(br.readLine());
			// 유사도 k
			int k = Integer.parseInt(st.nextToken());
			// 시작 정점 num
			int num = Integer.parseInt(st.nextToken());
			visit[num] = true;
			dfs(k, num, Integer.MAX_VALUE);
			System.out.println(count);
		}
	}
	
	// dfs 탐색 중 가장 작은 weight와 k를 비교하고, weight > k 일 때 count += 1 하면 된다.
	
	static void dfs(int k, int num, int min) {
		if(min != Integer.MAX_VALUE && min>=k) {
			count++;
		}
//		System.out.println(num+" "+min);
		for(int i=0; i<list[num].size(); i++) {
			Node el = list[num].get(i);
			if(visit[el.to]) continue;
			visit[el.to] = true;
			dfs(k, el.to, Math.min(min, el.weight));
			visit[el.to] = false;
		}
	}

}
