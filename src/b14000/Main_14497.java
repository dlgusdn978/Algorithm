package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_14497 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static class Node{
		int r;
		int c;
		int cnt;
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 행 n
		int n = Integer.parseInt(st.nextToken());
		// 열 m
		int m = Integer.parseInt(st.nextToken());
		
		// 주난의 위치
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		
		// 범인의 위치
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[n][m];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int[][] dist = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		// 0-1 bfs 
		bfs(arr, dist, x1-1, y1-1, x2-1, y2-1);
	}

	static void bfs(char[][] arr, int[][] dist, int x1, int y1, int x2, int y2) {
		Deque<Node> dq = new ArrayDeque<>();
		dq.add(new Node(x1, y1, 0));
		dist[x1][y1] = 0;
		
		while(!dq.isEmpty()) {
			Node cur = dq.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length) {
					if(arr[nr][nc]=='*') continue;
					else {
						int newCnt = cur.cnt+(arr[nr][nc]=='0' ? 0 : 1);
						if(newCnt<dist[nr][nc]) {
							if(arr[nr][nc]=='0') dq.addFirst(new Node(nr, nc, newCnt));
							else dq.addLast(new Node(nr, nc, newCnt));
							
							dist[nr][nc] = newCnt;
						}
					}
				}
				
			}
		}
		System.out.println(dist[x2][y2]);
	}
}
