package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20365 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		
		int b = 0;
		int r = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='B') b++;
			else r++;
		}

		char[] arr2 = new char[n+1];
		for(int i=1; i<=n; i++) {
			arr2[i] = arr[i-1];
		}
		
		// blue
		arr2[0] = 'B';
		int count = 1;
		for(int i=1; i<=n; i++) {
			if(arr2[i]=='R' && arr2[i-1]!=arr2[i]) {
				count++;
			}
		}
		arr2[0] = 'R';
		int count2 = 1;
		for(int i=1; i<=n; i++) {
			if(arr2[i]=='B' && arr2[i-1]!=arr2[i]) {
				count2++;
			}
		}
//		System.out.println(count+" "+count2);
		System.out.println(Math.min(count, count2));
		// red
		
	}

}
