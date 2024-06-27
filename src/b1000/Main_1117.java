package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1117 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 너비
		long w = Long.parseLong(st.nextToken());
		// 높이
		long h = Long.parseLong(st.nextToken());
		// 접는 위치
		long f = Long.parseLong(st.nextToken());
		// 세로 접는 횟수
		long c = Long.parseLong(st.nextToken());

		// 좌표값
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());

		// f 값이 r/2보다 크다면 f=r-f
		if(f>w/2) f= w-f;
		// 각 좌표에 1 채움.
//		int[][] arr = new int[h][w];
//		for(int i=0; i<h; i++) {
//			Arrays.fill(arr[i], 1);
//		}
		// (1,1) ~ (2,3)
		long area = w*h;
		long colored = 0;

		if(f<=x1) {
			colored = (x2-x1)*(y2-y1)*(c+1);
		}else if(f<x2) {
			colored = (y2-y1)*(c+1)*( (f-x1)*2+(x2-f) );
		}else {
			colored = (x2-x1)*(y2-y1)*(c+1)*2;
		}
		System.out.println(area-colored);

	}

	
}
