package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {

	static int n, m;
	static char[][] arr;
	static boolean[][][] visit;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int min = Integer.MAX_VALUE;
	static class Node{
		int r;
		int c;
		int move;
		boolean br;
		public Node(int r, int c, int move, boolean br) {
			this.r = r;
			this.c = c;
			this.move = move;
			this.br = br;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		visit = new boolean[2][n][m];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		bfs(0, 0);
		System.out.println(min==Integer.MAX_VALUE ? -1 : min);
		
	}

	static void bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(r, c, 1, false));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.r==n-1 && cur.c==m-1) {
				min = Math.min(min, cur.move);
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<m) {
					// 벽을 이미 뚫은 경우
					if(cur.br) {
						if(!visit[1][nr][nc] && arr[nr][nc]=='0') {
							q.add(new Node(nr, nc, cur.move+1, cur.br));
							visit[1][nr][nc] = true;
						}
					}else {
						// 벽을 뚫은 적이 없다.
						if(!visit[0][nr][nc]) {
							if(arr[nr][nc]=='0') {
								q.add(new Node(nr, nc, cur.move+1, cur.br));
								visit[0][nr][nc] = true;
							}else {
								q.add(new Node(nr, nc, cur.move+1, true));
								visit[1][nr][nc] = true;
							}
						}
					}
					
				}
			}
		}
	}
}
