package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504 {

	static int n, e;
	static List<Node>[] list;
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		public Node(int to, int weight) {
			super();
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
		// 1에서 n번 정점으로 이동하는 문제.
		// 다만 a, b 정점을 무조건 지나야 함.
		// 지날 수 없다면 -1 출력, 지난다면 최소 거리 출력.
		// 1-a-b-n 일 수도 있지만, 1-b-a-n일 수도 있음.
		// 다익스트라 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정점 수 n
		n = Integer.parseInt(st.nextToken());
		// 간선 수 e
		e = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		// 거쳐야할 정점 1
		int first = Integer.parseInt(st.nextToken());
		// 거쳐야할 정점 2
		int second = Integer.parseInt(st.nextToken());

		// 1-a-b-n
		int value1 = djikstra(first, second);
		// 1-b-a-n
		int value2 = djikstra(second, first);
		

		if(value1>200000000|| value2>200000000) {
			System.out.println(-1);
		}else {
			System.out.println(value1<value2 ? value1 : value2);
		}
		
	}
	static int djikstra(int a, int b) {
		int[] node = {1, a, b, n};
		int total = 0;
		for(int i=0; i<node.length-1; i++) {
			int el = node[i];
			int nel = node[i+1];

			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(el, 0));
			
			boolean[] visit = new boolean[n+1];
			int[] distance = new int[n+1];
			
			Arrays.fill(distance, 200000001);
			distance[el] = 0;
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				int to = cur.to;
				
				if(visit[to]) continue;
				visit[to] = true;
				
				for(Node n : list[to]) {
					if(distance[n.to] > distance[to]+n.weight) {
						distance[n.to] = distance[to]+n.weight;
						pq.add(new Node(n.to, distance[n.to]));
					}
				}
			}
			total += distance[nel];
		}
		return total;
	}

}
