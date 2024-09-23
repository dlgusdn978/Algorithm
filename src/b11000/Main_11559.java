package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main_11559 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = new char[12][6];
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int count = 0;
		
		for(int i=0; i<12; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		while(true) {
			visited = new boolean[arr.length][arr[0].length];
			if(!find(arr, visited)) break; 
//			visited = new boolean[arr.length][arr[0].length];
			move(arr);
			count++;
//			print(arr);
		}
		System.out.println(count);
	}
	static void print(char[][] arr) {
		for(char[] a : arr) {
			for(char b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	static boolean find(char[][] arr, boolean[][] visited) {
		boolean flag = false;

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]=='.'||visited[i][j]) continue;
				int res = bfs(arr, visited, i, j, arr[i][j]);
				if(res>=4) {
					destroy(arr, visited);
					flag = true;
				}
//				print(arr);
//				System.out.println();
				visited = new boolean[arr.length][arr[0].length];
			}
		}

		return flag;
	}
	static int bfs(char[][] arr, boolean[][] visited, int r, int c, char color) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{r, c});
		visited[r][c] = true;
		int count = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				
				if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && !visited[nr][nc] && color==arr[nr][nc]) {
					q.add(new int[] {nr,nc});
					visited[nr][nc] = true;
					count++;
				}
			}
		}
		return count;
	}
	static void destroy(char[][] arr, boolean[][] visited) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(visited[i][j]) arr[i][j] = '.';
			}
		}
	}
	static void move(char[][] arr) {
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i][j] == '.') {
                    int k = i - 1;
                    while (k >= 0 && arr[k][j] == '.') {
                        k--;
                    }
                    if (k >= 0) {
                        arr[i][j] = arr[k][j];
                        arr[k][j] = '.';
                    }
                }
            }
        }
    }
}
