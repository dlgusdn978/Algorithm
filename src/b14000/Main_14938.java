package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14938 {
	static List<Node>[] list;
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
			
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 지역의 개수 n
		int n = Integer.parseInt(st.nextToken());
		// 수색 범위 m
		int m = Integer.parseInt(st.nextToken());
		// 길의 개수 r
		int r = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Node>();
		}

		for(int i=1; i<=r; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start,weight));
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			PriorityQueue<Node> q = new PriorityQueue<Node>();
			q.add(new Node(i, 0));
			
			int[] distance = new int[n+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			boolean[] visit = new boolean[n+1];
			distance[i] = 0;
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				if(visit[cur.to]) continue;
				visit[cur.to] = true;
				for(Node next: list[cur.to]) {
					if(distance[next.to]>distance[cur.to]+next.weight) {
						distance[next.to] = distance[cur.to]+next.weight;
						q.add(new Node(next.to, distance[next.to]));
					}
				}
			}
			int count = 0;
			for(int j=1; j<=n; j++) {
				if(distance[j]<=m) {
					count+=arr[j];
				}
			}
			max = Math.max(max, count);
			
		}
		System.out.println(max);
		
		
	}

}
