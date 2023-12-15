package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638 {

	static int n, m;
	static int[][] arr;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1 ,0};
	static boolean[][] visit;
	static int remnant;
	static int count;
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		// 구현 순서
		// 1. (0,0) 부터 공기 유입 시작
		// 2. 모든 좌표 돌고 아닌 0인 부분 방문 체크하기.
		// 3. 다시 모든 좌표 돌면서 치즈 확인.
		// 4. 사방탐색 돌리고 2면 이상이 "방문 체크된 0인" 좌표가 존재한다면 melt
		// 5. 위 과정을 반복.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int temp =  Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				if(temp==1) remnant++;
			}
		}
		
		while(remnant!=0) {
			injectAir();
			meltCheese();
			initialize();
			count++;
		}
		System.out.println(count);
	}
	
	// 공기 주입
	static void injectAir() {
		// 0,0 좌표부터 시작해서 전체 좌표 사방탐색
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0,0));
		visit[0][0] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<m && !visit[nr][nc] && arr[nr][nc]==0) {
					visit[nr][nc] = true;
					q.add(new Node(nr, nc));
				}
			}
		}
	}
	
	// 치즈 녹이기
	static void meltCheese() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// 치즈 만남.
				if(arr[i][j]==1) {
					int count = 0;
					// 사방탐색
					for(int k=0; k<4; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						// 내부 공간에 있는 공기가 아닌 외부 공기일 때
						if(visit[nr][nc] && arr[nr][nc]==0) {
							count++;
						}
					}
					if(count>=2) arr[i][j] = 2;
				}
			}
		}
		int rem = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==2) arr[i][j]=0;
				if(arr[i][j]==1) rem++;
			}
		}
		remnant = rem;
	}
	
	// 초기화
	static void initialize() {
		visit = new boolean[n][m];
	}
	
}
