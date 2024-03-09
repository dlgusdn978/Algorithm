package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2140 {
	
	static int n;
	static char[][] arr;
	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 전체 순회 돌리고
		// # 일 때 8방 탐색 수행
		// 모든 방향이 #일 때 count+1 continue;
		// 하나라도 #이 아닐 때 다시 8방 돌리면서 1 이상인지 확인
		// 모든 방향이 1 이상일 때 count + 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		n = Integer.parseInt(br.readLine());
		
		arr = new char[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++){
				if(arr[i][j]=='#') find(i, j);
			}
		}
		
//		for(char[] a : arr) {
//			for(char b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		System.out.println(count);
	}

	static void find(int r, int c) {
		// 주변 영역의 개수
		int countSpace = 0;
		// # 의 개수
		int countSharp = 0;
		// # 이 아닌 수의 크기가 1 이상인가?
		boolean checker = true;
		
		for(int i=0; i<8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<n && nc>=0 && nc<n) {
				countSpace++;
				if(arr[nr][nc]=='#') countSharp++;
				else {
					if(arr[nr][nc]=='0') checker = false; 
				}
			}
		}
		
		if(countSharp==countSpace) {
			count++;
		}else {
			if(checker) {
				change(r, c);
				count++;
			}
		}
	}
	static void change(int r, int c) {
		for(int i=0; i<8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr>=0 && nr<n && nc>=0 && nc<n && arr[nr][nc]!='#') {
				int num = arr[nr][nc]-49;
				arr[nr][nc] = (char) (num+48);
			}
		}
	}
	
}
