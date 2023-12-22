package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_1414 {

	static class Node implements Comparator<Node>{
		int from;
		int to;
		int weight;
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compare(Node o1, Node o2) {
			return o1.weight-o2.weight;
		}
	}
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

//		// 65~90
//		System.out.println('A'+0);
//		// 97~122
//		System.out.println('a'+0);
		
		List<Node> list = new ArrayList<Node>();
		int total = 0;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				int num = (str.charAt(j)+0);
				// 소문자일 때
				if(num>96) {
					total+=(num-96);
					if(i==j) continue;
					list.add(new Node(i+1, j+1, num-96));
				}
				// 대문자일 때
				else if(num>49 && num<=96){
					total+=(num-38);
					if(i==j) continue;
					list.add(new Node(i+1, j+1, num-38));
				}

			}
		}
		Collections.sort(list, new Comparator<Node>() {
			
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight-o2.weight;
			}
		});
		// 27 26
		// 1  52
		
		makeSet(n);
		int count = 0;
		int sum = 0;
		for(Node node:list) {
			if(union(node.from, node.to)) {
				sum+=node.weight;
				if(++count==n-1) break;
			}
		}
		System.out.println(count==n-1?total-sum : -1);
	}

	static void makeSet(int n) {
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int v1) {
		if(v1==parents[v1]) return parents[v1];
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
