package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Integer.MAX_VALUE;
		int[][] dp = new int[(1<<n)][n];
		for(int i=0; i<(1<<n); i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		// ����� 0�� ������ ����.
		dp[1][0] = 0;
		for(int i=1; i<(1<<n); i++) {
			for(int j=0; j<n; j++) {
				// 2������ ��ȯ�� �� �ִ� 10�������� Ȥ�� dp�� Ȱ���� �湮�� �� ���� �������� Ȯ��.
				if((i & (1<<j))==0 || dp[i][j]==Integer.MAX_VALUE) continue;
				for(int k=0; k<n; k++) {
					// �̹� �湮�߰ų� ���� ���� �����̶�� continue;
					if((i & (1<<k))!=0 || arr[j][k]==0) continue;
					int nextBit = i | (1<<k);
					// dp �ּҰ� ����
					dp[nextBit][k] = Math.min(dp[nextBit][k], dp[i][j]+arr[j][k]);
				}
			}
		}
		// dp[1<<n][?]�� ��ȸ�ϸ� �� �������� ���� ������ ���ư��� ��ΰ��� ���� ��, min ���� ���.
		for (int i = 1; i < n; i++) {
		    if (arr[i][0] == 0 || dp[(1 << n) - 1][i] == Integer.MAX_VALUE) continue;
		    min = Math.min(min, dp[(1 << n) - 1][i] + arr[i][0]);
		}
		System.out.println(min);
		
	}
	
}
