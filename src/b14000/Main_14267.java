package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14267 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// list의 index를 가져올 map
		Map<Integer, Integer> map = new HashMap<>();
		List<List<Integer>> list = new ArrayList<>();
		// 직장 상사의 번호를 알고 있어야 함
		int[] hierarchy = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			// i는 직원, num은 상사
			int num = Integer.parseInt(st.nextToken());
			hierarchy[i] = num;
			if(num!=-1 && !map.containsKey(num)) {
				map.put(num, map.size());
			}
		}

		for(int i=0; i<=map.size(); i++) {
			list.add(new ArrayList<>());
		}

		for(int i=2; i<=n; i++) {
			int num = hierarchy[i];
			int index = map.get(num);
			list.get(index).add(i);
		}

		
		int[] dp = new int[n+1];
		// 칭찬
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 직원 번호
			int val = Integer.parseInt(st.nextToken()); // 칭찬 수치
			
			dp[num] += val;
		}
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			if(!map.containsKey(num)) continue;
			int index = map.get(num);
			for(int i=0; i<list.get(index).size(); i++) {
				int next = list.get(index).get(i);
				dp[next] += dp[num];
				q.add(next);

			}
		}
		for(int i=1; i<n+1; i++) {
			sb.append(dp[i]+" ");
		}

		System.out.println(sb.toString());
	}

}
