package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11000 {

	static class Node implements Comparable<Node>{
		int start;
		int end;
		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.start-o.start;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		boolean[] visit = new boolean[n];
		List<Node> list = new ArrayList<>();
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Node(start, end));
		}
		
		Collections.sort(list);

		// 순차적으로 탐색 시작
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(list.get(0).end);
		
		for(int i=1; i<n; i++) {
			if(list.get(i).start>=pq.peek()) {
				pq.poll();
			}
			pq.add(list.get(i).end);
		}
		System.out.println(pq.size());
	}

}
