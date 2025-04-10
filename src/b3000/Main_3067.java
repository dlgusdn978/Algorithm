package b3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3067 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			// ���� ���� ��
			int[] types = new int[Integer.parseInt(br.readLine())];
			st = new StringTokenizer(br.readLine());
			// ���� ���� ����
			for(int i=0; i<types.length; i++) {
				types[i] = Integer.parseInt(st.nextToken());
			}
			// ������ �ϴ� ��
			int val = Integer.parseInt(br.readLine());
			// �ʱ� �� ����
			int[] dp = new int[val+1];
		
			for(int i=0; i<types.length; i++) {
				for(int j=1; j<=val; j++) {
					if(j==types[i]) dp[j]++;
					else if(j>types[i]) dp[j] += dp[j-types[i]];
				}
			}
			System.out.println(dp[val]);
		}
		

	}

}
