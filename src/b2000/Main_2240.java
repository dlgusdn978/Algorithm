package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2240 {

	static class Node{
		int score;
		int cnt;
		public Node(int score, int cnt) {
			this.score = score;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// ���� ���?
		// 1. ���� ����Ƚ���� ���� ��� ������ ���� => ���������� �������� �ʰ� �����ϴ� ��� �ִ밪�� �� �� ����.
		// 2. ������� ������ ���� ��� ������ ���� => ���� ���ñ����� �ִ밪�� �� �� ������, ���Ŀ��� �ִ밪�� �� �� ���� ��쵵 ����.
		// 3. dfs+dp? ���� �������� ����o �� ����x�� ���� ���Ͽ� �� ū ���� �������� ����?
		// 4. 3���� dp Ȱ���ؼ�, �� time���� �� ����.
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// m �� �̵� ���� Ƚ��, n�� ��
		int[][][] dp = new int[m+1][n+1][2];
		
		for(int j=m; j>=0; j--) {
			for(int i=1; i<=n; i++) {
			
				// �ڵθ� ���� �� �ִ� ��ġ
				int cor = arr[i];
				// ��ġ �����ϴ� ���
				dp[j][i][0] = Math.max(dp[j][i][0], dp[j][i-1][0]+(cor==1 ? 1 : 0));
				if(j!=m) dp[j][i][1] = Math.max(dp[j][i][1], dp[j][i-1][1]+(cor==2 ? 1 : 0));
				// ��ġ �����ϴ� ���
				if(j-1>=0) dp[j-1][i][0] = Math.max(dp[j-1][i][0], dp[j][i-1][1]+(cor==1 ? 1 : 0));
				if(j-1>=0) dp[j-1][i][1] = Math.max(dp[j-1][i][1], dp[j][i-1][0]+(cor==2 ? 1 : 0));
			}
		}
		
		System.out.println(Math.max(dp[0][n][0], dp[0][n][1]));
	}

}
