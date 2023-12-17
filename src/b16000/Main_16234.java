package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {

	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[][] arr;
	static boolean[][] visit;
	static int[][] country;
	static int n, L, R;
	static int day;
	static int union;
	static List<Integer> list;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 구현 방식.
		// 1. (0,0) 모든 배열 요소를 사방 탐색
		// 2. 현재 요소와 다음 요소간의 차이가 L이상 R이하라면 방문체크
		// 3. visit[i][j] = true 인 요소들 의 개수와 합을 구하고, 이를 나누어 몫을 구함.
		// 3-1. true인 요소의 개수가 1이라면 return 후 결과 값 출력.
		// 4. visit[i][j] = true 인 요소들의 값을 몫으로 변경하고, false로 변경.
		// 5. day += 1; 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 격자 크기 n
		n = Integer.parseInt(st.nextToken());
		// 최소 인원 차이 l
		L = Integer.parseInt(st.nextToken());
		// 최대 인원 차이 r
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		visit = new boolean[n][n];
		country = new int[n][n];
		list = new ArrayList<Integer>();
		// 각 나라별 인구 수 배열
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visit[i][j]) bfs(i, j);
				}
			}
			if(!check()) break;
			composite();
			initialize();
		}
		
		System.out.println(day);
	}
	// bfs 순회
	static void bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(r, c));
		union++;
		
		int total = 0;
		int count = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			total+=arr[cur.r][cur.c];
			count++;
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<n && !visit[nr][nc] && Math.abs(arr[cur.r][cur.c]-arr[nr][nc])>=L && Math.abs(arr[cur.r][cur.c]-arr[nr][nc])<=R) {
					q.add(new Node(nr, nc));
					country[cur.r][cur.c] = union;
					country[nr][nc] = union;
					visit[nr][nc] = true;
					visit[cur.r][cur.c] = true;
				}
			}
		}
		if(count==1) {
			union--;
			return;
		}
		else list.add(total/count);
	}
	// 연합 국가끼리 인구 수 분배
	static void composite() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++){
				if(country[i][j]!=0) {
					arr[i][j] = list.get(country[i][j]-1);
				}
			}
		}
		day++;

		
	}
	// 연합이 있는지 체크
	static boolean check() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visit[i][j]) return true;
			}
		}
		return false;
	}
	// 초기화
	static void initialize() {
		union = 0;
		list.clear();
		visit = new boolean[n][n];
		country = new int[n][n];
	}
}
