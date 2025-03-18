package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20165 {

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
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		char[][] ch = new char[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				ch[i][j] = 'S';
			}
		}
		int score = 0;
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			char dir = st.nextToken().charAt(0);
			int dirNum = -1;
			
			if(dir=='E') dirNum = 0;
			else if(dir=='S') dirNum = 1;
			else if(dir=='W') dirNum = 2;
			else dirNum = 3;
			
			score += destroy(arr, ch, x, y, dirNum);
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken())-1;
			build(ch, w, z);

		}
		System.out.println(score);
		print(ch);
	}
	static void build(char[][] ch, int w, int z) {
		ch[w][z] = 'S';
	}
	static int destroy(int[][] arr, char[][] ch, int r, int c, int dirNum) {
		if(ch[r][c]=='F') return 0;
		
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		visited[r][c] = true;
		q.add(new Node(r, c, arr[r][c]));
		
		int curScore = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();

			int nr = cur.r;
			int nc = cur.c;
			int cnt = cur.cnt;
			for(int i=arr[cur.r][cur.c]; i>1; i--) {
				nr += dr[dirNum];
				nc += dc[dirNum];
				if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && ch[nr][nc]!='F') {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc, cnt--));
				}
			}
			
		}
		for(int i=0; i<visited.length; i++) {
			for(int j=0; j<visited[0].length; j++) {
				if(visited[i][j]) {
					if(ch[i][j]=='S') curScore++;
					ch[i][j] = 'F';
				}
			}
		}

		return curScore;
	}
	static void print(char[][] ch) {
		for(char[] a : ch) {
			for( char b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
}
