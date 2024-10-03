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
		
		// ���� ĭ �� n
		int n = Integer.parseInt(st.nextToken());
		// ���̷��� �� k
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
		// �ҿ� �ð�
		int s = Integer.parseInt(st.nextToken());
		// ��, ��
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		// ȿ�� �鿡���� �ٲ� �ڸ��� üũ�� ����,
		// �ٲ� �ڸ��� �� ���� �̻��� ���ڰ� �����Ϸ� �ϴ� ��쿡�� ��� �񱳸� ���� ���� �����ϴ� ����� �� ���� ��� �ƴѰ�?

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
		// queue�� num ������� ó�� �� �ѹ��� ���� ���ָ� ���ĺ��ʹ� ������ �����.
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
