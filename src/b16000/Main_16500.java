package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main_16500 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<String>();

		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		int[] dp = new int[str.length()];
		for(int i=str.length()-1; i>=0; i--) {
			for(int j=i+1; j<str.length(); j++) {
				if(dp[j]==1) {
					if(set.contains(str.substring(i, j))) {
						dp[i] = 1;
					}
				}
			}
			if(set.contains(str.substring(i))) {
				dp[i] = 1;
			}
		}
		System.out.println(dp[0]);
	}
	

}
