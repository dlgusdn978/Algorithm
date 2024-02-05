package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1135 {

	static List<Integer>[] list;
	static int max = Integer.MIN_VALUE;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// ���� ���� ��� ��ȣ?
		int last = arr[arr.length-1];
		
		list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<n; i++) {
			if(arr[i]==-1)continue;
			list[arr[i]].add(i);
		}
		dp = new int[n];
		// �� ��庰 ���� ����. �ڽ� ����� ������ ���� ������� ����
		for(int i=0; i<=n; i++) {
			Collections.sort(list[i],new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return list[o2].size()-list[o1].size();
				}
				
			});
		}
		// ���� �������� �Ÿ� + ���� ��� �ڽ� ����� ����
		int max = dfs(0);
		System.out.println(max);
	}

	static int dfs(int n) {
		int count = 0;
		int max = 0;
		Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
		
		for(Integer next : list[n]) {
			dp[next] = dfs(next);
			q.add(new int[] {next, dp[next]});
		}
		while(!q.isEmpty()) {
			int[] node = q.poll();
			count++;
			max = Math.max(max, node[1]+count);
		}
		return max;
	}
}
