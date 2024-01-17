package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1068 {

	static List<Integer>[] list;
	static int count;
	static int parent;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num!=-1) list[num].add(i);
			else parent = i;
		}
		
		int init = Integer.parseInt(br.readLine());
		visit[init] = true;
		
		dfs(parent);
		System.out.println(count);
	}

	static void dfs(int n) {
		if(visit[n]) return;
		boolean flag = true;
		for(int i=0; i<list[n].size(); i++) {
			if(visit[list[n].get(i)] && list[n].size()==1) flag = false;
		}
		if(list[n].isEmpty()||!flag) {
			count++;
			return;
		}
		for(int i=0; i<list[n].size();i++) {
			dfs(list[n].get(i));
		}
	}

}
