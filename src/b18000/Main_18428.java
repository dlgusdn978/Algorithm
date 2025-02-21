package b18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18428 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static String res = "NO";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		String[][] arr = new String[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		
		dfs(arr, 0, 0, 0);
		System.out.println(res);
	}

	static void dfs(String[][] arr, int r, int c, int cnt) {
		if(res.equals("YES")) return;
		if(cnt==3) {
//			print(arr);
			if(find(arr)) res = new String("YES");
			return;
		}

		for(int i=r; i<arr.length; i++) {
			for(int j=(i==r ? c : 0); j<arr.length; j++) {
				if(arr[i][j].equals("T")||arr[i][j].equals("S")) continue;
				arr[i][j] = new String("O");
				dfs(arr, i, j+1, cnt+1);
				arr[i][j] = new String("X");
			}
		}
	}
	static boolean find(String[][] arr) {
		boolean[][] visited = new boolean[arr.length][arr.length];
		boolean temp = true;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j].equals("T")) check(arr, i, j, visited);
			}
		}
//		print(arr);
//		for(boolean[] a : visited) {
//			for(boolean b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(visited[i][j]==true && arr[i][j].equals("S")) {
					temp = false;
					break;
				}
			}
		}
		return temp;
	}
	static void check(String[][] arr, int i, int j, boolean[][] visited) {
		for(int k=0; k<4; k++) {
			int nr = i+dr[k];
			int nc = j+dc[k];
			while(nr>=0 && nr<arr.length && nc>=0 && nc<arr.length && !arr[nr][nc].equals("O")) {
				visited[nr][nc] = true;
				nr+=dr[k];
				nc+=dc[k];
			}
		}
	}
	static void print(String[][] arr) {
		for(String[] a : arr) {
			for(String b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
}
