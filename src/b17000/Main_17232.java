package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17232 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 행렬
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 시간
		int t = Integer.parseInt(st.nextToken());
		// 반경
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		char[][] ch = new char[n][m];
		for(int i=0; i<n; i++) {
			ch[i] = br.readLine().toCharArray();
		}
		// 1. 매 시간 매 좌표에서 상황 판별
		// 300*100*100*10000
//		for(int i=0; i<t; i++) {
//			boolean[][] visited = new boolean[n][m];
//			for(int j=0; j<n; j++) {
//				for(int l=0; l<m; l++) {
//					int aroundLife = getAroundLife(ch, j, l, k);
//					if(ch[j][l]=='.') {
//						if(a<aroundLife && aroundLife<=b) visited[j][l] = true;
//					}else {
//						if(a<=aroundLife && aroundLife<=b) visited[j][l] = true;
//					}
//				}
//			}
//			afterSecond(visited, ch);
//		}
//		print(ch);
//		=> 시간 초과
		// 2. 미리 주변 생명의 개수를 구하고, 존재 여부가 바뀔 때만 
	}
	static void print(char[][] ch) {
		for(char[] c : ch) {
			for(char d : c) {
				System.out.print(d);
			}
			System.out.println();
		}
	}
	static void afterSecond(boolean[][] visited, char[][] ch) {
		for(int i=0; i<visited.length; i++) {
			for(int j=0; j<visited[i].length; j++) {
				if(visited[i][j]) ch[i][j] = '*';
				else ch[i][j] = '.';
			}
		}
	}
	static int getAroundLife(char[][] ch, int r, int c, int k) {
		int r1 = r-k<0 ? 0 : r-k;
		int c1 = c-k<0 ? 0 : c-k;
		int r2 = r+k>=ch.length ? ch.length-1 : r+k;
		int c2 = c+k>=ch[0].length ? ch[0].length-1 : c+k;

		int cnt = 0;
		for(int i=r1; i<=r2; i++) {
			for(int j=c1; j<=c2; j++) {
				if(i==r && c==j) continue;
				if(ch[i][j]=='*') cnt++;
			}
		}

		return cnt;
	}
}
