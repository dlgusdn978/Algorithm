package b19000;

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

public class Main_19238 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1 ,0};
	static class Node{
		int r;
		int c;
		int cnt;
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static class Edge{
		int r1, c1, r2, c2;
		public Edge(int r1, int c1, int r2, int c2) {
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
		}
	}
	public static void main(String[] args) throws IOException {
		// 손님을 도착지로 데려다줄 때 연료 충전. 이동하면서 소모한 양의 2배 충전. 연료 0 -> 끝
		// 현재 위치에서 최단거리가 가장 짧은 승객 선택. 여러명이면 행, 열 번호가 가장 작은 승객
		// 풀이 1. bfs 활용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 도로 정보
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 운전 시작하는 칸
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		
		Node taxi = new Node(r, c, k);
		List<Edge> edge = new ArrayList<>();
		// 출발, 도착지 정보
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			edge.add(new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1));

		}
		Collections.sort(edge, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.r1 == o2.r1 ? o1.c1-o2.c1 : o1.r1-o2.r1;
			}
		});
//		System.out.println(getDistance(arr, taxi, new Node(1, 1, 0)));
		while(!edge.isEmpty()) {
			// 픽업까지의 거리
			int minDist = Integer.MAX_VALUE;
			int idx = 0;
			for(int i=0; i<edge.size(); i++) {
				int dist = getDistance(arr, taxi, new Node(edge.get(i).r1, edge.get(i).c1, 0));
				if(dist<minDist) {
					minDist = dist;
					idx = i;
				}
			}
			// 목적지까지 거리
			int destDist = getDistance(arr, new Node(edge.get(idx).r1, edge.get(idx).c1, 0), new Node(edge.get(idx).r2, edge.get(idx).c2, 0));
			if(minDist==-1 || destDist==-1 || minDist+destDist>taxi.cnt) {
				System.out.println(-1);
				return;
			}
//			System.out.println(taxi.cnt+" "+minDist+" "+destDist);
			taxi = new Node(edge.get(idx).r2, edge.get(idx).c2, taxi.cnt-minDist+destDist);
			edge.remove(idx);

//			System.out.println(taxi.cnt);
		}
		System.out.println(taxi.cnt);
		
	}
	
	static int getDistance(int[][] arr, Node taxi, Node dest) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(taxi.r, taxi.c, 0));
		boolean[][] visited = new boolean[arr.length][arr.length];
		visited[taxi.r][taxi.c] = true;
		
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Node cur = q.poll();
//			System.out.println(cur.r+" "+cur.c);
			if(cur.r==dest.r && cur.c==dest.c) {
				min = cur.cnt;
				break;
			}
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr>=0 && nr<arr.length && nc>=0 && nc<arr.length && arr[nr][nc]==0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc, cur.cnt+1));
				}
			}
		}
		
		
		return min == Integer.MAX_VALUE ? -1 : min;
	}
	static void setFuel() {
		
	}
	
}
