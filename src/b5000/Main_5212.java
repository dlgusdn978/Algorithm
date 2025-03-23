package b5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5212 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[n+2][m+2];
		for(int i=0; i<arr.length; i++) {
			Arrays.fill(arr[i], '.');
		}
		for(int i=1; i<=n; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=1; j<=m; j++) {
				arr[i][j] = ch[j-1];
			}
		}
		
		boolean[][] visited = new boolean[n+2][m+2];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(arr[i][j]=='.') continue;
				if(checker(arr, i, j)) {
					visited[i][j] = true;
				}
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(visited[i][j]) arr[i][j] = '.';
			}
		}

		
		int x1 = 0;
		int y1 = 0;
		int x2 = n+2;
		int y2 = m+2;
		
		for(int i=0; i<n+2; i++) {
			int cnt = 0;
			for(int j=0; j<m+2; j++) {
				if(arr[i][j]=='.') cnt++;
			}
			if(cnt==m+2) x1++;
			else break;
		}
		for(int i=m+1; i>=0; i--) {
			int cnt = 0;
			for(int j=0; j<n+2; j++) {
				if(arr[j][i]=='.') cnt++;
			}
			if(cnt==n+2) y2--;
			else break;
		}
		for(int i=n+1; i>=0; i--) {
			int cnt = 0;
			for(int j=0; j<m+2; j++) {
				if(arr[i][j]=='.') cnt++;
			}
			if(cnt==m+2) x2--;
			else break;
		}
		for(int i=0; i<m+2; i++) {
			int cnt = 0;
			for(int j=0; j<n+2; j++) {
				if(arr[j][i]=='.') cnt++;
			}
			if(cnt==n+2) y1++;
			else break;
		}
		
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	static void print(char[][] arr) {
		for(char[] a : arr) {
			for(char b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	static boolean checker(char[][] arr, int r, int c) {
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && arr[nr][nc]=='.') cnt++;
		}

		if(cnt>=3) return true;
		else return false;
	}

}
