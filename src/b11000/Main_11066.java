package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11066 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// �� ������ �ϳ��� ��ħ.
		// ��ģ ����� �������� ��ġ�� �� ��� ���
		// ��� ���� ���� �� �ּ� ���� ��������.


		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<n; tc++) {
			int m = Integer.parseInt(br.readLine());
			
			int[] arr = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			} 
			
//			System.out.println(Arrays.toString(arr));
			
			int[][] dp = new int[m][m];
			int[] sum = new int[m];
			
			sum[0] = arr[0];
			for(int j=1; j<m; j++) {
				sum[j] = sum[j-1]+arr[j];
			}
			
			for (int len = 2; len <= m; len++) {  // ������ ����
	            for (int i = 0; i <= m - len; i++) {
	                int j = i + len - 1;
	                dp[i][j] = Integer.MAX_VALUE;

	                for (int k = i; k < j; k++) {
	                    int cost = dp[i][k] + dp[k + 1][j] + sumRange(sum, i, j);
	                    if (cost < dp[i][j]) {
	                        dp[i][j] = cost;
	                    }
//	                    print(dp);
	                }
//	                System.out.println();
	            }
	        }
			System.out.println(dp[0][m-1]);
		}
	}
	static void print(int[][] dp) {
		for(int[] a : dp) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	
	private static int sumRange(int[] sum, int i, int j) {
        if (i == 0) {
            return sum[j];
        }
        return sum[j] - sum[i - 1];
    }

}
