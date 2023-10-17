package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {

	static int v, e, k;
	static List<Node>[] nodeList;
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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 정점의 개수 v
		v = Integer.parseInt(st.nextToken());
		// 간선의 개수 e
		e = Integer.parseInt(st.nextToken());
		// 시작 정점 k
		k = Integer.parseInt(br.readLine());
		
		// 정점 연결 정보를 저장할 List[]
		nodeList = new ArrayList[v+1];
		
		for(int i=1; i<=v; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			nodeList[from].add(new Node(to, weight));
		}
		
		// 방문체크 visit[]
		boolean[] visit = new boolean[v+1];
		// 최단거리 기록할 distance[]
		int[] distance = new int[v+1];
		
		// 최소 간선 가중치를 선택하기 위해 우선순위 큐 사용.
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(k, 0));
		
		// 간선 비용 비교하기 위해.
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		// 정점 자신과의 거리는 계산하지 않음.
		distance[k] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			//방문했던 정점을 제외하기 위해 방문 체크
			if(visit[cur.to]) continue;
			visit[cur.to] = true;
			
			// 현재 정점과 연결된 모든 정점 탐색
			for(Node n : nodeList[cur.to]) {
				// distance에 기록되어 있는 다음 정점까지의 최소 가중치 합보다
				// 현재 정점까지의 가중치 + 현재 정점과 다음 정점간 가중치 합이 더 작다면
				if(distance[n.to]> distance[cur.to]+n.weight) {
					//가중치 갱신
					distance[n.to] = distance[cur.to]+n.weight;
					pq.add(new Node(n.to, distance[n.to]));
				}
			}
		}
		for(int i=1; i<=v; i++) {
			sb.append(distance[i]==Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
