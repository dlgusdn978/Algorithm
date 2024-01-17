package b10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_10775 {

	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		boolean[] visit = new boolean[g+1];
		makeSet(g);
		int count = 0;
		for(int i=1; i<=p; i++) {
			int num = Integer.parseInt(br.readLine());
			
			int gate = findSet(num);
			if(gate==0) {
				break;
			}
			union(gate-1, gate);
			count++;
			
		}
//		System.out.println(Arrays.toString(parents));
		System.out.println(count);
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
