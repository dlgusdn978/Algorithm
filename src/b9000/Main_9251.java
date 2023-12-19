package b9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = new String[2];
		
		for(int i=0; i<2; i++) {
			arr[i] = br.readLine();
		}
		int[][] sub = new int[arr[0].length()+1][arr[1].length()+1];
		
		for(int i=1; i<=arr[0].length(); i++) {
			for(int j=1; j<=arr[1].length(); j++) {
				if(arr[0].charAt(i-1)==arr[1].charAt(j-1)) sub[i][j] = sub[i-1][j-1] + 1;
				else sub[i][j] = sub[i-1][j] > sub[i][j-1] ? sub[i-1][j] : sub[i][j-1];
			}
		}
		System.out.println(sub[arr[0].length()][arr[1].length()]);
	}

}
