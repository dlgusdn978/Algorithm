package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1022 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		int[][] res = new int[r2-r1+1][c2-c1+1];
		int max = 0;
		
		for(int i=r1; i<=r2; i++) {
			for(int j=c1; j<=c2; j++) {
				res[i-r1][j-c1] =  getSpiralNumber(i, j);
				max = Math.max(max, String.valueOf(res[i-r1][j-c1]).length());
			}
		}

		for(int i=0; i<=r2-r1; i++) {
			for(int j=0; j<=c2-c1; j++) {
				System.out.print(String.format("%"+max+"s", String.valueOf(res[i][j]))+" ");
			}
			System.out.println();
		}
	}
	// 행 값 중에서 절댓값 치고 가장 큰 값 기준으로 로테 ㄱ
	
	static int getSpiralNumber(int r, int c) {
		int layer = Math.max(Math.abs(r), Math.abs(c));
		int min = (int) Math.pow(2*layer-1, 2)+1;
		
		if(r==layer) return min + 7*layer -1 +c;
		if(c==-layer) return min + 5*layer -1 +r;
		if(r==-layer) return min + 3*layer -1 -c;
		return min + layer -1 -r;
	}
}
