package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14574 {

	static int n;
	static int[] parents;
	static List<Node> list;
	static Cooker[] cook;
	static List<List<Integer>> select;
	static boolean[] visit;
	static class Cooker{
		int p;
		int c;
		public Cooker(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}
	static class Node{
		int from;
		int to;
		int weight;
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		
		visit = new boolean[n+1];
		list = new ArrayList<>();
		cook = new Cooker[n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cook[i] = new Cooker(p, c);
		}

		// 실력 p 와 인기도 c를 모두 입력받아서.
		// 각 노드와 간선을 만들기.
		
		for(int i=1; i<=n-1; i++) {
			for(int j=i+1; j<=n; j++) {
				Cooker left = cook[i];
				Cooker right = cook[j];
				
				int percent = (left.c+right.c)/(Math.abs(left.p-right.p));
				list.add(new Node(i, j, percent));
			}
		}
//		System.out.println(list.size());
//		for(Node n : list) {
//			System.out.println(n.from+" "+n.to+" "+n.weight);
//		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.weight-o1.weight;
			}
		});
//		System.out.println();
//		for(Node n : list) {
//			System.out.println(n.from+" "+n.to+" "+n.weight);
//		}
//		
		makeSet();
		select = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			select.add(new ArrayList<>());
		}
		// 최댓값 구하기
		int count = 0;
		long total = 0;
		for(Node node : list) {
			if(union(node.from, node.to)) {
				total += node.weight;
				select.get(node.from).add(node.to);
				select.get(node.to).add(node.from);
//				System.out.println(select.get(node.from));
//				System.out.println(select.get(node.to));
//				System.out.println();
				if(++count==n-1) break;
			}
		}
		System.out.println(total);
		dfs(3);
	}

	static void dfs(int cur) {
		visit[cur] = true;
		for(Integer next : select.get(cur)) {
			if(visit[next]) continue;
			dfs(next);
			System.out.println(cur+" "+next);
		}
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
