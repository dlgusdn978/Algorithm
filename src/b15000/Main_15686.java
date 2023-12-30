package b15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15686 {

	static int n, m;
	static int min = Integer.MAX_VALUE;
	static int[][] arr;
	static List<Node> chicken;
	static boolean[][] route;
	static boolean[] visit;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static class Node{
		int r;
		int c;
		int count;
		public Node(int r, int c, int count) {
			this.r =  r;
			this.c = c;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// list�� ���� ������ �����ϰ�
		// ������ ������ ġŲ���� �����ϰ� true ó����.
		
		// ���� for �� ������ 2 && true ã��, bfs ����.
		
		arr = new int[n][n];
		chicken = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) chicken.add(new Node(i, j, 0));
			}
		}
		
		// chicken �� ����(�湮üũ) �� �迭
		visit = new boolean[chicken.size()];
		
		// ���� �����
		makeCombination(0, 0);
		
		System.out.println(min);
	}
	
	static void makeCombination(int next, int count) {
		if(count == m) {
			// ġŲ �� ���������� bfs Ž�� ����.
			bfs();
			return;
		}
		for(int i=next; i<chicken.size(); i++) {
			if(visit[i]) continue;
			visit[i] = true;
			makeCombination(i+1, count+1);
			visit[i] = false;
		}
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		route = new boolean[n][n];
//		for(Node list : chicken) {
//			System.out.println(list.r+" "+list.c);
//		}
//		System.out.println(Arrays.toString(visit));
		//visit�� ����, ������ ġŲ �� ��ġ ��������
		for(int i=0; i<visit.length; i++) {
			if(visit[i]) {
				Node cur = chicken.get(i);
				q.add(new Node(cur.r, cur.c, 0));
			}
		}
		// ����� ġŲ�� �� �����
//		System.out.println(q.size());
		
		// �ּڰ� �񱳸� ���� ����
		int temp = 0;
		
		// Ž�� ����
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			// ��� Ž��
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<n && !route[nr][nc]) {
					// �׳� ���̶��
					if(arr[nr][nc]==1) {
						temp += cur.count+1;
					}
					route[nr][nc] = true;
					q.add(new Node(nr, nc, cur.count+1));
				}
			}
		}
//		System.out.println(temp);
		if(temp==0) return;
		min = Math.min(temp, min);
	}
	

}
