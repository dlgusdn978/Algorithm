package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2668 {

	static int n;
	static int[] arr;
	static boolean[] visit;
	static int cur;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		
		arr = new int[n+1];
		visit = new boolean[n+1];
		list = new ArrayList<Integer>();
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=1; i<=n; i++){
			visit[i] = true;
			dfs(i, i);
			visit[i] = false;
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int a : list) {
			System.out.println(a);
		}
	}
	
	static void dfs(int index, int next) {
		if(!visit[arr[index]]) {
			visit[arr[index]]=true;
			dfs(arr[index], next);
			visit[arr[index]]=false;
		}
		if(arr[index]==next) {
			list.add(next);
		}
	}
}
