package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		String t = br.readLine();
		StringBuilder sb = new StringBuilder();
		int[][] arr = new int[s.length()+1][t.length()+1];
		
		for(int i=1; i<=s.length(); i++) {
			for(int j=1; j<=t.length(); j++) {
				if(s.charAt(i-1)==t.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1]+1;
				}else {
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
//		for(int[] a : arr) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		int r = s.length();
		int c = t.length();
		int count = arr[r][c];
		while(arr[r][c]!=0) {
			if(arr[r-1][c]==count-1 && arr[r][c-1]==count-1) {
				sb.append(s.charAt(r-1));
				count--;
				r--;
				c--;
			}else {
				if(arr[r][c-1]<arr[r-1][c]) {
					r--;
				}else {
					c--;
				}
			}
		}
		
		System.out.println(sb.reverse().toString());
	}

}
