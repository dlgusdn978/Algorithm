package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {

	static int n;
	static int[][] arr;
	static boolean[][] visit;
	static boolean[][] ate;
	static int[][] bfsCount;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1 ,0};
	static int move;
	static class Fish{
		int r;
		int c;
		int size;
		int exp;
		public Fish(int r, int c, int size, int exp) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.exp = exp;
		}
	}
	static class MovingFish{
		int r;
		int c;
		int moveCount;
		public MovingFish(int r, int c, int moveCount) {
			this.r = r;
			this.c = c;
			this.moveCount = moveCount;
		}
	}
	static Fish shark;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		ate = new boolean[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 9) {
					shark = new Fish(i, j, 2, 0);
				}else {
					arr[i][j] = temp;
				}
			}
		}
		
		while(findEdibleFish()) {
			bfs();
			findFish();
			checkSharkStatus();
		}
		System.out.println(move);
	}
	// 먹을 수 있는 물고기 있는지 확인
	static boolean findEdibleFish() {
		boolean flag = false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]!=0 && arr[i][j]<shark.size && !ate[i][j]) flag = true;
			}
		}
		return flag;
	}
	// 물고기 위치 찾기.
	static void findFish() {
		int r = -1;
		int c = -1;

		int dist = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 물고기를 찾았을 때
				if(arr[i][j]!=0 && !ate[i][j]) {
					if(arr[i][j]<shark.size) {
							// 가장 가까운 물고기 찾기
							// 현재 찾은 물고기와의 거리
							int count = bfsCount[i][j];
							if(count == Integer.MAX_VALUE) continue;
							if(count==dist) {
								// 거리가 같기 때문에 가장 위에 있는 물고기 선택
								if(r==i) {
									// 행도 같아
									if(j<c) {
										r = i;
										c = j;
										dist = count;
									}
								}else if(i<r) {
									r = i;
									c = j;
									dist = count;
								}
							}else if(count<dist) {
								r = i;
								c = j;
								dist = count;
							}
							
						}
					
				}
			}
		}
//		System.out.println("다음 물고기의 위치는 r : " +r + ", c : "+c + ", size 는 : "+size +", 거리는 : "+dist);
		if(dist!=Integer.MAX_VALUE) {
			shark = new Fish(r, c, shark.size, shark.exp+1);
			ate[r][c] = true;
			arr[r][c] = 0;
			move+=dist;
		}else {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					ate[i][j] = true;
				}
			}
		}
	}
	
	
	static void bfs() {
		//방문체크 초기화
		visit = new boolean[n][n];
		bfsCount = new int[n][n];
		Queue<MovingFish> q = new ArrayDeque<>();
		q.add(new MovingFish(shark.r, shark.c, 0));
//		System.out.println(shark.r+" "+shark.c);
		for(int i=0; i<n; i++) {
			Arrays.fill(bfsCount[i], Integer.MAX_VALUE);
		}
		while(!q.isEmpty()) {
			MovingFish cur = q.poll();
			bfsCount[cur.r][cur.c] = Math.min(bfsCount[cur.r][cur.c], cur.moveCount);
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<n && !visit[nr][nc] && arr[nr][nc]<=shark.size) {
					visit[nr][nc] = true;
					q.add(new MovingFish(nr, nc, cur.moveCount+1));
				}
			}
		}
		// 
	}
	
	// 상어 경험치 확인.
	static void checkSharkStatus() {
		if(shark.exp == shark.size) {
			ate = new boolean[n][n];
			shark = new Fish(shark.r, shark.c, shark.size+1, 0);
		}
	}
}
