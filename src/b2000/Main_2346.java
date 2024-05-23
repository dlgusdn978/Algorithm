package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2346 {

	static class Node{
		int index;
		int num;
		public Node(int index, int num) {
			this.index = index;
			this.num = num;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			q.add(new Node(i, Integer.parseInt(st.nextToken())));
		}

		while(!q.isEmpty()) {
			Node cur = q.poll();
			sb.append(cur.index+" ");
			
			if(q.isEmpty()) break;
			if(cur.num>0) {
				for(int i=1; i<=cur.num-1; i++) {
					q.addLast(q.pollFirst());
				}
			}else {
				for(int i=1; i<=Math.abs(cur.num); i++) {
					q.addFirst(q.pollLast());
				}
			}
		}
		System.out.println(sb.toString());
	}

}
