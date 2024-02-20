package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {

	static long left, mid, right;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, n);
		System.out.println(left);
		System.out.println(mid);
		System.out.println(right);
	}

	static void divide(int r, int c, int size) {
		if(size==1) {
			if(arr[r][c]==-1) left++;
			else if(arr[r][c]==0) mid++;
			else right++;
			return;
		}
		int start = arr[r][c];
		boolean flag = true;
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(arr[i][j] != start) {
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			if(start==-1) left++;
			else if(start==0) mid++;
			else right++;
		}else {
			divide(r, c, size/3);
			divide(r, c+size/3, size/3);
			divide(r, c+size*2/3, size/3);
			divide(r+size/3, c, size/3);
			divide(r+size/3, c+size/3, size/3);
			divide(r+size/3, c+size*2/3, size/3);
			divide(r+size*2/3, c, size/3);
			divide(r+size*2/3, c+size/3, size/3);
			divide(r+size*2/3, c+size*2/3, size/3);
			
		}
		
	}
}
