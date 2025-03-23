package b1000;

import java.util.Scanner;

public class Main_1347 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String str = sc.next();
		
		// 50x50 행렬을 순회하며 위치 찾기.
		// 현재 위치에서 순서대로 이동이 가능하다면 true
		// 이탈한다면 false
		// true 가 한번이라도 나올 때까지 수행.
		// 최대 x축, y축, 최소 x축, y 축 구하기.
		boolean[][] visited = new boolean[50][50];
		boolean res = false;
		for(int i=0; i<50; i++) {
			if(res) break;
			for(int j=0; j<50; j++) {
				res = checker(visited, i, j, str);
				if(res) break;
			}
		}
		int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE};
		int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE};
		
		for(int i=0; i<50; i++) {
			for(int j=0; j<50; j++) {
				if(!visited[i][j]) continue;
				min[0] = Math.min(min[0], i);
				min[1] = Math.min(min[1], j);
				max[0] = Math.max(max[0], i);
				max[1] = Math.max(max[1], j);
			}
		}

		for(int i=min[0]; i<=max[0]; i++) {
			for(int j=min[1]; j<=max[1]; j++) {
				if(visited[i][j]) System.out.print(".");
				else System.out.print("#");
			}
			System.out.println();
		}
	}

	static boolean checker(boolean[][] visited, int r, int c, String str) {
		int dir = 1;
		boolean[][] temp = new boolean[50][50];
		temp[r][c] = true;
		boolean flag = true;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='R') dir = (dir+1)%4;
			else if(str.charAt(i)=='L') dir = dir==0 ? 3 : dir-1;
			else if(str.charAt(i)=='F'){
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(nr>=0 && nr<temp.length && nc>=0 && nc<temp[0].length) {
					temp[nr][nc] = true;
					r = nr;
					c = nc;
				}else {
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			for(int i=0; i<50; i++) {
				for(int j=0; j<50; j++) {
					visited[i][j] = temp[i][j];
				}
			}
		}
		
		return flag;
	}
}
