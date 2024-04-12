package b10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10282 {

	static class Node{
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	static List<Node>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			//컴퓨터의 개수 n
			int n = Integer.parseInt(st.nextToken());
			// 의존성 개수 d
			int d = Integer.parseInt(st.nextToken());
			// 해킹당한 컴 번호 c
			int c = Integer.parseInt(st.nextToken());
			
			// 양방향으로 진행해도 될 것 같은데?
			list = new ArrayList[n+1];
			for(int i=1; i<=n; i++) {
				list[i] = new ArrayList<>();
				
			}
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list[end].add(new Node(start, weight));
			}
			
			int[] distance = new int[n+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			boolean[] visited = new boolean[n+1];
			visited[c] = true;
			
			distance[c] = 0;
			
			Queue<Node> q = new ArrayDeque<>();
			q.add(new Node(c, 0));
			
//			for(List<Node> a : list) {
//				System.out.println(a);
//			}
			while(!q.isEmpty()) {
				Node cur = q.poll();
				
				for(Node next : list[cur.to]) {
					if(distance[next.to] > distance[cur.to]+next.weight) {
						distance[next.to] = distance[cur.to]+next.weight;
						q.add(new Node(next.to, distance[next.to]));
					}
				}
			}
//			System.out.println(Arrays.toString(distance));
			
			int count = 0;
			int max = 0;
			for(int i=0; i<distance.length; i++) {
				if(distance[i]==Integer.MAX_VALUE) continue;
				max = Math.max(max, distance[i]);
				count++;
			}
			sb.append(count+" "+max).append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
