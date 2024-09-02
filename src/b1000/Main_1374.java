package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1374 {

	static class Node{
		int num;
		int start;
		int end;
		public Node(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		List<Node> list = new ArrayList<Node>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Node(num, start, end));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.start==o2.start ? o1.end-o2.end : o1.start-o2.start;
			}
		});
		
		int max = 0;
		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.end==o1.end ? o1.start-o2.start : o1.end-o2.end;
			}
		});
		
		for(int i=0; i<n; i++) {
			Node cur = list.get(i);
			
			while(!q.isEmpty()) {
				if(q.peek().end<=cur.start) q.poll();
				else break;
			}
			q.add(cur);
			
			max = Math.max(max, q.size());


		}
		System.out.println(max);
	
	}

}
