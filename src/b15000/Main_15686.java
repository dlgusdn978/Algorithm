package b15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15686 {

	static int n,m;
	static int[][] arr;
	static int[][] temp;
	static boolean[][] visit;
	static boolean[][] visit2;
	static int count;
	static int result;
	static List<Node> list;
	static int[] dc = {1, 0, -1, 0};
	static int[] dr = {0, 1, 0, -1};
	static boolean[] select;
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int weight;
		public Node(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
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
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				if(temp==2) {
					list.add(new Node(i, j, 0));
					count++;
				}
			}
		}
		System.out.println(list.size());
		select = new boolean[list.size()];
		combination(0, 0);

		System.out.println(result);
	}
	
	
	static void print() {
		for(int[] a: arr) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	static void combination(int next, int c) {

		if(c==m) {
			visit2 = new boolean[n][n];
			for(int i=0; i<list.size(); i++) {
				if(select[i]) {
					int cr = list.get(i).r;
					int cc = list.get(i).c;
					visit2[cr][cc] = true;
					System.out.println(cr+" "+cc);
				}
			}
			print();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]==1) bfs(i,j);
				}
			}
			return;
		}
		
		for(int i=next; i<list.size(); i++) {
			select[i] = true;
			combination(i+1, c+1);
			select[i] = false;
		}
		
	}
	static void bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<Main_15686.Node>();
		q.add(new Node(r, c, 0));
		
		System.out.println("?");
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cr = cur.r;
			int cc = cur.c;
			
			if(arr[cr][cc]==2 && visit2[cr][cc]) {
				result+=cur.weight; 
				break;
			}
			
			if(visit[cr][cc]) continue;
			visit[cr][cc] = true;
			
			for(int i=0; i<4; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<n && !visit[nr][nc]) {
					q.add(new Node(nr, nc, cur.weight+1));
				}
			}
		}
	}

}
