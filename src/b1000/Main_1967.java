package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1967 {

	static int n;
	static int temp1;
	static List<Node>[] list;
	static boolean[] visit;
	static class Node{
		int to;
		int weight;
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 노드의 개수 n
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Node>();
		}
		// 간선 정보
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,weight));
			list[to].add(new Node(from,weight));
		}
		
		for(int i=1; i<=n; i++) {
			visit = new boolean[n+1];
			visit[i] = true;
			dfs(i, 0);
		}
		System.out.println(temp1);

	}
	static void dfs(int cur, int count) {
		
		for(int i=0; i<list[cur].size(); i++) {
			if(visit[list[cur].get(i).to]) continue;
			visit[list[cur].get(i).to]=true;
			dfs(list[cur].get(i).to, count+list[cur].get(i).weight);
		}
		temp1 = (temp1<count)?count:temp1;
	}

}
