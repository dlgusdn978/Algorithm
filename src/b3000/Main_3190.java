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
		// ����� ��ġ�� ���� ���� ����
		for(int i=0; i<appleCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			containsApple[r][c] = true;
		}
		// ��ġ ���濡 ���� ���� ����
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
	
	
	
	// -> ���� ��ġ�� ����� ������ ����, ������ queue���� �ϳ� ����(queue�� size�� 2 �̻��� ���)
	// -> ���� ��ġ�� ����� ������ ��� ���� ����
	
	
	static int move(boolean[][] containsApple, boolean[][] containsSnake, Queue<Dir> dirQueue) {
		Deque<Node> q = new ArrayDeque<>();
		q.add(new Node(0, 0, 0));
		containsSnake[0][0] = true;
		int cnt = 1;
		// while������ int cnt ���� �÷����� �ݺ� ����
		while(true) {
			Node cur = q.peekFirst();
			int nr = cur.r+dr[cur.dir];
			int nc = cur.c+dc[cur.dir];
			int dir = cur.dir;
			// ���� ��ġ�� ������ ����� ����.
			if(nr<0 || nr>=containsApple.length || nc<0 || nc>=containsApple[0].length || containsSnake[nr][nc]) break;
			
			if(!dirQueue.isEmpty() && dirQueue.peek().cnt==cnt) {
				// -> cnt ���� ��ġ ������ �ð��� ���ϸ� ����
				Dir curDir = dirQueue.poll();
				dir = curDir.ch=='L' ? (dir-1<0 ? 3 : dir-1) : ((dir+1)%4);
			}
			// ���� �����ϰ� �ִ� ��ġ�� ���� ������ queue�� ����.
			q.addFirst(new Node(nr, nc, dir));
			containsSnake[nr][nc] = true;
			// -> ���� ��ġ�� ����� ������ ��� ���� ����
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
