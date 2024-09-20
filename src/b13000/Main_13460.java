package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sql.rowset.spi.SyncProvider;

public class Main_13460 {

	static class Node{
		int redR;
		int redC;
		int blueR;
		int blueC;
		int moveCnt;
		public Node(int redR, int redC, int blueR, int blueC, int moveCnt) {
			this.redR = redR;
			this.redC = redC;
			this.blueR = blueR;
			this.blueC = blueC;
			this.moveCnt = moveCnt;
		}
	}
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[n][m];
		Node state = null;
		int redR = 0, redC = 0, blueR = 0, blueC = 0, goalR = 0, goalC = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]=='O') {
					goalR = i;
					goalC = j;
				}
				else if(arr[i][j]=='R') {
					redR = i;
					redC = j;
				}
				else if(arr[i][j]=='B') {
					blueR = i;
					blueC = j;
				}
			}
		}

		state = new Node(redR, redC, blueR, blueC, 0);
		bfs(arr, state, goalR, goalC);
		
	}
	
	static void bfs(char[][] arr, Node state, int goalR, int goalC) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(state);
		
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.moveCnt>min) continue;
//			System.out.println(cur.moveCnt);
			for(int i=0; i<4; i++) {
				Node next = null;
				if(isFindBlueOrb(arr, cur, i)) {
					next = moveOrb(arr, cur, i, true);
				}else {
					// red 움직인 후 blue 움직이기
					next = moveOrb(arr, cur, i, false);
				}
				if(next.moveCnt>10) {
					continue;
				}else if(next.blueR==goalR && next.blueC==goalC) {
					continue;
				}else if(next.redR==goalR && next.redC==goalC) {
//					System.out.println(next.redR+" "+next.redC+" "+next.blueR+" "+next.blueC+" "+goalR+""+goalC);
					min = Math.min(min, next.moveCnt);
				}else {
					q.add(next);
				}
			}
		}
		if(min!=Integer.MAX_VALUE) System.out.println(min);
		else System.out.println(-1);
	}
	static Node moveOrb(char[][] arr, Node state, int dir, boolean isBlueOrbFirst) {
		int redR = state.redR;
		int redC = state.redC;
		int blueR = state.blueR;
		int blueC = state.blueC;
		if(isBlueOrbFirst) {
			while(true) {
				int nr = blueR+dr[dir];
				int nc = blueC+dc[dir];
				if(arr[nr][nc]=='#') break;
				else if(arr[nr][nc]=='O') {
					blueR = nr;
					blueC = nc;
					break;
				}
				blueR = nr;
				blueC = nc;
			}
			while(true) {
				int nr = redR+dr[dir];
				int nc = redC+dc[dir];
				if(arr[nr][nc]=='O') {
					redR = nr;
					redC = nc;
					break;
				}
				else if(arr[nr][nc]=='#' || (nr==blueR && nc==blueC)) {
					break;
				}
				redR = nr;
				redC = nc;
			}
		}else {
			while(true) {
				int nr = redR+dr[dir];
				int nc = redC+dc[dir];
				if(arr[nr][nc]=='#') break;
				else if(arr[nr][nc]=='O') {
					redR = nr;
					redC = nc;
					break;
				}
				redR = nr;
				redC = nc;
			}
			while(true) {
				int nr = blueR+dr[dir];
				int nc = blueC+dc[dir];
				if(arr[nr][nc]=='O') {
					blueR = nr;
					blueC = nc;
					break;
				}
				else if(arr[nr][nc]=='#' || (redR==nr && redC==nc)) {
					break;
				}
				blueR = nr;
				blueC = nc;
			}
		}
//		System.out.println(redR+" "+redC+" "+blueR+" "+blueC);
		return new Node(redR, redC, blueR, blueC, state.moveCnt+1);
	}
	static boolean isFindBlueOrb(char[][] arr, Node state, int dir) {
		boolean flag = false;
		int redR = state.redR;
		int redC = state.redC;
		while(true) {
			int nr = redR+dr[dir];
			int nc = redC+dc[dir];
			if(arr[nr][nc]=='#') break;
			else if(nr==state.blueR&&nc==state.blueC) {
				flag = true;
				break;
			}
			redR = nr;
			redC = nc;
		}
		return flag;
	}
}
