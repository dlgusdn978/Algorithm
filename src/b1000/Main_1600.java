package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {

	static int k, n, m;
	static int[][] arr;
	static boolean[][][] visit;
	// 원숭이 기본 이동
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	// 말 이동
	static int[] hr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] hc = {1, 2, 2, 1, -1, -2, -2, -1};
	
	static int min = Integer.MAX_VALUE;
	static class Node{
		int r;
		int c;
		int horse;
		int move;
		public Node(int r, int c, int horse, int move) {
			this.r =  r;
			this.c = c;
			this.horse = horse;
			this.move = move;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		k = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m][k+1];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0, 0);
		
		System.out.println(min==Integer.MAX_VALUE ? -1 : min);
	}

	static void bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(r, c, k, 0));
		visit[r][c][k] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();

//			System.out.println(cur.r+" "+cur.c+" "+cur.move);
			if(cur.r == n-1 && cur.c == m-1 ) {
				min = Math.min(min, cur.move);
				return;
			}
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<m && !visit[nr][nc][cur.horse] && arr[nr][nc]==0) {
					q.add(new Node(nr, nc, cur.horse, cur.move+1));
					visit[nr][nc][cur.horse] = true;
				}
			}
			if(cur.horse>0) {
				for(int i=0; i<8; i++) {
					int nr = cur.r+hr[i];
					int nc = cur.c+hc[i];
					if(nr>=0 && nr<n && nc>=0 && nc<m && !visit[nr][nc][cur.horse-1] && arr[nr][nc]==0) {
						q.add(new Node(nr, nc, cur.horse-1, cur.move+1));
						visit[nr][nc][cur.horse-1] = true;
					}
				}
			}
			
			
			
			
		}

		return;
	}
}
