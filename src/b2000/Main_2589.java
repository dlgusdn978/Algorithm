package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589{

	static int n, m;
	static char[][] arr;
	static boolean[][] visit;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int max = Integer.MIN_VALUE;
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
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());

		arr = new char[n][m];
		
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]=='L') {
					bfs(i,j);
				}
			}
		}
		System.out.println(max);
	}

	static void bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(new Node(r, c, 0));
		visit = new boolean[n][m];
		visit[r][c] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<m && !visit[nr][nc] && arr[nr][nc]=='L') {
					visit[nr][nc] = true;
					q.add(new Node(nr, nc, cur.count+1));
					if(max < cur.count+1) max = cur.count+1;
				}
			}
		}
	}
}
