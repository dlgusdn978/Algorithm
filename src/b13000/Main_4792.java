package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main_4792 {

	static int n, m, k;
	static int[] parents;
	static int max;
	static int min;
	static class NodeB implements Comparable<NodeB>{
		String color;
		int from;
		int to;
		public NodeB(String color, int from, int to) {
			super();
			this.color = color;
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(NodeB o) {
			// TODO Auto-generated method stub
			return this.color.compareTo(o.color);
		}
	}
	static class NodeR implements Comparable<NodeR>{
		String color;
		int from;
		int to;
		public NodeR(String color, int from, int to) {
			super();
			this.color = color;
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(NodeR o) {
			// TODO Auto-generated method stub
			return o.color.compareTo(this.color);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			// 정점의 개수 n
			n = Integer.parseInt(st.nextToken());
			// 간선의 개수 m
			m = Integer.parseInt(st.nextToken());
			// 파란색 간선의 개수 k
			k = Integer.parseInt(st.nextToken());
		
			if(n==0 && m==0 && k==0) break;
			
			PriorityQueue<NodeR> pq1 = new PriorityQueue<>();
			PriorityQueue<NodeB> pq2 = new PriorityQueue<>();
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				String color = st.nextToken();
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				pq1.add(new NodeR(color, from, to));
				pq2.add(new NodeB(color, from, to));
			}
			
				int blue = 0;
				int count = 0;
				makeSet();
				for(NodeR node:pq1) {
					if(union(node.from, node.to)) {
						if(node.color.equals("B")) {
							blue++;
						}
						if(++count==n-1) break;
					}
				}
				min = blue;
				
				blue = 0;
				count = 0;
				makeSet();
				for(NodeB node:pq2) {
					if(union(node.from, node.to)) {
						if(node.color.equals("B")) {
							blue++;
						}
						if(++count==n-1) break;
					}
				}
				max = blue;
				sb.append((min<=k && k<=max) ? 1 : 0).append("\n");
		}
		System.out.println(sb.toString().trim());
		
	}
	
	static void makeSet() {
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int v1) {
		if(v1==parents[v1]) return v1;
		else return parents[v1] = findSet(parents[v1]);
	}
	static boolean union(int v1, int v2) {
		int aRoot = findSet(v1);
		int bRoot = findSet(v2);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
