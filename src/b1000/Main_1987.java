package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 {

	static int n, m;
	static int max = Integer.MIN_VALUE;
	static char[][] arr;
	static boolean[] alphabet;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 행 n
		n = Integer.parseInt(st.nextToken());
		// 열 m
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		alphabet = new boolean[26];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, 0);
		
		System.out.println(max);
	}

	static void dfs(int r, int c, int count) {
		// 현재 위치 방문 체크
		alphabet[arr[r][c]-65] = true;
		max = Math.max(max, count+1);
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<n && nc>=0 && nc<m && !alphabet[arr[nr][nc]-65]) {
				dfs(nr, nc, count+1);
			}
		}
		alphabet[arr[r][c]-65] = false;
	}
}
