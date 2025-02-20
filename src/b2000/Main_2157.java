package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2157 {

	static class Node{
		int start;
		int end;
		int val;
		int cnt;
		public Node(int start, int end, int val, int cnt) {
			this.start = start;
			this.end = end;
			this.val = val;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		// n���� ���ð� ���ʿ��� �������� ��ġ
		// n, n-1, ... , 2, 1
		// m�� ���� ���ø� ������ ���� 
		// ���� 1. ������ 1, ���� N
		// ���� 2. ���� ��δ� ������ ��θ�
		// ���� 3. ���ִ� �⳻�ĸ� ��� -> max(val)
		
		// ū �ʿ��� ���� ������ ���� �׷δ� ���ֹ�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ������ �� n
		int n = Integer.parseInt(st.nextToken());
		// �湮 ���� �� m
		int m = Integer.parseInt(st.nextToken());
		// ��� �� k
		int k = Integer.parseInt(st.nextToken());
		
		List<List<Node>> list = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		// 1+...+100000 => n(n+1)/2 => O(n^2);
		// ���� �� ���� ������ 1�� ��κ��� Ž�� ����
		// �߰� ���� -> ���⼭ ������ ��θ� ������ �뼱�� ���Ͽ� �� ū ���� �����ϰ� ��� �����ϵ��� ����. ********************
		int[][] arr = new int[n+1][n+1];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			if(start>end) continue;
			arr[start][end] = Math.max(arr[start][end], val);
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i>=j) continue;
				list.get(i).add(new Node(i, j, arr[i][j], 1));
			}
		}
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
		int[] dp = new int[n+1];
		bfs(list, dp, m);
	}

	static void bfs(List<List<Node>> list, int[] dp, int m) {
		Queue<Node> q = new ArrayDeque<>();
		for(int i=0; i<list.get(1).size(); i++) {
			Node cur = list.get(1).get(i);
			q.add(new Node(cur.start, cur.end, cur.val, cur.cnt));
		}
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.cnt>m) continue;
			if(dp[cur.start]+cur.val < dp[cur.end]) continue;
			for(int i=0; i<list.get(cur.end).size(); i++) {
				// dp �� �������ֱ�  <<<
				Node next = list.get(cur.end).get(i);
				q.add(new Node(cur.end, next.end, next.val, cur.cnt+1));
			}
			
		}
	}
	static void print(int[] dp ) {
		for(int a : dp) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
}
