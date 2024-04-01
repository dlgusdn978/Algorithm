package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1939 {

	static int n, m;
	static int[] parents;
	static class Island{
		int from;
		int to;
		int weight;
		public Island(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	static List<Island> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 섬의 수 n
		n = Integer.parseInt(st.nextToken());
		// 섬 연결 다리의 수 m
		m = Integer.parseInt(st.nextToken());
	
		// 섬의 정보를 넣을 list
		list = new ArrayList<>();

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Island(from, to, weight));
		}
		
		Collections.sort(list, new Comparator<Island>() {
			@Override
			public int compare(Island o1, Island o2) {
				return o2.weight-o1.weight;
			}
		});

		makeSet();
		int count = 0;
		List<Island>[] res = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			res[i] = new ArrayList<>();
		}
		
		for(Island a : list) {
			if(union(a.from, a.to)) {
				res[a.from].add(new Island(0, a.to, a.weight));
				res[a.to].add(new Island(0, a.from, a.weight));
				if(++count==n-1) break;
			}
		}


		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		
		int end = Integer.parseInt(st.nextToken());
		
		boolean[] visit = new boolean[n+1];

		Queue<Island> q = new ArrayDeque<>();
		for(int i=0; i<res[start].size(); i++) {
			q.add(res[start].get(i));
		}
		
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Island cur = q.poll();
			
			for(Island next : res[cur.to]) {
				if(visit[next.to]) continue;
				q.add(new Island(0, next.to, Math.min(cur.weight, next.weight)));
				visit[next.to] = true;
				if(next.to==end) min = Math.min(cur.weight, next.weight);
			}
		}
		System.out.println(min);
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

