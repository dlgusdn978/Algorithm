package b12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12015 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		dp[count++] = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(dp[count-1]<arr[i]) {
				dp[count++] = arr[i];
			}else {
				int start = 0;
				int end = count-1;
				while(start<=end) {
					int mid = (start+end)/2;

					if(dp[mid]<arr[i]) {
						start = mid+1;
					}else {
						end = mid-1;
					}
					
				}
				dp[start] = arr[i];
				
			}
		}
		System.out.println(count);
//		System.out.println(Arrays.toString(dp));
	}
}
