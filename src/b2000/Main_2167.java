package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2167 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int oper = Integer.parseInt(br.readLine());
		for(int i=0; i<oper; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int res = operate(arr, x1-1, y1-1, x2-1, y2-1);
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());

	}

	static int operate(int[][] arr, int x1, int y1, int x2, int y2) {
		int num = 0;
		for(int i=x1; i<=x2; i++) {
			for(int j=y1; j<=y2; j++) {
				num += arr[i][j];
			}
		}
		return num;
	}
}
