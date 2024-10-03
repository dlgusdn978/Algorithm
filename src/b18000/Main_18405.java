package b18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_18405 {

	static class Virus{
		int r;
		int c;
		int num;
		int time;
		public Virus(int r, int c, int num, int time) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.time = time;
		}
	}
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 격자 칸 수 n
		int n = Integer.parseInt(st.nextToken());
		// 바이러스 수 k
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];
		boolean[][] visited = new boolean[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		// 소요 시간
		int s = Integer.parseInt(st.nextToken());
		// 행, 열
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		// 효율 면에서는 바뀐 자리만 체크한 다음,
		// 바뀐 자리를 두 가지 이상의 숫자가 선점하려 하는 경우에만 대소 비교를 통해 값을 변경하는 방법이 더 좋은 방법 아닌가?

		bfs(arr, visited, s, x, y);

//		for(int[] a : arr) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		System.out.println(arr[x][y]);
		
	}
	
	static void bfs(int[][] arr, boolean[][] visited, int time, int x, int y) {
		// queue를 num 순서대로 처음 딱 한번만 정렬 해주면 이후부터는 순서가 보장됨.
		PriorityQueue<Virus> q = new PriorityQueue<>(new Comparator<Virus>() {

			@Override
			public int compare(Virus o1, Virus o2) {
				// TODO Auto-generated method stub
				return o1.time==o2.time ? o1.num-o2.num : o1.time-o2.time;
			}
		});
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				if(arr[i][j]!=0) {
					q.add(new Virus(i, j, arr[i][j], 0));
				}
			}
		}

		while(!q.isEmpty()) {
			Virus cur = q.poll();
			
			if(cur.time>time) break;
			
			if(visited[cur.r][cur.c]) continue;
			visited[cur.r][cur.c] = true;
			
			arr[cur.r][cur.c] = cur.num;

			
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=1 && nr<arr.length && nc>=1 && nc<arr.length && !visited[nr][nc] && arr[nr][nc]==0) {
					q.add(new Virus(nr, nc, cur.num, cur.time+1));
				}
			}
		}
	}
}
