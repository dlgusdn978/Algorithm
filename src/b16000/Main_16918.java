package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16918 {

	static int[] dr = {0, 1, 0, -1, 0};
	static int[] dc = {1, 0, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[r][c];
		
		boolean[][] visited = new boolean[r][c];
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				char ch = str.charAt(j);
				arr[i][j] = ch;
				if(ch=='O') visited[i][j] = true;
			}
		}

		if(n==1) {
			print(arr);
		}else if(n>1) {
			if(n%2==0) {
				plant(arr);
				print(arr);
			}else if(n%4==3) {
				check(arr, visited);
				plant(arr);
				boom(arr, visited);
				print(arr);
			}else if(n%4==1) {
				check(arr,visited);
				plant(arr);
				boom(arr,visited);
				check(arr,visited);
				plant(arr);
				boom(arr,visited);
				print(arr);
			}
		}
		
	}
	static void check(char[][] arr, boolean[][] visited) {
		boolean[][] temp = new boolean[arr.length][arr[0].length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]=='O' && visited[i][j]) {
					for(int k=0; k<5; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length) {
							temp[nr][nc] = true;
						}
					}
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				visited[i][j] = temp[i][j];
			}
		}
	}
	static void plant(char[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j] = 'O';
			}
		}
	}
	static void boom(char[][] arr, boolean[][] visited) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]=='O' && visited[i][j]) {
					arr[i][j] = '.';
					visited[i][j] = false;
				}
				else visited[i][j] = true;
			}
		}
	}
	static void print(char[][] arr) {
		for(char[] a : arr) {
			for(char b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}
}
