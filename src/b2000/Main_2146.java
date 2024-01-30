package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146 {

	static int n;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1 ,0};
	static int min = Integer.MAX_VALUE;
	static class Node{
		int r;
		int c;
		int num;
		public Node(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	public static void main(String[] args) throws IOException {
		// 처음에 땅 정보 입력 받고
		// 반복문 돌리면서 !visit && arr[i][j] !=0 인곳 찾아서 bfs 탐색.
		// 처음 찾은 땅의 번호와 일치하는 경우 count 세지 않음.
		// 땅의 번호가 0일 때는 count+1
		// 땅의 번호와 일치하지 않음 && 땅 !=0 인 경우 bfs 종료.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num = 2;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]!=0 && !visit[i][j]) {
					divide(i, j, num);
					num++;
				}
			}
		}
		
		
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]>0) {
					visit = new boolean[n][n];
					int res = search(i, j);
					
					if(res==-1) continue;
					min = Math.min(min, res);
				}
			}
		}
		
//		print();
		System.out.println(min-1);
	}

	static void divide(int r, int c, int num) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(r, c, num));
		visit[r][c] = true;
		arr[r][c] = num;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 & nc<n && !visit[nr][nc] && arr[nr][nc]==1) {
					visit[nr][nc] = true;
					arr[nr][nc] = num;
					q.add(new Node(nr, nc, num));
				}
			}
		}
	}
	static int search(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(r, c, 0));
		visit[r][c] = true;
		int num = arr[r][c];
		while(!q.isEmpty()) {
			Node cur = q.poll();

			if(arr[cur.r][cur.c]!=0 && num!=arr[cur.r][cur.c]) {
				return cur.num;
			}
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 & nc<n && !visit[nr][nc] && arr[nr][nc]!=num) {
					visit[nr][nc] = true;
					q.add(new Node(nr, nc, cur.num+1));
				}
			}
		}
		return -1;
	}
	static void print() {
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
			
		}
	}
}
