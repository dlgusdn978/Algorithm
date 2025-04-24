package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1185 {

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
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 모든 도시를 최소 한번 이상 방문
		// 첫 시작 나라 = 마지막 도착 나라
		// 길을 통과하기 위한 비용과, 각 나라에 도착했을 때 내는 비용이 각각 다름
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 각 나라 도착 시 지불할 비용
		int[] cost = new int[n+1];
		for(int i=1; i<=n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		List<Node> list = new ArrayList<>();
		
		// 각 나라 간 이동 비용
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 각 나라 간 이동 비용은 왕복하는 것까지 생각해서 (이동비용*2+각 나라 도착비용)?
			
			list.add(new Node(start, end, weight*2+cost[start]+cost[end]));
		}
		
		makeSet(n);
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight-o2.weight;
			}
		});
		int[] visited = new int[n+1];
		int start = 0;
		int sum = 0;
		int cnt = 0;
		for(int i=0; i<list.size(); i++) {
			Node cur = list.get(i);
			int from = cur.start;
			int to = cur.end;
			int weight = cur.weight;
			
			if(i==0) start = from;
			
			if(union(from, to)) {
				visited[from]++;
				visited[to]++;
//				System.out.println(from+" "+to+" "+weight);
				sum += weight;
				if(++cnt==n-1) break;
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<visited.length; i++) {
			if(visited[i]>1) {
				min = Math.min(min, cost[i]);
			}
		}
//		System.out.println(start);
		System.out.println(sum+min);
	}
	
	static void makeSet(int n) {
		parents = new int[n+1];
		for(int i=1; i<parents.length; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int v1) {
		if(parents[v1]==v1) return v1;
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
