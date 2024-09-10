package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1082 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] costs = new int[n];
		st = new StringTokenizer(br.readLine());

		for(int i=0; i<n; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int total = Integer.parseInt(br.readLine());

		// 예를 들어, 50원을 가지고 있고
		// 1 9 -> 숫자
		// 1 50  -> 비용 이라 가정할 때
		// 최대로 만들 수 있는 숫자는 11.....111임
		// 자릿 수가 깡패임
		// dp 사용
		String[] dp = new String[total+1];
		for(int i=0; i<n; i++) {
			if(costs[i] < dp.length) dp[costs[i]] = String.valueOf(i);
		}

		
		for(int i=0; i<=total; i++) {
			if(dp[i]!=(null)) {
				for(int j=0; j<costs.length; j++) {
					if(i+costs[j]<=total) {
						if(dp[i+costs[j]]==null) {
							dp[i+costs[j]] = dp[i]+j;
						}else {
							dp[i+costs[j]] = new BigInteger(dp[i+costs[j]]).compareTo(new BigInteger(dp[i]+j)) > 0 ? dp[i+costs[j]] : dp[i]+j;
						}

					}
				}
			}
		}
		BigInteger res = new BigInteger("0");
		for(int i=0; i<dp.length; i++) {
			if(dp[i]!=null) res = res.compareTo(new BigInteger(dp[i])) >0 ? res : new BigInteger(dp[i]);
		}
		System.out.println(res.toString());
	}

}
