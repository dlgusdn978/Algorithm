package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1185 {

	static int n, p;
	static int[] visitCost;
	static List<Node> list;
	static int[] parents;
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st = new StringTokenizer(br.readLine());
		
		// 방문할 나라의 수 n
		n = Integer.parseInt(st.nextToken());
		// 연결하는 길의 수 p;
		p = Integer.parseInt(st.nextToken());

		// 각 나라 방문 비용
		visitCost = new int[n+1];
		for(int i=1; i<=n; i++) {
			visitCost[i] = Integer.parseInt(br.readLine());
		}
		list = new ArrayList<Node>();
		// 리스트 초기화
//		for(int i=1; i<=n; i++) {
//			list[i] = new ArrayList<>();
//		}
		// 각 나라 간 이동 비용 입력
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Node(start, end, weight+visitCost[end]));
			list.add(new Node(end, start, weight+visitCost[start]));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight-o2.weight;
			}
		});
		
		makeSet();
		
		int count = 0;
		int total = 0;
		
		for(Node node : list) {
			if(union(node.from, node.to)) {
				total += node.weight;
				System.out.println(node.from+" "+node.to+" 연결, 비용 : "+node.weight+", 연결 결과 : "+total);
				if(++count==n-1) break;
			}
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
