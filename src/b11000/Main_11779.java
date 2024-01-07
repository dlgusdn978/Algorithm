package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_11779 {

	static int n, m, start, end;
	static List<Node>[] list;

	static class Node {
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 도시의 수 n
		n = Integer.parseInt(br.readLine());
		// 간선의 수 m
		m = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		// 각 도시 및 간선 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, weight));
		}
		// 값 확인.
//		System.out.println(list[1]);

		// 시작 도시 start
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());

		// 도착 도시 end
		end = Integer.parseInt(st.nextToken());

		if(start==end) {
			System.out.println(0);
			System.out.println(start);
			System.out.println(start);
			return;
		}
		
		boolean[] visit = new boolean[n + 1];
		int[] distance = new int[n + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(start, 0));
		
		String str = "";
		String[] strList = new String[n+1];
		for(int i=1; i<=n; i++) {
			strList[i] = Integer.toString(start);
		}
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if(distance[cur.to]<cur.weight) continue;
			for (Node node : list[cur.to]) {
				if (distance[node.to] > distance[cur.to] + node.weight) {
					strList[node.to] = (strList[cur.to]+" "+node.to);
					distance[node.to] = distance[cur.to] + node.weight;
					q.add(new Node(node.to, distance[node.to]));

				}
				
			}
		}
		StringBuilder sb = new StringBuilder();
		
		String[] res = strList[end].split(" ");
		for(int i=0; i<res.length; i++) {
			sb.append(res[i]+" ");
		}
		System.out.println(distance[end]);
		System.out.println(res.length);
		System.out.println(sb.toString());
	}

}
