package b23000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23747 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[n][m];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		String str = br.readLine();
		
		boolean[][] visited = new boolean[n][m];
		for(int i=0; i<str.length(); i++) {
			char cmd = str.charAt(i);
			if(cmd=='W') {
//				if(checker(visited, x, y)) continue;
				bfs(arr, visited, x, y);
			}else if(cmd=='L') {
				y--;
			}else if(cmd=='R') {
				y++;
			}else if(cmd=='U') {
				x--;
			}else {
				x++;
			}
		}
		for(int i=0; i<4; i++) {
			int nr = x+dr[i];
			int nc = y+dc[i];
			if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length) {
				visited[nr][nc] = true;
			}
		}
		visited[x][y] = true;
		for(boolean[] a : visited) {
			for(boolean b : a) {
				if(b) sb.append(".");
				else sb.append("#");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(char[][] arr, boolean[][] visited, int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		char ch = arr[x][y];
		visited[x][y] = true;
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && !visited[nr][nc] && arr[nr][nc]==ch) {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc));
				}
			}
		}
		
	}

	static boolean checker(boolean[][] visited, int r, int c) {
		if(visited[r][c]) return true;
		else return false;
	}
}
