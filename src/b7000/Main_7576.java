package b7000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

	static int m, n;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int temp;
	static class Cor{
		int x;
		int y;
		int dist;
		public Cor(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		visit = new boolean[m][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(checker()) System.out.println(0);
		else {
			bfs();
			if(afterRotateChecker()) System.out.println(temp);
			else System.out.println(-1);
		}
	}

	static void bfs() {
		Queue<Cor> q = new ArrayDeque<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==1) {
					q.add(new Cor(i, j, 0));
				}
			}
		}
		while(!q.isEmpty()) {
			Cor cur = q.poll();
			int dx = cur.x;
			int dy = cur.y;
			int dist = cur.dist;
			
			for(int i=0; i<4; i++) {
				int nx = dx+dr[i];
				int ny = dy+dc[i];
				if(nx>=0 && nx<m && ny>=0 && ny<n && arr[nx][ny]==0 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					arr[nx][ny] = 1;
					q.add(new Cor(nx, ny, dist+1));
					if(temp<dist+1) {
						temp = dist+1;
					}
				}
			}
		}
	}
	
	static boolean afterRotateChecker() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==0) return false;
			}
		}
		return true;
	}
	
	static boolean checker() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==0) return false;
			}
		}
		return true;
	}
}
