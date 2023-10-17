package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14503 {

	// 방의 행 n
	static int n;
	// 방의 열 m
	static int m;
	// 시작 행 cr;
	static int cr;
	// 시작 열 cc;
	static int cc;
	// 시작 방향
	static int cdir;
	// 사방탐색
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	// 배열
	static int[][] arr;
	// 카운트
	static int count=1;
	// 방문탐색
	static boolean[][] visit;
	
	// 청소기 클래스
	static class Robot{
		int r;
		int c;
		int dir; // 0 = 북쪽, 1 = 동쪽, 2 == 남쪽, 3 == 서쪽
		public Robot(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		cr = Integer.parseInt(st.nextToken());
		cc = Integer.parseInt(st.nextToken());
		cdir = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(cr, cc, cdir);
		System.out.println(count);
	}
	static void dfs(int r, int c, int dir) {
		
		arr[r][c] = -1;
		for(int i=0; i<4; i++) {
			dir = (dir+3)%4;
			
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr>=0 && nr<n && nc>=0 && nc<m) {
				if(arr[nr][nc]==0) {
					count++;
					dfs(nr, nc, dir);
					return;
				}
			}
		}
		int d = (dir+2)%4;
		int br = r+dr[d];
		int bc = c+dc[d];
		if(br>=0 && br<n && bc>=0 && bc<m && arr[br][bc]!=1) {
			dfs(br,bc,dir);
		}
	}
}
