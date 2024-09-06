package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main_2665 {

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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[n][n];
		int[][] dist = new int[n][n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		bfs(arr, dist);

	}

	static void bfs(char[][] arr, int[][] dist) {
		Deque<Node> dq = new ArrayDeque<>();
		dq.add(new Node(0, 0, 0));
		dist[0][0] = 1;
		while(!dq.isEmpty()) {
			Node cur = dq.poll();

			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr>=0 && nr<arr.length && nc>=0 && nc<arr.length) {
					int nextDist = arr[nr][nc]=='1' ? 0 : 1;
					int newCnt = cur.cnt+nextDist;
//					System.out.println(newCnt);
					if(newCnt<dist[nr][nc]) {
						dist[nr][nc] = newCnt;
						if(arr[nr][nc]=='1') {
							dq.addFirst(new Node(nr, nc, cur.cnt));
						}else {
							dq.addLast(new Node(nr, nc, cur.cnt+1));
						}
					}
					
				}
			}
		}
		System.out.println(dist[arr.length-1][arr.length-1]);
	}
}
