package b27000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_27978 {
	static int[] dr = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] dc = {1, 1, 1, 0, -1, -1, -1, 0};
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
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int startX = 0;
		int startY = 0;
		// end를 줘야하나?
		int endX = 0;
		int endY = 0;
		char[][] arr = new char[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				char cur = str.charAt(j);
				if(cur=='K') {
					startX = i;
					startY = j;
				}else if(cur=='*') {
					endX = i;
					endY = j;
				}
				arr[i][j] = cur;
			}
		}
		int res = bfs(arr, startX, startY, endX, endY);
		if(res==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(res);
	}

	static int bfs(char[][] arr, int startX, int startY, int endX, int endY) {
		Queue<Node> q = new ArrayDeque<>();
		int[][] moveCnt = new int[arr.length][arr[0].length];
		for(int i=0; i<moveCnt.length; i++) {
			Arrays.fill(moveCnt[i], Integer.MAX_VALUE);
		}
		q.add(new Node(startX, startY, 0));
		moveCnt[startX][startY] = 0;
		
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int i=0; i<8; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && arr[nr][nc]!='#') {
					// 오른쪽 방향으로 이동
					int nCnt = i<3 ? cur.cnt : cur.cnt+1;
					if(nCnt<moveCnt[nr][nc]) {
						q.add(new Node(nr, nc, nCnt));
						moveCnt[nr][nc] = nCnt;
					}
				}
			}
		}
		return moveCnt[endX][endY];
	}
}
