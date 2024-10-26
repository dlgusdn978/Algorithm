package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14950 {
	static class Node{
		int start;
		int end;
		int weight;
		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		// n개의 도시와 m개의 도로
		// 1번 start, 양방향도로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int[] parents = new int[n+1];
		makeSet(parents);
		List<Node> list = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Node(start, end, weight));
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight-o2.weight;
			}
		});
		//mst
		int count = 0;
		int sum = 0;
		for(Node o1 : list) {
			if(union(parents, o1.start, o1.end)) {
				sum+=o1.weight+(count*t);
				if(count++==n-1) break;
			}
		}
		System.out.println(sum);
	}

	static void makeSet(int[] parents) {
		for(int i=1; i<parents.length; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int[] parents, int v1) {
		if(v1==parents[v1]) return v1;
		else return parents[v1] = findSet(parents, parents[v1]);
	}
	
	static boolean union(int[] parents, int v1, int v2) {
		int aRoot = findSet(parents, parents[v1]);
		int bRoot = findSet(parents, parents[v2]);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
