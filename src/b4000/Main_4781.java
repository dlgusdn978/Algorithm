package b4000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4781 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		String str = "";
		while(!(str=br.readLine()).equals("0 0.00")) {
			st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			double m = Double.parseDouble(st.nextToken())*100;
			int o = (int) m;
//			System.out.println(n+" "+m+" "+o);
			
			int[] calories = new int[n];
			int[] prices = new int[n];
			
			int[] dp = new int[o+1];
//			System.out.println(dp.length);
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				calories[i] = Integer.parseInt(st.nextToken());
				prices[i] = (int) (Double.parseDouble(st.nextToken())*100+0.5);
			}
			// 초기값 설정.
			for(int i=0; i<calories.length; i++) {
				if(dp[prices[i]]==0) dp[prices[i]] += calories[i];
				else dp[prices[i]] = Math.max(dp[prices[i]], calories[i]);
			}
//			System.out.println(Arrays.toString(dp));
			// dp 연산
			for(int i=0; i<dp.length; i++) {
				for(int j=0; j<calories.length; j++) {
					if(i+prices[j]>=dp.length || dp[i]==0) continue;
//					System.out.println("i 값 : "+i + "j 값 : "+j +" price 값 : "+prices[j] + " 합 : "+(i+prices[j]));
					dp[i+prices[j]] = Math.max(dp[i+prices[j]], dp[i]+calories[j]);
				}
			}
//			System.out.println(Arrays.toString(dp));
			int max = 0;
			for(int a : dp) {
				max = Math.max(a, max);
			}
			System.out.println(max);
		}

	}

}
