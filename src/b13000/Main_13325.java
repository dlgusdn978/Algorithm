package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13325 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 트리 높이
		int k = Integer.parseInt(br.readLine());
		
		// 각 에지 값
		int[] edges = new int[(int) (Math.pow(2, k+1)-2)+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=Math.pow(2, k+1)-2; i++) {
			edges[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[(int) Math.pow(2, k+1)-2+1];

		int max = getMaxValue(edges, 0, dp);

		dp[1] = edges[1];
		dp[2] = edges[2];
		for(int i=3; i<dp.length; i++) {
			dp[i] = dp[i%2!=0 ? (i-1)/2 : (i-2)/2]+edges[i];
		}

		for(int i=1; i<dp.length; i++) {
			//dp[i] 값 계산
			// dp[i] + left , dp[i] + right 둘 다 max 값이랑 같지 않다면 차이가 더 작은 쪽의 수만큼 dp[i] 에 더하고 renewal
			// 하나라도 같다면 continue;
			int left = dp[i] + getMaxValue(edges, i*2+1, dp);
			int right = dp[i] + getMaxValue(edges, i*2+2, dp);
			if(left==max || right==max) continue;
			else {
				int leftGap = max - left;
				int rightGap = max - right;
				if(leftGap>=rightGap) {
					edges[i] += rightGap;
					dp[i] += rightGap;
					renewal(i, dp, rightGap);
				}else if(leftGap<rightGap) {
					edges[i] += leftGap;
					dp[i] += leftGap;
					renewal(i, dp ,leftGap);
				}
			}
		}
//		System.out.println(Arrays.toString(edges));
//		System.out.println(Arrays.toString(dp));
		long sum = 0;
		for(int a : edges) {
			sum+=a;
		}
		System.out.println(sum);
	}
	
	static void renewal(int index, int[] dp, int val) {
		if(index>=dp.length) {
			return;
		}
		
		dp[index] += val;
		renewal(index*2+1, dp, val);
		renewal(index*2+2, dp, val);
	}
	static int getMaxValue(int[] edges, int index, int[] dp) {
		if(index>=edges.length) {
			return 0;
		}
		
		int left = edges[index] + getMaxValue(edges, index*2+1, dp);
		int right = edges[index] + getMaxValue(edges, index*2+2, dp);
		 
		
		return Math.max(left, right);
	}
}
