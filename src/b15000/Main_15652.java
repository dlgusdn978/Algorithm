package b15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15652 {

	static int n, m;
	static StringBuilder sb;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		list = new ArrayList<>();
		dfs(1, 0);

		System.out.println(sb.toString());
	}

	static void dfs(int num, int count) {
		if(count==m) {
			for(int a : list) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=num; i<=n; i++) {
			list.add(i);
			dfs(i, count+1);
			list.remove(list.size()-1);
		}
	}
}
