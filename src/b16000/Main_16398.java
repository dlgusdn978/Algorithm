package b16000;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16398 {

	static int n;
	static int[][] arr;
	static int[] parents;
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int weight;
		
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 행성 수
		n = Integer.parseInt(br.readLine());
		// 행렬
		arr = new int[n][n];
		
		List<Node> pq = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int val = Integer.parseInt(st.nextToken());
				arr[i][j] = val;
			}
		}
		makeSet();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				pq.add(new Node(i+1, j+1, arr[i][j]));
			}
		}
		
		Collections.sort(pq);

		int count = 0;
		long total = 0;
		for(Node node : pq) {
			if(union(node.from, node.to)) {
				total+= node.weight;
				if(++count==n-1) break;
			}
		}
		System.out.println(total);
	}

	static void makeSet() {
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
