package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11054 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		int n = Integer.parseInt(br.readLine());	
		
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		Arrays.fill(dp, 1);
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<i; j++) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		int[] dp2 = new int[n+1];
		Arrays.fill(dp2, 1);
		for(int i=n; i>0; i--) {
			for(int j=n; j>i; j--) {
				if(arr[j]<arr[i]) {
					dp2[i] = Math.max(dp2[j]+1, dp2[i]);
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(dp2));
		
		int max = 0;
		for(int i=1; i<=n; i++) {
			int temp = dp[i]+dp2[i];
			if(max<temp) max = temp;
		}
		System.out.println(max-1);
		
		
		
	}

}
