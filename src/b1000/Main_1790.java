package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1790 {

	public static void main(String[] args) throws IOException {
		// 1->9
		// 10->89
		// 100->899
		// f(x) = 9*1(x=1), 9*10^(n-1)-1 (x>1)
		
		
		// �ڸ����� 5���� ��쿡��
		// 4���� ����� �ڸ������� ��� n���� ����.
		// 5�ڸ����� ���� ������ (n/5)��° ���� (�ڸ���-������)�� ���ϸ� �ȴ�.
		// ���� 1. ���� ���̰� k���� �۾Ƽ� k��° �ڸ��� ���� ��쿡�� -1 ���
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int pow = 1;
		int val = 10;
		int digits = 0;
		char ch = ' ';
		for(int i=1; i<=n; i++) {
			if(i>=val) {
				pow++;
				val = (int) Math.pow(10, pow);
			}
			digits += pow;
			if(digits>=k) {
				String str = String.valueOf(i);
				ch = str.charAt(str.length()-(digits>k ? digits-k : 0) - 1);
				break;
			}
		}

		if(digits>=k) {
			System.out.println(ch);
		}else {
			System.out.println(-1);
		}
	}

}
