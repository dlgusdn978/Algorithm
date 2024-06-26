package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1117 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 너비
		int w = Integer.parseInt(st.nextToken());
		// 높이
		int h = Integer.parseInt(st.nextToken());
		// 접는 위치
		int f = Integer.parseInt(st.nextToken());
		// 세로 접는 횟수
		int c = Integer.parseInt(st.nextToken());

		// 좌표값
		int[][] cor = new int[2][2];
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				cor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// f 값이 r/2보다 크다면 f=r-f
		if(f>w/2) f = w-f;
		// 각 좌표에 1 채움.
//		int[][] arr = new int[h][w];
//		for(int i=0; i<h; i++) {
//			Arrays.fill(arr[i], 1);
//		}
		// (1,1) ~ (2,3)
		long area = w*h;
		long colored = 0;

		colored += (cor[1][0]-cor[0][0])*(cor[1][1]-cor[0][1])*(c+1);
		if(f<=cor[0][0]) {
			colored = area-colored;
		}else {
			colored = area - (colored+(Math.min(f, cor[1][0])-cor[0][0])*(cor[1][1]-cor[0][1])*(c+1));
		}
		System.out.println(colored);

	}

	
}
