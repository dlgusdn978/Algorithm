package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17835 {

	static int n, m, k;
	static List<Node>[] list;
	static class Node implements Comparable<Node>{
		int to;
		long weight;
		public Node(int to, long weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			//this.weight==o.weight ? this.to-o.to : o.weight-this.weight
			return Long.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 도시의 수 n
		n = Integer.parseInt(st.nextToken());
		// 도로의 수 m
		m = Integer.parseInt(st.nextToken());
		// 면접장의 수 k
		k = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[to].add(new Node(from, weight));
		}
		
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		long[] distance = new long[n+1];
		st = new StringTokenizer(br.readLine());
		Arrays.fill(distance, Long.MAX_VALUE);
		for(int i=0; i<k; i++) {
			int a = Integer.parseInt(st.nextToken());
			pq.add(new Node(a, 0));
			distance[a] = 0;
		}
		
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int to = cur.to;

			if(distance[to]<cur.weight) continue;
			for(Node node : list[to]) {
				if(distance[node.to]>distance[to]+node.weight) {
					distance[node.to] = distance[to]+node.weight;
					pq.add(new Node(node.to, distance[node.to]));
				}
			}
		}
		long num = 0;
		int index = 0;
		for(int i=1; i<=n; i++) {
			if(distance[i] > num) {
				num=distance[i];
				index = i;
			}
		}
		
		System.out.println(index);
		System.out.println(distance[index]);
		
	}

}
