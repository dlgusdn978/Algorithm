package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int[] arr = new int[6];
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			arr[2*i] = Integer.parseInt(st.nextToken());
			arr[2*i+1] = Integer.parseInt(st.nextToken());
		}
		// x2-x1, y2-y1
		// x3-x2, y3-y2
		CCW(arr);
	}

	static void CCW(int[] arr) {
		int val = (arr[2]-arr[0])*(arr[5]-arr[3]) - (arr[4]-arr[2])*(arr[3]-arr[1]);
		if(val<0) {
			System.out.println(-1);
		}else if(val>0) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
}
