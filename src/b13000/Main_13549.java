package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_13549 {

	static class Node{
		int cur;
		int count;
		public Node(int cur, int count) {
			this.cur = cur;
			this.count = count;
		}
	}
	static int n, m;
	static int min = Integer.MAX_VALUE;
	static boolean[] visit = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());

		bfs(n, 0);
		System.out.println(min);
	}

	static void bfs(int n, int count) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(n, count));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
//			System.out.println(node.cur);
//			System.out.println(node.cur);\
			
			visit[node.cur] = true;
			if(node.cur==m) {
				if(min>node.count) min = node.count;
			}
			if(node.cur*2<=100000 && !visit[node.cur*2]) q.add(new Node(node.cur*2, node.count));
			if(node.cur+1<=100000 && !visit[node.cur+1]) q.add(new Node(node.cur+1, node.count+1));
			if(node.cur-1>=0 && !visit[node.cur-1]) q.add(new Node(node.cur-1, node.count+1));
		} 
	}
}
