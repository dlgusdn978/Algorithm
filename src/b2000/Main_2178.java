package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {

	static int n;
	static int m;
	static char[][] arr;
	static boolean[][] visit;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int temp;
	static class Node{
		int r;
		int c;
		int count;
		public Node(int r, int c, int count) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		visit = new boolean[n][m];
		bfs();
		System.out.println(temp);
	}

	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(new Node(0, 0, 0));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int count = cur.count;
			
			if(r==n-1 && c==m-1){
				temp = count+1;
				break;
			}
			
			for(int i=0; i<4; i++) {
				if(r+dr[i]>=0 && r+dr[i]<n && c+dc[i]>=0 && c+dc[i]<m && !visit[r+dr[i]][c+dc[i]]) {
					visit[r+dr[i]][c+dc[i]] = true;
					if(arr[r+dr[i]][c+dc[i]]=='1') {
						q.add(new Node(r+dr[i], c+dc[i], count+1));
					}
				}
			}
		}
	}
}
