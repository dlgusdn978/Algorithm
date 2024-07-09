package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_16724 {

	static int[] parents;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		makeSet(n, m);
		
		
		char[][] arr = new char[n][m];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		if(n==1 && m==1) {
			System.out.println(1);
			return;
		}
		boolean[][] visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(visited[i][j]) continue;
				dfs(arr, visited, i, j, n, m);
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<parents.length; i++) {
			set.add(findSet(parents[i]));
		}

		System.out.println(set.size());
	}
	static void dfs(char[][] arr, boolean[][] visited, int i, int j, int n, int m) {
		char cur = arr[i][j];
		visited[i][j] = true;
		switch(cur) {
		case 'R':
			if(union(i*m+j, (i+dr[0])*m+j+dc[0])) dfs(arr, visited, i+dr[0], j+dc[0], n, m);
			else return;
			break;
		case 'D':
			if(union(i*m+j, (i+dr[1])*m+j+dc[1])) dfs(arr, visited, i+dr[1], j+dc[1], n, m);
			else return;
			break;
		case 'L':
			if(union(i*m+j, (i+dr[2])*m+j+dc[2])) dfs(arr, visited, i+dr[2], j+dc[2], n, m);
			else return;
			break;
		case 'U':
			if(union(i*m+j, (i+dr[3])*m+j+dc[3])) dfs(arr, visited, i+dr[3], j+dc[3], n, m);
			else return;
			break;
		}
	}
	static void makeSet(int n, int m) {
		parents = new int[n*m];
		for(int i=0; i<parents.length; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int v1) {
		if(v1==parents[v1]) return v1;
		else return parents[v1] = findSet(parents[v1]);
	}
	
	static boolean union(int v1, int v2) {
		int aRoot = findSet(v1);
		int bRoot = findSet(v2);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

}
