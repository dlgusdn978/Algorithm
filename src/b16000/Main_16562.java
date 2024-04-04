package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_16562 {

	static int n, m, k;
	static int[] parents;
	static int[] cost;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 학생 수 n
		n = Integer.parseInt(st.nextToken());
		// 친구 관계 수 m
		m = Integer.parseInt(st.nextToken());
		// 가지고 있는 돈
		k = Integer.parseInt(st.nextToken());
		
		cost = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		// 학생별 친구비
		for(int i=1; i<=n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		makeSet();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			union(friend1, friend2);
		}

		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=1; i<=n; i++) {
			// 학생 수 순회하면서
			// 같은 집단이라면 같은 집단 중 비용이 가장 작은 학생을 map에 넣고
			// 같은 집단이 아니라면 map 에 추가.
			int parent = findSet(i);
			if(map.containsKey(parent)) {
				map.put(parent, Math.min(map.get(parent), cost[i]));
			}else {
				map.put(parent, cost[i]);
			}
		}
		List<Entry<Integer, Integer>> mapList = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		int total = 0;
		boolean flag = true;
		for(Entry<Integer, Integer> a : mapList) {
			total += a.getValue();
			if(total>k) {
				flag = false;
				break;
			}
		}
		if(flag) System.out.println(total);
		else System.out.println("Oh no");
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
