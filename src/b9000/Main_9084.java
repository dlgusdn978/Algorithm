package b9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9084 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int count = Integer.parseInt(br.readLine());
		for(int c=0; c<count; c++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<arr.length;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int total = Integer.parseInt(br.readLine());
			
			int[] dp = new int[total+1];
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=total; j++) {
					if(j==arr[i]) dp[j] += 1;
					else if(j>arr[i]) dp[j] += dp[j-arr[i]];
				}
			}
			
			System.out.println(dp[total]);
		}
		
		
	}

}
