package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926 {

	static int n, m;
	static int[][] arr;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] visit;
	static int count;
	static int piece;
	static class Cor{
		int x;
		int y;
		public Cor(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				 arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visit[i][j] && arr[i][j]==1) {
					bfs(i, j);
					piece++;
				}
			}
		}
		System.out.println(piece);
		System.out.println(count);
	}

	static void bfs(int r, int c) {
		Queue<Cor> q = new ArrayDeque<Cor>();
		q.add(new Cor(r, c));
		
		int temp = 0;
		while(!q.isEmpty()) {
			Cor cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			
			if(visit[x][y]) continue;
			visit[x][y] = true;
			temp += 1;
			for(int i=0; i<4; i++) {
				int nx = x+dr[i];
				int ny = y+dc[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && !visit[nx][ny] && arr[nx][ny]==1) {
					q.add(new Cor(nx, ny));
					
				}
			}
		}
		if(count<temp) count = temp;
	}
}
