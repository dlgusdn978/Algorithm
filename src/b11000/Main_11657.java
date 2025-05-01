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

public class Main_11657 {

	static class Node{
		int start;
		int end;
		long weight;
		public Node(int start, int end, long weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		// 1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간
		// 시간이 0이면 순간이동, 음수이면 시간을 되돌아가는 경우
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Node> list = new ArrayList<>();

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			
			list.add(new Node(from, to, weight));
		}
		
		long[] distance = new long[n+1];
		Arrays.fill(distance, Long.MAX_VALUE);
		
		distance[1] = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<list.size(); j++) {
				Node next = list.get(j);
				if(distance[next.start] != Long.MAX_VALUE && distance[next.end]>distance[next.start]+next.weight) {
					distance[next.end] = distance[next.start] + next.weight;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			Node next = list.get(i);
			if(distance[next.start]!=Long.MAX_VALUE && distance[next.end]>distance[next.start]+next.weight) {
				System.out.println(-1);
				return;
			}
		}
		for(int i=2; i<=n; i++) {
			sb.append(distance[i]==Long.MAX_VALUE ? -1 : distance[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
