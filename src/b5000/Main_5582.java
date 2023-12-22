package b5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5582 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		int[][] arr = new int[s.length()+1][t.length()+1];
		
		int temp = 0;
		for(int i=1; i<=s.length(); i++) {
			for(int j=1; j<=t.length(); j++) {
				if(s.charAt(i-1)==t.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1]+1;
					if(arr[i][j]>temp) temp = arr[i][j];
				}
			}
		}
//		for(int[] a : arr) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		System.out.println(temp);
	}

}
