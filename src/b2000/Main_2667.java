package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2667 {

	static int n;
	static int[][] arr;
	static boolean[][] visit;
	static int count = 1;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[] homeCount;
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				arr[i][j] = str.charAt(j)-48;
			}
		}
		
		// 1이면서 방문하지 않은 단지 탐색.
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]!=0 && !visit[i][j]) {
					bfs(i, j);
//					print();
				}
			}
		}
		getHomeCount();
	}

	static void bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(r, c));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			arr[cur.r][cur.c] = count;
			
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<n && !visit[nr][nc] && arr[nr][nc]==1) {
					visit[nr][nc] = true;
					q.add(new Node(nr, nc));
				}
			}
		}
		count++;
	}
	static void getHomeCount() {
		homeCount = new int[count-1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]!=0) homeCount[arr[i][j]-1] += 1;
			}
		}
		Arrays.sort(homeCount);
		System.out.println(count-1);
		for(int a : homeCount) {
			System.out.println(a);
		}
	}
	static void print() {
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
