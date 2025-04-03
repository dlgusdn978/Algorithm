package b3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190 {

	static class Dir{
		int cnt;
		char ch;
		public Dir(int cnt, char ch) {
			this.cnt = cnt;
			this.ch = ch;
		}
	}
	static class Node{
		int r;
		int c;
		int dir;
		public Node(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int appleCnt = Integer.parseInt(br.readLine());
		boolean[][] containsApple = new boolean[n][n];
		boolean[][] containsSnake = new boolean[n][n];
		// 사과의 위치에 대한 정보 저장
		for(int i=0; i<appleCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			containsApple[r][c] = true;
		}
		// 위치 변경에 대한 정보 저장
		Queue<Dir> dirQueue = new ArrayDeque<>();
		int dirCnt = Integer.parseInt(br.readLine());
		for(int i=0; i<dirCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			char ch = st.nextToken().charAt(0);
			
			dirQueue.add(new Dir(cnt, ch));
		}
		int time = move(containsApple, containsSnake, dirQueue);
		System.out.println(time);
	
	}
	
	
	
	// -> 현재 위치에 사과가 있으면 유지, 없으면 queue에서 하나 제거(queue의 size가 2 이상인 경우)
	// -> 현재 위치에 사과가 있으면 사과 정보 갱신
	
	
	static int move(boolean[][] containsApple, boolean[][] containsSnake, Queue<Dir> dirQueue) {
		Deque<Node> q = new ArrayDeque<>();
		q.add(new Node(0, 0, 0));
		containsSnake[0][0] = true;
		int cnt = 1;
		// while문에서 int cnt 값을 늘려가며 반복 수행
		while(true) {
			Node cur = q.peekFirst();
			int nr = cur.r+dr[cur.dir];
			int nc = cur.c+dc[cur.dir];
			int dir = cur.dir;
			// 현재 위치가 범위를 벗어나면 종료.
			if(nr<0 || nr>=containsApple.length || nc<0 || nc>=containsApple[0].length || containsSnake[nr][nc]) break;
			
			if(!dirQueue.isEmpty() && dirQueue.peek().cnt==cnt) {
				// -> cnt 값과 위치 정보의 시간을 비교하며 수행
				Dir curDir = dirQueue.poll();
				dir = curDir.ch=='L' ? (dir-1<0 ? 3 : dir-1) : ((dir+1)%4);
			}
			// 뱀이 차지하고 있는 위치에 대한 정보는 queue에 저장.
			q.addFirst(new Node(nr, nc, dir));
			containsSnake[nr][nc] = true;
			// -> 현재 위치에 사과가 있으면 사과 정보 갱신
			if(containsApple[nr][nc]) containsApple[nr][nc] = false;
			else if(q.size()>1) {
				Node tail = q.pollLast();
				containsSnake[tail.r][tail.c] = false;
			}
			cnt++;
		}
		return cnt;
	}
	
	
	

}
