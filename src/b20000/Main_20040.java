package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_20040 {

	static class Node{
		int start;
		int end;
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		makeSet(n);
		
		List<Node> list = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Node(start, end));
		}

//		Collections.sort(list, new Comparator<Node>() {
//			@Override
//			public int compare(Node o1, Node o2) {
//				return o1.start==o2.start ? o1.end-o2.end : o1.start-o2.start;
//			}
//		});
		int count = 1;
		for(Node cur : list) {
			if(union(cur.start, cur.end)) {
				count++;
			}else {
				break;
			}
		}
		System.out.println(count>m ? 0 : count);
	}

	static void makeSet(int n) {
		parents = new int[n];
		for(int i=0; i<n; i++) {
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
