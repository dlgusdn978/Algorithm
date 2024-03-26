package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1766 {

	static class Node{
		int first;
		int last;
		public Node(int first, int last) {
			this.first = first;
			this.last = last;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 문제의 수 n
		int n = Integer.parseInt(st.nextToken());
		// 먼저 푸는 - m
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		
		List<Integer>[] list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			arr[b]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=1; i<=n; i++) {
			if(arr[i]==0) {
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur+" ");
			for(int next : list[cur]) {
				arr[next]--;
				
				if(arr[next]==0) pq.offer(next);
			}
		}
		
		System.out.println(sb.toString());
	}

}
