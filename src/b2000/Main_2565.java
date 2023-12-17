package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2565 {

	static class Node{
		int start;
		int end;
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		List<Node> list = new ArrayList<>();
		int[] dp = new int[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Node(start, end));
		}
		
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
	
		for(int i=0; i<dp.length; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(list.get(i).end>list.get(j).end) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(n-dp[dp.length-1]);
		
	}

}
