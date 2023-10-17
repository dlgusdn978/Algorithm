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
		
		// ������ ���� v
		v = Integer.parseInt(st.nextToken());
		// ������ ���� e
		e = Integer.parseInt(st.nextToken());
		// ���� ���� k
		k = Integer.parseInt(br.readLine());
		
		// ���� ���� ������ ������ List[]
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
		
		// �湮üũ visit[]
		boolean[] visit = new boolean[v+1];
		// �ִܰŸ� ����� distance[]
		int[] distance = new int[v+1];
		
		// �ּ� ���� ����ġ�� �����ϱ� ���� �켱���� ť ���.
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(k, 0));
		
		// ���� ��� ���ϱ� ����.
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		// ���� �ڽŰ��� �Ÿ��� ������� ����.
		distance[k] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			//�湮�ߴ� ������ �����ϱ� ���� �湮 üũ
			if(visit[cur.to]) continue;
			visit[cur.to] = true;
			
			// ���� ������ ����� ��� ���� Ž��
			for(Node n : nodeList[cur.to]) {
				// distance�� ��ϵǾ� �ִ� ���� ���������� �ּ� ����ġ �պ���
				// ���� ���������� ����ġ + ���� ������ ���� ������ ����ġ ���� �� �۴ٸ�
				if(distance[n.to]> distance[cur.to]+n.weight) {
					//����ġ ����
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
