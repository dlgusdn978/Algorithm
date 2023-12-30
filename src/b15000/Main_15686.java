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
		
		// list에 집의 정보를 저장하고
		// 조합을 돌려서 치킨집을 선택하고 true 처리함.
		
		// 이중 for 문 돌려서 2 && true 찾고, bfs 시작.
		
		arr = new int[n][n];
		chicken = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) chicken.add(new Node(i, j, 0));
			}
		}
		
		// chicken 집 선택(방문체크) 할 배열
		visit = new boolean[chicken.size()];
		
		// 조합 만들기
		makeCombination(0, 0);
		
		System.out.println(min);
	}
	
	static void makeCombination(int next, int count) {
		if(count == m) {
			// 치킨 집 선택했으니 bfs 탐색 시작.
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
		//visit을 통해, 선택한 치킨 집 위치 가져오기
		for(int i=0; i<visit.length; i++) {
			if(visit[i]) {
				Node cur = chicken.get(i);
				q.add(new Node(cur.r, cur.c, 0));
			}
		}
		// 제대로 치킨집 수 골랐나
//		System.out.println(q.size());
		
		// 최솟값 비교를 위한 변수
		int temp = 0;
		
		// 탐색 시작
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			// 사방 탐색
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<n && !route[nr][nc]) {
					// 그냥 길이라면
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
