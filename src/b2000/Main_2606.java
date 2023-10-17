package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2606 {

	// 컴퓨터의 수
	static int n;
	// 직접 연결된 컴퓨터의 수
	static int m;
	
	static boolean[] visit;
	
	static ArrayList[] list;
	
	static int count;
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		m = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list[start].add(end);
			list[end].add(start);
		}
		visit = new boolean[n+1];
		
		visit[1] = true;
		dfs(1);
		System.out.println(count);
	}
	
	static void dfs(int c) {
		
		for(int i=0; i<list[c].size(); i++) {
			if(visit[(int) list[c].get(i)]) continue;
			visit[(int) list[c].get(i)] = true;
			count++;
			dfs((int)list[c].get(i));
		}
	}
}
