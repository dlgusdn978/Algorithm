package b15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15671 {

	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 현재 좌표에 돌을 두었을 때 
		// 8 방향 중 같은 색의 돌이 있는지 확인해야 함.
		// 찾은 방향은 같은 색이 돌이 나올 때까지 색상 갱신
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 오델로 판
		char[][] arr = new char[6][6];
		// 초기 세팅
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if((i==2&&j==2)||(i==3&&j==3)) arr[i][j] = 'W';
				else if((i==3&&j==2)||(i==2&&j==3)) arr[i][j] = 'B';
				else arr[i][j]='.';
			}
		}
		// 턴 수
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			arr[r][c] = i%2==0 ? 'B' : 'W';
			setBlock(arr, r, c, arr[r][c]);
		}
		print(arr);
		System.out.println(getWinner(arr));
	}
	static String getWinner(char[][] arr) {
		int wCnt = 0;
		int bCnt = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j]=='B') bCnt++;
				else if(arr[i][j]=='W') wCnt++;
			}
		}
		if(bCnt<wCnt) return "White";
		else return "Black";
	}
	static void setBlock(char[][] arr, int r, int c, char color) {
		boolean[] visited = new boolean[8];
		for(int i=0; i<8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			while(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length) {
				if(arr[nr][nc]=='.') {
					break;
				}else if(arr[nr][nc]==color) {
					visited[i] = true;
					break;
				}else {
					nr+=dr[i];
					nc+=dc[i];
				}
			}
		}
		for(int i=0; i<8; i++) {
			if(!visited[i]) continue;
			int nr = r+dr[i];
			int nc = c+dc[i];
			while(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length) {
				if(arr[nr][nc]!=color && arr[nr][nc]!='.') arr[nr][nc] = color;
				else break;
				nr += dr[i];
				nc += dc[i];
			}
		}
	}
	static void print(char[][] arr) {
		for(char[] a : arr) {
			for(char b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}
}
