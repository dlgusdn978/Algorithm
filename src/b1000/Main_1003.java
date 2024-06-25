
package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_1003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[2][41];
		arr[0][0] = 1;
		arr[1][1] = 1;
		//  0  1  1  2  3  5  8  13  21  ...
		//  1  0  0  1  1  2  3
		//  0  1  1  2  3  5  8
		
		for(int i=2; i<=40; i++) {
			arr[0][i] = arr[0][i-1]+arr[0][i-2];
			arr[1][i] = arr[1][i-1]+arr[1][i-2];
		}
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(arr[0][num]+" "+arr[1][num]).append("\n");
		}
		System.out.println(sb.toString());

	}

	
	
	// 0 1 1 2 3 5 8 13 21 ....
	
}
