package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11437 {

	static int n,m;
	static int[] depths;
	static int[] parents;
	static List<Integer>[] nodeList;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 노드의 개수 n
		n = Integer.parseInt(br.readLine());
		// 트리상 연결된 두 정점
		
		depths = new int[n+1];
		parents = new int[n+1];
		
		nodeList = new ArrayList[n+1];
		sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			nodeList[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			nodeList[start].add(end);
			nodeList[end].add(start);
		}
		makeTree(1, 1, 0);
		
		// 반복횟수 m
		m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			findLCA(first, second);
		}
		System.out.println(sb.toString());
	}

	static void makeTree(int cur, int depth, int parent) {
		depths[cur] = depth;
		parents[cur] = parent;
		for(int a: nodeList[cur]) {
			if(a!=parent) {
				makeTree(a, depth+1, cur);
			}
		}
	}
	static void findLCA(int firstNode, int secondNode) {
		int firstDepth = depths[firstNode];
		int secondDepth = depths[secondNode];

		while(firstDepth>secondDepth) {
			firstNode = parents[firstNode];
			firstDepth--;
		}
		while(firstDepth<secondDepth) {
			secondNode = parents[secondNode];
			secondDepth--;
		}
		while(firstNode!=secondNode) {
			firstNode = parents[firstNode];
			secondNode = parents[secondNode];	
			
		}
		sb.append(firstNode).append("\n");
		
	}
}
