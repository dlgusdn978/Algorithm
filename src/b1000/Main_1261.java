package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1261 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int[][] dist = new int[n][m];
		for(int i=0; i<n; i++) {
			String[] els = br.readLine().split("");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(els[j]);
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		bfs(arr, dist);
	}

	static void bfs(int[][] arr, int[][] dist) {
		Deque<Node> q = new ArrayDeque<>();
		Node start = new Node(0, 0, 0);

		q.add(start);
		
		dist[0][0] = 0;

		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length) {
					int newCount = cur.count + arr[nr][nc];
					if(newCount<dist[nr][nc]) {
						dist[nr][nc] = newCount;
						if(arr[nr][nc]==1) q.addLast(new Node(nr, nc, newCount));
						else q.addFirst(new Node(nr, nc, newCount));
					}
				}
			}
		}
		System.out.println(dist[dist.length-1][dist[0].length-1]);
	}
}
