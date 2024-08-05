package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14567 {

	static class Node{
		int pre;
		int cur;
		public Node(int pre, int cur) {
			this.pre = pre;
			this.cur = cur;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 과목 수
		int n = Integer.parseInt(st.nextToken());
		// 선수 과목 수
		int m = Integer.parseInt(st.nextToken());

		
		// 풀이.
		// dfs 만들고 max depth 구하기.
		List<Node> list = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.pre==o2.pre ? o1.cur-o2.cur : o1.pre-o2.pre;
			}
		});
		int[] dp = new int[n+1];
		Arrays.fill(dp, 1);
		
		for(int i=0; i<list.size(); i++) {
			int pre = list.get(i).pre;
			int cur = list.get(i).cur;
			
			// 현재 값 +1 과 이전에 등록한 값 비교.
			dp[cur] = Math.max(dp[pre]+1, dp[cur]);
		}

		for(int i=1; i<dp.length; i++) {
			sb.append(dp[i]+" ");
		}
		System.out.println(sb.toString());
	}

}
