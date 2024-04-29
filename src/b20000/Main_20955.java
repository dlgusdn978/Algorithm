package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_20955 {

	static int[] parents;
	static class Node{
		int start;
		int end;
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		makeSet(n);
		

		List<Node> list = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		// m개의 간선이 주어지는데, 여기서 그래프 형태가 나올 수 있다. 트리형태로 만들고, 전체 간선 수 - (트리) 선택 간선 수
		int min = m;
		int count = 0;
		for(Node node : list) {
			if(union(node.start, node.end)) {
				min--;
				if(++count==n) break;
			}
		}
		Set<Integer> set = new HashSet<>();
		for(int i=1; i<parents.length; i++) {
			set.add(findSet(parents[i]));
		}
		System.out.println(set.size()-1+min);
		
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
