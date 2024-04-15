package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13905 {

	static int n, m, startPoint, endPoint;
	static boolean flag;
	static int[] parents;
	static List<Node>[] nodeList;
	static boolean[] visited;
	static int minValue = Integer.MAX_VALUE;
	static class Node{
		int from;
		int to;
		int weight;
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		// 섬의 수 n
		n = Integer.parseInt(st.nextToken());
		
		// 다리의 수 m
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		startPoint = Integer.parseInt(st.nextToken());
		endPoint = Integer.parseInt(st.nextToken());
		
		
		List<Node> list = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Node(start, end, weight));
			
		}
		
		makeSet();
		
		
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.weight-o1.weight;
			}
		});
		
		int count = 0;
		nodeList = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(Node cur : list) {
			if(union(cur.from, cur.to)) {
				nodeList[cur.from].add(new Node(0, cur.to, cur.weight));
				nodeList[cur.to].add(new Node(0, cur.from, cur.weight));
				
				if(++count==n-1) break;
			}
		}
		visited[startPoint] = true;
		dfs(startPoint, minValue);
		System.out.println(minValue==Integer.MAX_VALUE ? 0 : minValue);
	}

	static void dfs(int index, int min) {
		if(flag) return;
		if(index == endPoint) {
			minValue = min;
			flag = true;
			return;
		}
		for(int i=0; i<nodeList[index].size(); i++) {
			int next = nodeList[index].get(i).to;
			if(visited[next]) continue;
			visited[next] = true;
			dfs(next, Math.min(min, nodeList[index].get(i).weight));
			visited[next] = false;
		}
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
