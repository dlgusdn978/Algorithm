package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20010 {
	static int[] parents;
	static class Node{
		int start;
		int end;
		int weight;
		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	static class Edge{
		int end;
		int weight;
		public Edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		makeSet(n);

		List<Node> list = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight-o2.weight;
			}
		});
		
		
		// 원소의 최대값 1000
		List<List<Edge>> edge = new ArrayList<>();
		for(int i=0; i<=1000; i++) {
			edge.add(new ArrayList<>());
		}
				
				
		int sum = 0;
		int cnt = 0;
		for(Node node : list) {
			if(union(node.start, node.end)) {
				sum += node.weight;
				edge.get(node.start).add(new Edge(node.end, node.weight));
				edge.get(node.end).add(new Edge(node.start, node.weight));
				if(++cnt==n-1) break;
			}
		}
		System.out.println(sum);

		boolean[] visited = new boolean[n+1];
		int cost = 0;
		for(int i=0; i<edge.size(); i++) {
			if(edge.get(i).isEmpty() || edge.get(i).size()>=2) continue;
			// 시작 정점 i
			visited[i] = true;
			cost = Math.max(bfs(edge, visited, i), cost);
		}
		
		System.out.println(cost);
	}
	static int bfs(List<List<Edge>> edge, boolean[] visited, int start) {
		boolean[] copy = Arrays.copyOf(visited, visited.length);
		Queue<Edge> q = new ArrayDeque<>();
		q.add(new Edge(start, 0));
		
		int max = 0;
		while(!q.isEmpty()) {
			Edge cur = q.poll();
			
			max = Math.max(cur.weight, max);
			for(Edge next : edge.get(cur.end)) {
				if(copy[next.end]) continue;
				copy[next.end] = true;
				q.add(new Edge(next.end, cur.weight+next.weight));
			}
		}
		return max;
	}
	static void makeSet(int n) {
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
