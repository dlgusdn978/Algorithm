package b5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427 {

	static char[][] arr;
	static int[][] fire;
	static boolean[][] visit;
	static int n, m;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int time;
	static class Node{
		int r;
		int c;
		int count;
		public Node(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException {
		// 배열 외부로 나가는 시뮬레이션
		// 불이 먼저 이동한 후 상근이가 이동하는 방식으로 작성.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			// 행렬 nxm
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			arr = new char[n][m];
			visit = new boolean[n][m];
			int r = 0;
			int c = 0;
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<m; j++) {
					char cur = str.charAt(j);
					arr[i][j] = cur;
					if(cur=='@') {
						r = i;
						c = j;
						visit[i][j] = true;
					}
				}
			}
//			for(char[] a : arr) {
//				for(char b : a) {
//					System.out.print(b+" ");
//				}
//				System.out.println();
//			}
			moveFire();
			int min = bfs(r, c);
			System.out.println(min==Integer.MAX_VALUE ? "IMPOSSIBLE" : min);
		}
		
			
	}
	
	static int bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(r, c, 0));
		
		visit[r][c] = true;
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			// fire[i][j] 보다 작고, arr[i][j]가 #이 아닐 때 이동.
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<m) {
					if(cur.count+1<fire[nr][nc] && arr[nr][nc]!='#' && !visit[nr][nc]) {
						visit[nr][nc] = true;
						q.add(new Node(nr, nc, cur.count+1));
					}
				}else {
					min = Math.min(min, cur.count+1);
					return min;
				}
			}
		}
		return min;
	}
	
	
	static void moveFire() {
		Queue<Node> q = new ArrayDeque<>();
		fire = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(fire[i], 1000000);
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]=='*') {
					q.add(new Node(i, j, 0));
					fire[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<m && arr[nr][nc]!='#' && fire[nr][nc]==1000000) {
					fire[nr][nc] = cur.count+1;
					q.add(new Node(nr, nc, cur.count+1));
				}
			}
		}
//		for(int[] a : fire) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
	}
}
