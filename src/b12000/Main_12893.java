package b12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12893 {

	static class Node{
		int start;
		int end;
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	static int[] parents;
	static int[] enemy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		
		makeSet(n);
		enemy = new int[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int aParent = findSet(a);
			int bParent = findSet(b);
			
			if(aParent==bParent) {
				System.out.println(0);
				return;
			}
			int aEnemy = enemy[a];
			int bEnemy = enemy[b];
			
			if(aEnemy!=0) {
				union(aEnemy, b);
			}else {
				enemy[a] = b;
			}
			
			if(bEnemy!=0) {
				union(bEnemy, a);
			}else {
				enemy[b] = a;
			}
			
		}
		System.out.println(1);
		
		
	}

	static void makeSet(int n) {
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
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
