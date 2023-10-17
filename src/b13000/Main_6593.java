package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593 {

	static int f, n, m;
	static char[][][] arr;
	static int[] dr = {0, 1, 0, -1, 0, 0};
	static int[] dc = {1, 0, -1, 0, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	static boolean[][][] visit;
	static int count;
	static int temp;
	static int startr, startc, starth;
	static class Node{
		int h;
		int r;
		int c;
		int count;
		public Node(int h, int r, int c, int count) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
			this.count = count;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			// 층 수 f
			f = Integer.parseInt(st.nextToken());
			// 세로 n
			n = Integer.parseInt(st.nextToken());
			// 가로 m
			m = Integer.parseInt(st.nextToken());
			
			if(n==0 && m==0 && f==0) break;
			
			arr = new char[f][n][m];
			visit = new boolean[f][n][m];
			temp = 0;
			count = Integer.MAX_VALUE;
			
			for(int i=0; i<f; i++) {
				for(int j=0; j<n; j++) {
					String str = br.readLine();
					for(int k=0; k<m; k++) {
						arr[i][j][k] = str.charAt(k);
						if(arr[i][j][k]=='S') {
							starth = i;
							startr = j;
							startc = k;
						}
					}
				}
				br.readLine();
			}

			bfs(starth, startr, startc, 0);
			sb.append(count!=Integer.MAX_VALUE ? "Escaped in "+count+" minute(s).\n" : "Trapped!\n");
		}
		System.out.println(sb.toString().trim());
	}

	static void bfs(int h, int r, int c, int co) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(h, r, c, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(arr[cur.h][cur.r][cur.c]=='E') {
				count = cur.count;
				return;
			}
			for(int i=0; i<6; i++) {
				int nh = cur.h+dh[i];
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<m && nh>=0 && nh<f && arr[nh][nr][nc]!='#' && cur.count+1<count && !visit[nh][nr][nc]) {
					visit[nh][nr][nc] = true;
					q.add(new Node(nh, nr, nc, cur.count+1));
				}
			}
		}
		
	}
	
	
}
