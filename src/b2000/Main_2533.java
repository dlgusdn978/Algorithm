package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2533 {

	static int n;
	static List<Integer>[] list;
	static boolean[] visit;
	static boolean[] adapter;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 노드 연결은 양방향으로 구성
		// 루트 노드에서 리프 노드까지 탐색
		// return 할 때 자신을 둘러싸고 있는 모든 노드가 얼리어답터라면 본인은 얼리 어답터가 아니어도 됨.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		adapter = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		dfs(1);
		System.out.println(Arrays.toString(adapter));
//		System.out.println(Arrays.toString(visit));
		int count = 0;
		for(boolean a : adapter) {
			if(a) count++;
		}
		System.out.println(count);
	}

	static void dfs(int u) {
		// 자식 노드 순회하면서 리프노드까지 쭉 ㄱ
//		System.out.println(u);
		visit[u] = true;
		adapter[u] = true;
		for(int i=0; i<list[u].size(); i++) {
			int next = list[u].get(i);
			if(visit[next]) continue;
			visit[next] = true;
			
			dfs(next);
		}
		boolean flag = true;
		for(int i=0; i<list[u].size(); i++) {
			int next = list[u].get(i);
			if(!adapter[next]) flag = false;
		}
		if(flag) adapter[u] = false;
	}
}
