package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2615 {

	static int[] dr = {0, 1, 1, -1};
	static int[] dc = {1, 1, 0, 1};
	static class Node{
		int r;
		int c;
		int dir;
		int cnt;
		public Node(int r, int c, int dir, int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 오른쪽, 오른쪽 아래, 아래, 왼쪽 아래 탐색

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[][] arr = new int[19][19];
		for(int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int x = -1;
		int y = -1;
		boolean[][][] visited = new boolean[4][19][19];
		boolean flag = false;
		for(int j=0; j<19; j++) {
			if(flag) break;
			for(int i=0; i<19; i++) {
				int max = 0;
				if(arr[i][j]!=0) {
					max = bfs(arr, visited, i, j, arr[i][j]);
				}
				
				if(max==5) {
					x = i;
					y = j;
					flag = true;
					break;
				}
			}
		}
		if(flag) {
			System.out.println(arr[x][y]);
			System.out.println((x+1)+" "+(y+1));
		}else {
			System.out.println(0);
		}
	}

	static int bfs(int[][] arr, boolean[][][] visited, int r, int c, int num) {
		Queue<Node> q = new ArrayDeque<>();
		for(int i=0; i<4; i++) {
			q.add(new Node(r, c, i, 1));
			visited[i][r][c] = true;
		}
		int max = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int nr = cur.r+dr[cur.dir];
			int nc = cur.c+dc[cur.dir];
			
			
			if(nr>=0&& nr<arr.length && nc>=0 && nc<arr[0].length) {
				if(arr[nr][nc]==num && !visited[cur.dir][nr][nc]) {
					visited[cur.dir][nr][nc] = true;
					max = Math.max(max, cur.cnt+1);
					q.add(new Node(nr, nc, cur.dir, cur.cnt+1));
				}else if(arr[nr][nc]!=num && cur.cnt==5) {
					max = 5;
					break;
				}
				
			}
		}
		
		return max;
	}
}
