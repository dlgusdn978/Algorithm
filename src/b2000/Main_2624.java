package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2624 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		// ����� ������ ������ ��� ����� ���ΰ�?
		// �ݾ��� ���� �� �ִ� ����� �����ִ� ������ ���� ����ؾ� ��.
		
		int[][] arr = new int[k+1][2];
		for(int i=1; i<=k; i++) {
			st = new StringTokenizer(br.readLine());
			int val = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			arr[i][0] = val;
			arr[i][1] = cnt;
		}
		int[][] dp = new int[t+1][k+1];
		
		// ȭ�� ���� ����ŭ �ݺ�
		for(int i=1; i<=k; i++) {
			int val = arr[i][0];
			int cnt = arr[i][1];
			
			dp[0][i-1] = 1;
			// ȭ���� ���� * ���� 
			for(int j=1; j<=cnt; j++) {
				for(int l=j*val; l<=t; l++) {
					dp[l][i] += dp[l-j*val][i-1];
				}
			}
			for(int j=1; j<=t; j++) {
				dp[j][i] += dp[j][i-1];
			}
		}
		System.out.println(dp[t][k]);
	}

}
